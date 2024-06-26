package com.project.deporturnos.entity.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CanchaRequestDTO {
    @Nullable
    private String nombre;
    @NotNull
    private String tipo;
    @NotNull
    private double precioHora;
    @NotNull
    private boolean disponibilidad;
    @Nullable
    private String descripcion;
}
