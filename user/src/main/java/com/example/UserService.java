package com.example;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 
 
import org.springframework.stereotype.Service; 
 
@Service 
public class UserService { 
 List<User> users = new ArrayList<User>(Arrays.asList(new User(22L, "prasanna", "kumar", "prassu@gmail.com"), 
   new User(33L, "sai", "kumar", "sai@gmail.com"))); 
 
 public User getAll(User user) { 
  return users.add(user) ? user : null; 
 } 
 
 public List<User> getAll1() { 
  return users; 
 } 
 
 public User getById(long id) { 
  return users.stream().filter(us -> us.getId() == id).findFirst().get(); 
 } 
 
 public boolean deleteById(long id) { 
  User user = users.stream().filter(us -> us.getId() == id).findFirst().get(); 
  return users.remove(user); 
 } 
 
 public boolean updateData(Long id, User user) { 
  User presentedUser = users.stream().filter(us -> us.getId() == id).findFirst().get(); 
  presentedUser.setId(user.getId()); 
  presentedUser.setFaName(user.getFaName()); 
  presentedUser.setLName(user.getLName()); 
  presentedUser.setEmail(user.getEmail()); 
  return true; 
 } 
 
 public boolean partialUpdateById(long id, User user) { 
  User presentedUser = users.stream().filter(us -> us.getId() == id).findFirst().get(); 
  presentedUser.setId(user.getId()); 
  presentedUser.setFaName(user.getFaName()); 
  presentedUser.setLName(user.getLName()); 
  presentedUser.setEmail(user.getEmail()); 
  return true; 
   
 } 
 
}
