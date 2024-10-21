package br.biblioteca.raul.servicesBiblioteca;

import br.biblioteca.raul.exception.ItemNotFoundException;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.repositoryBiblioteca.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro alugarLivro(Long livroId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        //Verifica se há cópias disponíveis
        if (livro.getNumeroDeCopias() == 0) {
            throw new RuntimeException("Nenhuma cópia disponível para este livro.");
        }

        //Diminui o número de cópias disponíveis
        livro.setNumeroDeCopias(livro.getNumeroDeCopias() - 1);

        //Se o número de cópias for 0, o livro é considerado indisponível
        if (livro.getNumeroDeCopias() == 0) {
            livro.setSituacao("Indisponível");
        }

        return livroRepository.save(livro);
    }

    public Livro devolverLivro(Long livroId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        //Aumenta o número de cópias disponíveis
        livro.setNumeroDeCopias(livro.getNumeroDeCopias() + 1);

        //Se o número de cópias for maior que 0, o livro é considerado disponível
        if (livro.getNumeroDeCopias() > 0) {
            livro.setSituacao("Disponível");
        }

        return livroRepository.save(livro);
    }
}
