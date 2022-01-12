package com.grupo3.app.Entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Perfil implements GrantedAuthority {


    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;


    @Override
    public String getAuthority() {
        return this.name;
    }
}
