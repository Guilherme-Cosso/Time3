package com.grupo3.app.Services;

import com.grupo3.app.Dto.UserDto;
import com.grupo3.app.Dto.UserFormDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface UserService {

    public UserDto save(@RequestBody UserFormDto userFormDto);

    public UserDto getUser(Long id);

    public List<UserDto> getUsers();

    boolean getUserEmail(String email);

    public UserDto updateUser(Long id, UserFormDto body);

    public void deletUser(Long id);
}
