package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Response;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.LoginRequest;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/checkToken")
    ResponseEntity<?> checkToken() {
        return ResponseEntity.status(HttpStatus.OK).body(new Response("200", "successful", ""));
    }
	
	@PreAuthorize("hasAuthority('admin')")
    @GetMapping("/getAllRole")
    List<Role> getRole(){
        return userService.getRoles();
    }
	
	@GetMapping("/getUsers")
    List<User> getAllAccounts(){
        return userService.getAllUser();
    }
	
	@PostMapping("/register")
    ResponseEntity<Response> registerAccount(@RequestBody User newAcc){
        return userService.registerAccount(newAcc);
    }
	
	@PreAuthorize("#userId == authentication.principal.id")
    @GetMapping("/getUserInfo/{userId}")
    ResponseEntity<?> getUser(@PathVariable long userId) {
        return userService.getUser(userId);
    }
	
	//Thay đổi thông tin
	@PutMapping("/changeAccInfo/{id}")
	public ResponseEntity<Response> changeAccountInfo(@RequestBody User updatedAcc,@PathVariable long id){
		return userService.changeAccountInfo(updatedAcc, id);
	}
	
	@PreAuthorize("hasAuthority('admin') or hasAuthority('mod')")
    @PutMapping("/blockAcc/{id}")
    ResponseEntity<Response> block(@PathVariable long id){
        return userService.block(id);
    }
    @PutMapping("/changeAccRole/{id}")
    ResponseEntity<Response> changeRole(@RequestBody Role updatedRole,@PathVariable long id){
        return userService.changeRole(id,updatedRole);
    }
    @PutMapping("/changeAccPass/{id}")
    ResponseEntity<Response> changePass(@RequestBody User updatedAcc,@PathVariable long id){
        return userService.changePass(id,updatedAcc);
    }
    
    
    @PostMapping("/login")
    ResponseEntity<?> authenticateAccount(@Valid @RequestBody LoginRequest loginRequest){
        return userService.authenticateAccount(loginRequest);
    }
	
    @GetMapping("/logoutsuccess")
    ResponseEntity<Response> getLogoutSuccess(){
        return userService.getLogoutSuccess();
    }

}
