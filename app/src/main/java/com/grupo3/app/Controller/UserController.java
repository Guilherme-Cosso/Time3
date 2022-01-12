package com.grupo3.app.Controller;

import com.grupo3.app.Dto.UserDto;
import com.grupo3.app.Dto.UserFormDto;
import com.grupo3.app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService service;

    // CRIA um novo User
    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserFormDto body){

        if(!this.service.getUserEmail(body.getEmail())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.service.save(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable  Long id){
        return ResponseEntity.ok(this.service.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(this.service.getUsers());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody  @Valid UserFormDto body){
        return ResponseEntity.ok(this.service.updateUser(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletAssociado(@PathVariable Long id){
        service.deletUser(id);
        return ResponseEntity.ok().build();
    }

}
