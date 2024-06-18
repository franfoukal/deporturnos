package com.project.deporturnos.configuration;

import com.project.deporturnos.entity.domain.Rol;
import com.project.deporturnos.entity.domain.Usuario;
import com.project.deporturnos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAdminLoader implements ApplicationRunner {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        Usuario usuario = Usuario.builder()
                .nombre("FirstAdmin")
                .email("firstAdmin@gmail.com")
                .password(passwordEncoder.encode("admin"))
                .rol(Rol.ADMIN)
                .cuentaActivada(true)
                .build();

        if(usuarioRepository.findByEmail(usuario.getEmail()).isEmpty()){
           usuarioRepository.save(usuario);
        }
    }
}
