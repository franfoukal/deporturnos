package com.project.deporturnos.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    @NotNull
    private String nombre;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @Size(min = 12, max = 14)
    private String telefono;

}
