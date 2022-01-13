package com.grupo3.app.Controller;

import com.grupo3.app.Dto.AlunoDto;
import com.grupo3.app.Dto.AlunoFormDto;
import com.grupo3.app.Services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {


    @Autowired
    private AlunoService service;

    // CRIA um novo User
    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<AlunoDto> saveUser(@RequestBody @Valid AlunoFormDto body){

        if(!this.service.getUserEmail(body.getEmail())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.service.save(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> getUser(@PathVariable  Long id){
        return ResponseEntity.ok(this.service.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> getUsers(){
        return ResponseEntity.ok(this.service.getUsers());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<AlunoDto> updateUser(@PathVariable Long id, @RequestBody  @Valid AlunoFormDto body){
        return ResponseEntity.ok(this.service.updateUser(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletAssociado(@PathVariable Long id){
        service.deletUser(id);
        return ResponseEntity.ok().build();
    }

}
