package com.example;

import lombok.AllArgsConstructor;import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
 private long id; 
 private String faName;
 private String lName; 
 private String email;
}