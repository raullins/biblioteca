package br.biblioteca.raul.dtoBiblioteca;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FuncionarioDTOResponse {

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
    private String cargo;

    @NotNull
    @NotBlank
    private String login;
}