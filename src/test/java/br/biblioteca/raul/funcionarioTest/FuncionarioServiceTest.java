package br.biblioteca.raul.funcionarioTest;

import br.biblioteca.raul.BibliotecaApplication;
import br.biblioteca.raul.modelsBiblioteca.Cliente;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.repositoryBiblioteca.ClienteRepository;
import br.biblioteca.raul.repositoryBiblioteca.LivroRepository;
import br.biblioteca.raul.servicesBiblioteca.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ContextConfiguration(classes= BibliotecaApplication.class)
@SpringBootTest
public class FuncionarioServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private FuncionarioService funcionarioService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCadastrarLivro() {
        Livro livro = new Livro();
        livro.setTitulo("Livro Teste");
        funcionarioService.cadastrarLivro(livro);

        verify(funcionarioService, times(1)).cadastrarLivro(livro);
    }


    @Test
    public void testAtualizarLivroComSucesso() {
        Livro livroExistente = new Livro();
        livroExistente.setId(1L);
        livroExistente.setTitulo("Livro Antigo");
        when(livroRepository.findById(1L)).thenReturn(Optional.of(livroExistente));

        Livro livroParaAtualizar = new Livro();
        livroParaAtualizar.setId(1L);
        livroParaAtualizar.setTitulo("Novo Título");

        funcionarioService.atualizarLivro(livroParaAtualizar);

        verify(funcionarioService, times(1)).atualizarLivro(any(Livro.class));
        ArgumentCaptor<Livro> livroCaptor = ArgumentCaptor.forClass(Livro.class);
        verify(funcionarioService).atualizarLivro(livroCaptor.capture());
        Livro livroAtualizado = livroCaptor.getValue();
        assertEquals("Novo Título", livroAtualizado.getTitulo());
    }


    @Test
    public void testRemoverLivroDoAcervo() {
        Livro livro = new Livro();
        funcionarioService.removerLivroDoAcervo(livro);

        verify(funcionarioService, times(1)).removerLivroDoAcervo(livro);
    }


    @Test
    public void testRemoverLivroDoAcervoPorId() {
        Long id = 1L;
        funcionarioService.removerLivroDoAcervoPorId(id);

        verify(funcionarioService, times(1)).removerLivroDoAcervoPorId(id);
    }


    @Test
    public void testCadastrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Teste");
        funcionarioService.cadastrarCliente(cliente);

        verify(funcionarioService, times(1)).cadastrarCliente(cliente);
    }


    @Test
    public void deveAtualizarClienteComSucesso() {
        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(1L);
        clienteExistente.setNome("Cliente Antigo");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteExistente));

        Cliente clienteParaAtualizar = new Cliente();
        clienteParaAtualizar.setId(1L);
        clienteParaAtualizar.setNome("Novo Nome");

        funcionarioService.atualizarCliente(clienteParaAtualizar);

        verify(funcionarioService, times(1)).atualizarCliente(any(Cliente.class));
        ArgumentCaptor<Cliente> clienteCaptor = ArgumentCaptor.forClass(Cliente.class);
        verify(funcionarioService).atualizarCliente(clienteCaptor.capture());
        Cliente
        clienteAtualizado = clienteCaptor.getValue();
        assertEquals("Novo Nome", clienteAtualizado.getNome());
    }


    @Test
    public void testRemoverCliente() {
        Cliente cliente = new Cliente();
        funcionarioService.removerCliente(cliente);

        verify(funcionarioService, times(1)).removerCliente(cliente);
    }


    @Test
    public void testRemoverClientePorId() {
        Long id = 1L;
        funcionarioService.removerClientePorId(id);

        verify(funcionarioService, times(1)).removerClientePorId(id);
    }
}