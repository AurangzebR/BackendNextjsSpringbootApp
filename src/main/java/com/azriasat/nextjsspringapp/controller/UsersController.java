package com.azriasat.nextjsspringapp.controller;

import com.azriasat.nextjsspringapp.entity.Users;
import com.azriasat.nextjsspringapp.models.UsersModel;
import com.azriasat.nextjsspringapp.service.UsersService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {

    private UsersService usersService;


    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("users")
    public UsersModel saveUser(@RequestBody UsersModel usersModel){
        return usersService.saveUser(usersModel);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UsersModel> getUserWithId(@PathVariable("id") Long id){
        UsersModel usersModel = usersService.getUserWithId(id);
        return ResponseEntity.ok(usersModel);
    }
    @PutMapping("users/{id}")
    public ResponseEntity<UsersModel> updateUsers(@PathVariable("id") Long id , @RequestBody UsersModel usersModel){
        usersService.updateUser(id,usersModel);
        return ResponseEntity.ok(usersModel);
    }
    @DeleteMapping("users/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUsers(@PathVariable("id") Long id){
        boolean deleted =false;
        Map<String, Boolean> response = new HashMap<>();
        deleted= usersService.deleteUser(id);
        response.put("deleted" , deleted);
        return ResponseEntity.ok(response);

    }
    @GetMapping("users")
    public List<UsersModel> getAllusers(){
        List<UsersModel> user =
        usersService.usersList();
        return user;
    }
}
