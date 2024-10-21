package br.biblioteca.raul.repositoryBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}