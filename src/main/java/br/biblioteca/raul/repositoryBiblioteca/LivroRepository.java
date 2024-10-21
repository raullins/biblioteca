package br.biblioteca.raul.repositoryBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
