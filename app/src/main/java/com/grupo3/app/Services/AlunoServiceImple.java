package com.grupo3.app.Services;

import com.grupo3.app.Dto.AlunoDto;
import com.grupo3.app.Dto.AlunoFormDto;
import com.grupo3.app.Dto.PerfilDto;
import com.grupo3.app.Entity.Aluno;
import com.grupo3.app.Entity.Perfil;
import com.grupo3.app.Repository.AlunoRepository;
import com.grupo3.app.Repository.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImple implements AlunoService{

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AlunoDto save(AlunoFormDto body) {
        Aluno user = modelMapper.map(body, Aluno.class);
        user.setMatricula(geraMatricula());
        Optional<Perfil> perfil = perfilRepository.findById(1L);
        List<Perfil> perfils = new ArrayList<>();
        if (perfil.isPresent()){
            perfils.add(perfil.get());
            user.setPerfis(perfils);
        }
        Aluno userSave = this.alunoRepository.save(user);
        return  modelMapper.map(userSave, AlunoDto.class);
    }

    private String geraMatricula(){
        Random mat = new Random();
        String matricula = String.valueOf(mat.nextInt());
        Optional<Aluno> aluno = alunoRepository.findByMatricula(matricula);
        while (aluno.isPresent()){
            matricula = String.valueOf(mat.nextInt());
            aluno = alunoRepository.findByMatricula(matricula);
        }
        return matricula;
    }



    @Override
    public AlunoDto getUser(Long id) {
        Aluno user = this.alunoRepository.getOne(id);
        return modelMapper.map(user,AlunoDto.class);
    }

    @Override
    public List<AlunoDto> getUsers() {
        List<Aluno> list = this.alunoRepository.findAll();
        return  list.stream().map(pa ->  modelMapper.map(pa, AlunoDto.class)).collect(Collectors.toList());
    }

    @Override
    public boolean getUserEmail(String email) {
        List<Aluno> list = this.alunoRepository.findByEmail(email);
        boolean resp = list.size() == 0;
        return resp;
    }

    @Override
    public AlunoDto updateUser(Long id, AlunoFormDto body) {
        Aluno user = alunoRepository.getOne(id);
        user.setNome(body.getNome());
        user.setCpf(body.getCpf());
        user.setEmail(body.getEmail());
        user.setTelefone(body.getTelefone());
        return  modelMapper.map(user, AlunoDto.class);
    }

    @Override
    public void deletUser(Long id) {
        alunoRepository.deleteById(id);
    }

}
