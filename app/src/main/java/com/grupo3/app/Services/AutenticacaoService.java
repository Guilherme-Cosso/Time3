package com.grupo3.app.Services;

import com.grupo3.app.Dto.LoginForm;
import org.springframework.stereotype.Service;

@Service
public interface AutenticacaoService {
    public void verificarUser(LoginForm body);
}
