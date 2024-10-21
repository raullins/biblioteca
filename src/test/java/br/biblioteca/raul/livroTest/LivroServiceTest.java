package br.biblioteca.raul.livroTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.repositoryBiblioteca.LivroRepository;
import br.biblioteca.raul.servicesBiblioteca.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa mocks
    }

    @Test
    void alugarLivro_copiaDisponivel() {
        // Arrange
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Java Programming");
        livro.setNumeroDeCopias(5);
        livro.setSituacao("Disponível");

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));
        when(livroRepository.save(livro)).thenReturn(livro);

        // Act
        Livro livroAlugado = livroService.alugarLivro(1L);

        // Assert
        assertNotNull(livroAlugado);
        assertEquals(4, livroAlugado.getNumeroDeCopias()); // Verifica se as cópias diminuíram
        assertEquals("Disponível", livroAlugado.getSituacao()); // Ainda deve estar disponível
        verify(livroRepository, times(1)).findById(1L);
        verify(livroRepository, times(1)).save(livro);
    }

    @Test
    void alugarLivro_semCopiaDisponivel() {
        // Arrange
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Java Programming");
        livro.setNumeroDeCopias(0);
        livro.setSituacao("Indisponível");

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            livroService.alugarLivro(1L);
        });

        assertEquals("Nenhuma cópia disponível para este livro.", exception.getMessage());
        verify(livroRepository, times(1)).findById(1L);
        verify(livroRepository, times(0)).save(livro);
    }

    @Test
    void devolverLivro() {
        // Arrange
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Java Programming");
        livro.setNumeroDeCopias(1); // Devolvendo uma cópia
        livro.setSituacao("Indisponível");

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));
        when(livroRepository.save(livro)).thenReturn(livro);

        // Act
        Livro livroDevolvido = livroService.devolverLivro(1L);

        // Assert
        assertNotNull(livroDevolvido);
        assertEquals(2, livroDevolvido.getNumeroDeCopias()); // Cópias aumentam após devolução
        assertEquals("Disponível", livroDevolvido.getSituacao()); // Deve estar disponível
        verify(livroRepository, times(1)).findById(1L);
        verify(livroRepository, times(1)).save(livro);
    }
}