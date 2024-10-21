package br.biblioteca.raul.servicesBiblioteca;

import br.biblioteca.raul.exception.ItemNotFoundException;
import br.biblioteca.raul.modelsBiblioteca.Categoria;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.repositoryBiblioteca.CategoriaRepository;
import br.biblioteca.raul.repositoryBiblioteca.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final LivroRepository livroRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    public void adicionarLivro(Long categoriaId, Livro livro) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(categoriaId);
        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
            categoria.getLivros().add(livro);
            categoriaRepository.save(categoria);
        } else {
            throw new ItemNotFoundException("Categoria não encontrada.");
        }
    }

    public void removerLivro(Long categoriaId, Long livroId) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(categoriaId);
        Optional<Livro> livroOpt = livroRepository.findById(livroId);
        if (categoriaOpt.isPresent() && livroOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
            Livro livro = livroOpt.get();
            categoria.getLivros().remove(livro);
            categoriaRepository.save(categoria);
        } else {
            throw new ItemNotFoundException("Categoria ou Livro não encontrados.");
        }
    }
}
