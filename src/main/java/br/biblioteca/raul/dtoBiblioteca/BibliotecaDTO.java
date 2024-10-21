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
public class BibliotecaDTO {

    @NotNull
    @NotBlank
    private String nome;

    private List<FuncionarioDTO> funcionarios;
    private List<LivroDTO> livros;
    private List<CategoriaDTO> categorias;
    private List<ClienteDTO> clientes;
}