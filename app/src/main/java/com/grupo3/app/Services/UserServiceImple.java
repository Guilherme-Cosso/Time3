package com.grupo3.app.Services;

import com.grupo3.app.Dto.UserDto;
import com.grupo3.app.Dto.UserFormDto;
import com.grupo3.app.Entity.User;
import com.grupo3.app.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper;




    @Override
    public UserDto save(UserFormDto body) {

        User user = modelMapper.map(body, User.class);
        System.out.println(user.getName());
        User userSave = this.userRepository.save(user);
        return  modelMapper.map(userSave, UserDto.class);
    }

    @Override
    public UserDto getUser(Long id) {
        User user = this.userRepository.getOne(id);
        return modelMapper.map(user,UserDto.class);
    }

}