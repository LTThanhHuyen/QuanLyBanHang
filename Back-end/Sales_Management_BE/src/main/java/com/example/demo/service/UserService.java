package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.JWT.JwtUtils;
import com.example.demo.model.Product;
import com.example.demo.model.Response;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.JwtResponse;
import com.example.demo.payload.LoginRequest;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	TimeService timeService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	// Đăng ký tài khoản
	public ResponseEntity<Response> registerAccount(User newAcc){
		Optional<User> foundAcc= userRepository.findByUsername(newAcc.getUsername());
        if(foundAcc.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new Response("Fail","ten dang nhap da ton tai",""));
        } else {
            foundAcc=userRepository.findByEmail(newAcc.getEmail());
            if(foundAcc.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(new Response("Fail","Email da ton tai",""));
            } else {
                Role newRole=roleRepository.findByName("user");
                newAcc.setRole(newRole);
                newAcc.setPassword(passwordEncoder.encode(newAcc.getPassword()));
//                newAcc.setName(newAcc.getName());
//                newAcc.setAddress(newAcc.getAddress());
//                newAcc.setPhone(newAcc.getPhone());
                newAcc.setCreatedat(timeService.getCurrentTimestamp());
                newAcc.setIsblocked(false);
                return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Da Dang ky thanh cong",userRepository.save(newAcc)));
            } 
        }
	}
	
	//Thay đổi thông tin
	public ResponseEntity<Response> changeAccountInfo(User updatedAcc,long id){
        userRepository.findById(id).map(acc ->{
        	if(updatedAcc.getName()!=null)
                acc.setName(updatedAcc.getName());
            if(updatedAcc.getAddress()!=null)
                acc.setAddress(updatedAcc.getAddress());
            if(updatedAcc.getPhone()!=null)
                acc.setPhone(updatedAcc.getPhone());
//            if(updatedAcc.getPassword()!=null)
//                acc.setPassword(passwordEncoder.encode(updatedAcc.getPassword()));
            acc.setUpdatedat(timeService.getCurrentTimestamp());
            return userRepository.save(acc);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Da cap nhat",updatedAcc));
    }
	
    public ResponseEntity<Response> block(long id){
        userRepository.findById(id).map(acc ->{
            if(acc.getIsblocked()==false) 
                acc.setIsblocked(true);
            else
                acc.setIsblocked(false);
            return userRepository.save(acc);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Da cap nhat",""));
    }
    
    // thay ddooir quyeen
    public ResponseEntity<Response> changeRole(long id,Role updatedRole) {
        userRepository.findById(id).map(acc ->{
            acc.setRole(updatedRole);
            return userRepository.save(acc);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Da cap nhat",""));
    }
    
    public ResponseEntity<Response> changePass(long id,User updatedAcc) {
        userRepository.findById(id).map(acc ->{
            acc.setPassword(passwordEncoder.encode(updatedAcc.getPassword()));
            return userRepository.save(acc);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Da cap nhat",""));
    }
    // dawng nhap
    public ResponseEntity<?> authenticateAccount(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken((UserDetailsImpl) authentication.getPrincipal());
        UserDetailsImpl accDetails = (UserDetailsImpl) authentication.getPrincipal();    
        return ResponseEntity.ok(new JwtResponse(jwt, accDetails)); 
    }
    
    //dawng xuat
    public ResponseEntity<Response> getLogoutSuccess(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Da Dang Xuat",""));
    }
}
