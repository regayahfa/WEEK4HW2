package com.example.week4hw2.controller;

import com.example.week4hw2.model.User;
import com.example.week4hw2.sirsveis.UserServies;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class Usercontroller {
   private final UserServies userServies;

   @GetMapping("/get")
   public ResponseEntity getAlluser(){
       List<User>userList=userServies.getAlluser();
       return ResponseEntity.status(200).body(userList);
   }
   @PutMapping("/add")
   public  ResponseEntity adduser(@Valid @RequestBody User user, Errors errors){
       if(errors.hasErrors()){
           String masegge=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(masegge);
       }
       userServies.adduser(user);
       return ResponseEntity.status(200).body("USER adde");
   }
   public ResponseEntity updateuser(@Valid @RequestBody User user, Errors errors){
       if (errors.hasErrors()){
           String massege=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(massege);
       }
       boolean isupdated=userServies.updateuser(1,user);
       return ResponseEntity.status(200).body("is updated");
   }
public ResponseEntity deleteuser(@Valid @RequestBody User user,@PathVariable Integer ID){
if(userServies.deleteuser(ID)){
    return ResponseEntity.status(200).body("USER DELETED");
}
return ResponseEntity.status(400).body("DELETED");
}
}
