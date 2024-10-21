package br.biblioteca.raul.controllerBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Categoria;
import br.biblioteca.raul.modelsBiblioteca.Cliente;
import br.biblioteca.raul.modelsBiblioteca.Funcionario;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.servicesBiblioteca.BibliotecaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> listarFuncionarios() {
        return bibliotecaService.getFuncionarios();
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return bibliotecaService.getClientes();
    }

    @GetMapping("/livros")
    public List<Livro> listarLivros() {
        return bibliotecaService.getLivros();
    }

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return bibliotecaService.getCategorias();
    }
}
