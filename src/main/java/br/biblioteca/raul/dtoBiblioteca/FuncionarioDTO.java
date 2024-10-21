package br.biblioteca.raul.dtoBiblioteca;

import br.biblioteca.raul.validationBiblioteca.CargoValido;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FuncionarioDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    @Email
    private String email;

    private String telefone;

    @NotNull
    @NotBlank
    @CargoValido
    private String cargo;

    @NotNull
    @NotBlank
    private String login;

    @NotNull
    @NotBlank
    private String senha;
}