package com.grupo3.app.Services;

import com.grupo3.app.Dto.UserDto;
import com.grupo3.app.Dto.UserFormDto;
import com.grupo3.app.Entity.User;
import com.grupo3.app.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto save(UserFormDto body) {
        User user = modelMapper.map(body, User.class);
        User userSave = this.userRepository.save(user);
        return  modelMapper.map(userSave, UserDto.class);
    }

    @Override
    public UserDto getUser(Long id) {
        User user = this.userRepository.getOne(id);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> list = this.userRepository.findAll();
        return  list.stream().map(pa ->  modelMapper.map(pa, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public boolean getUserEmail(String email) {
        List<User> list = this.userRepository.findByEmail(email);
        boolean resp = list.size() == 0;
        return resp;
    }

    @Override
    public UserDto updateUser(Long id, UserFormDto body) {
        User user = userRepository.getOne(id);
        user.setName(body.getName());
        user.setCpf(body.getCpf());
        user.setEmail(body.getEmail());
        user.setTelefone(body.getTelefone());
        user.setMatricula(body.getMatricula());
        return  modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deletUser(Long id) {
        userRepository.deleteById(id);
    }

}
