package br.biblioteca.raul.repositoryBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByUsername(String username);
}
