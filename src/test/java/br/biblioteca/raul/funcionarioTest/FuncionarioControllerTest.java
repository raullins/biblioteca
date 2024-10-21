package br.biblioteca.raul.funcionarioTest;

import br.biblioteca.raul.BibliotecaApplication;
import br.biblioteca.raul.controllerBiblioteca.FuncionarioController;
import br.biblioteca.raul.modelsBiblioteca.Cliente;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.servicesBiblioteca.FuncionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes= BibliotecaApplication.class)
@WebMvcTest(FuncionarioController.class)
public class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private FuncionarioService funcionarioService;

    @InjectMocks
    private FuncionarioController funcionarioController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
    }

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcyOTQ3NjE4MCwiZXhwIjoxNzI5NDc5NzgwfQ.AGSOdQJM1vzmoKEJUgVH0PJCQT49X8PPQ1bDKeMD4fo";


    @Test
    public void testCadastrarLivro() throws Exception {
        Livro livro = new Livro();
        livro.setTitulo("Livro Teste");
        livro.setAutor("Autor Teste");

        mockMvc.perform(post("/funcionarios/livros")
//                        .with(request -> {
//                            request.addHeader("Authorization", "Bearer " + token);
//                            return request;
//                        })
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livro)))
                .andExpect(status().isOk())
                .andExpect(content().string("Livro cadastrado com sucesso."));

        verify(funcionarioService, times(1)).cadastrarLivro(any(Livro.class));
    }


    @Test
    public void testAtualizarLivro() throws Exception {
        Livro livro = new Livro();
        livro.setTitulo("Livro Atualizado");

        mockMvc.perform(put("/funcionarios/livros/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(livro)))
                .andExpect(status().isOk())
                .andExpect(content().string("Livro atualizado com sucesso."));

        verify(funcionarioService, times(1)).atualizarLivro(any(Livro.class));
    }


    @Test
    public void testRemoverLivro() throws Exception {
        mockMvc.perform(delete("/funcionarios/livros/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Livro removido com sucesso."));

        verify(funcionarioService, times(1)).removerLivroDoAcervoPorId(1L);
    }


    @Test
    public void testCadastrarCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Teste");
        cliente.setEmail("cliente@teste.com");

        mockMvc.perform(post("/funcionarios/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente cadastrado com sucesso."));

        verify(funcionarioService, times(1)).cadastrarCliente(any(Cliente.class));
    }


    @Test
    public void testAtualizarCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Atualizado");

        mockMvc.perform(put("/funcionarios/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente atualizado com sucesso."));

        verify(funcionarioService, times(1)).atualizarCliente(any(Cliente.class));
    }


    @Test
    public void testRemoverCliente() throws Exception {
        mockMvc.perform(delete("/funcionarios/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente removido com sucesso."));

        verify(funcionarioService, times(1)).removerClientePorId(1L);
    }
}