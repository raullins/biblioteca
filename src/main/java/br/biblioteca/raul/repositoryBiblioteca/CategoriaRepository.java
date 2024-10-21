package br.biblioteca.raul.repositoryBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
