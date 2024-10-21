package br.biblioteca.raul.dtoBiblioteca;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    @Email
    private String email;
    private String telefone;
    private List<LivroDTO> livrosAlugados;
}
