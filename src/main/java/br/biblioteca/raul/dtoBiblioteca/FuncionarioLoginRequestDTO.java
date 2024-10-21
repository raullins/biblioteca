package br.biblioteca.raul.dtoBiblioteca;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioLoginRequestDTO {
    private String username;
    private String password;
}
