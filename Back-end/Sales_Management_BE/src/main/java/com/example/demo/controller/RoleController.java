package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/roles")
public class RoleController {
//	@Autowired
//	RoleService roleService;
//	@GetMapping("")
//	public List<Role> getAllRoles(){
//		return roleService.getAllRoles();
//	}

}
