package br.biblioteca.raul.dtoBiblioteca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String nome;
    private List<LivroDTO> livros;
}
