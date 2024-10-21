package br.biblioteca.raul.repositoryBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
