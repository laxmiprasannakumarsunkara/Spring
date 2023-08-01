package com.example;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class UserController {
		
		@Autowired
		UserService service;
		
		@PostMapping("/saveuser")
		public User SaveUser(@RequestBody User user) {
			return service.saveData(user);
		}
		@GetMapping("/users")
		public List<User> getAllUsers(){
			return service.getAllUsers();
			
		}
		
		@GetMapping("/user/{id}")
		public User getUser(@PathVariable Long id){
			return service.getUsers(id);
			
		}
		
		@PostMapping("/basedOnID")
		public User basedOnID(@RequestBody User user) {
			User outPutdata =  service.getDetailsBasedOnID(user);
			 return outPutdata;
		}
		
		@DeleteMapping("/deletbyid/{id}")
		public String DeleteByid(@PathVariable Long id) {
			return service.delete(id)?"deleted Sucessfully":"not deleted";
		}
		@PutMapping("/update/{id}")
		public User updateById(@PathVariable Long id ,@RequestBody User user) {
			return service.updateById(id,user);
		}
		
		@PatchMapping("/partial/{id}")
		public User pupdate(@PathVariable Long id, @RequestBody Map<String, Object> newData) {
			return service.partialUpdate(id,newData);
			
		}
		



}
