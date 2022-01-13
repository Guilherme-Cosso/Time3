package com.grupo3.app.Services;

import com.grupo3.app.Dto.AlunoDto;
import com.grupo3.app.Dto.AlunoFormDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface UserService {

    public AlunoDto save(@RequestBody AlunoFormDto userFormDto);

    public AlunoDto getUser(Long id);

    public List<AlunoDto> getUsers();

    boolean getUserEmail(String email);

    public AlunoDto updateUser(Long id, AlunoFormDto body);

    public void deletUser(Long id);
}
