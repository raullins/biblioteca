package br.biblioteca.raul.dtoBiblioteca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LivroDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    private String autor;

    @NotNull
    @NotBlank
    private String categoriaPrincipal;

    private Integer numeroDeCopias;

    private String situacao;
}