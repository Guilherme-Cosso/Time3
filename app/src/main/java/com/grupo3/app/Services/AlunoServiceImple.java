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
    private AlunoRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AlunoDto save(AlunoFormDto body) {
        Aluno user = modelMapper.map(body, Aluno.class);
        Random mat = new Random();
        user.setMatricula(String.valueOf(mat.nextInt()));
        Optional<Perfil> perfil = perfilRepository.findById(1L);
        List<Perfil> perfils = new ArrayList<>();
        if (perfil.isPresent()){
            perfils.add(perfil.get());
            user.setPerfis(perfils);
        }
        Aluno userSave = this.userRepository.save(user);
        return  modelMapper.map(userSave, AlunoDto.class);
    }



    @Override
    public AlunoDto getUser(Long id) {
        Aluno user = this.userRepository.getOne(id);
        return modelMapper.map(user,AlunoDto.class);
    }

    @Override
    public List<AlunoDto> getUsers() {
        List<Aluno> list = this.userRepository.findAll();
        return  list.stream().map(pa ->  modelMapper.map(pa, AlunoDto.class)).collect(Collectors.toList());
    }

    @Override
    public boolean getUserEmail(String email) {
        List<Aluno> list = this.userRepository.findByEmail(email);
        boolean resp = list.size() == 0;
        return resp;
    }

    @Override
    public AlunoDto updateUser(Long id, AlunoFormDto body) {
        Aluno user = userRepository.getOne(id);
        user.setName(body.getName());
        user.setCpf(body.getCpf());
        user.setEmail(body.getEmail());
        user.setTelefone(body.getTelefone());
        return  modelMapper.map(user, AlunoDto.class);
    }

    @Override
    public void deletUser(Long id) {
        userRepository.deleteById(id);
    }

}
