package com.grupo3.app.Controller;

import com.grupo3.app.Dto.UserDto;
import com.grupo3.app.Dto.UserFormDto;
import com.grupo3.app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService service;

    // CRIA um novo User
    @PostMapping
    @Transactional
    public ResponseEntity<UserDto> saveUser(@RequestBody UserFormDto body){
        UserDto userDto = this.service.save(body);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable  Long id){
        return ResponseEntity.ok(this.service.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(this.service.getUsers());
    }

    


}
