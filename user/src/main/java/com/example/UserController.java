package com.example;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PatchMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
 
@RestController 
public class UserController { 
 @Autowired 
 UserService userService; 
 
 @RequestMapping("/wish") 
 public String wish() { 
  return "first rest call Application"; 
 } 
 
 @PostMapping("/save") 
 public User saveData(@RequestBody User user) { 
  return userService.getAll(user); 
 } 
 @GetMapping("/data") 
 public List<User> saveData() { 
  return userService.getAll1(); 
 } 
 
 @GetMapping("/user/{id}") 
 public User getUser(@PathVariable long id) { 
  return userService.getById(id); 
 } 
 @DeleteMapping("/delete/{id}") 
 public String deleteData(@PathVariable long id) { 
  return userService.deleteById(id)?"success":"delete fail"; 
 } 
 @PutMapping("/update/{id}") 
 public String updateUser(@PathVariable Long id, @RequestBody User user) { 
  return userService.updateData(id,user)?"data updated success":"data not updated"; 
 } 
 @PatchMapping("/partialupdate/{id}") 
 public String partialUpdate(@PathVariable long id,@RequestBody User user) { 
   
  return userService.partialUpdateById(id,user)?"success":"fail"; 
 } 
  
}