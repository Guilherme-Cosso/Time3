package com.grupo3.app.Controller;

import com.grupo3.app.Dto.LivroDto;
import com.grupo3.app.Dto.LivroFormDto;
import com.grupo3.app.Dto.VincularLivroUserDto;
import com.grupo3.app.Repository.UserRepository;
import com.grupo3.app.Services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {


    @Autowired
    private LivroService service;

    // CRIA um novo Livro
    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<LivroDto> saveLivro(@RequestBody @Valid LivroFormDto body) {
        return ResponseEntity.ok(this.service.save(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getLivro(id));
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> getLivros() {
        return ResponseEntity.ok(this.service.getLivros());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<LivroDto> updateLivro(@PathVariable Long id, @RequestBody @Valid LivroFormDto body) {
        return ResponseEntity.ok(this.service.updateLivro(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletAssociado(@PathVariable Long id) {
        service.deleteLivro(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/usuario")
    @Transactional
    public ResponseEntity<LivroDto> livroUser(@RequestBody VincularLivroUserDto body) {
        return ResponseEntity.ok(this.service.livroUser(body));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<LivroDto>> livrosAssociados(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.livrosAssociados(id));
    }

    @DeleteMapping("/{idl}/usuario/{id}")
    @Transactional
    public ResponseEntity<LivroDto> deletAssociadoPartido(@PathVariable Long id ,@PathVariable Long idl){
        return ResponseEntity.ok(service.deletLivroUsuario(id, idl));
    }






}
