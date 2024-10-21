package br.biblioteca.raul.controllerBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Cliente;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.servicesBiblioteca.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/livros")
    public ResponseEntity<String> cadastrarLivro(@RequestBody Livro livro) {
        funcionarioService.cadastrarLivro(livro);
        return ResponseEntity.ok("Livro cadastrado com sucesso.");
    }

    @PutMapping("/livros/{id}")
    public ResponseEntity<String> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        funcionarioService.atualizarLivro(livro);
        return ResponseEntity.ok("Livro atualizado com sucesso.");
    }

    @DeleteMapping("/livros/{id}")
    public ResponseEntity<String> removerLivro(@PathVariable Long id) {
        funcionarioService.removerLivroDoAcervoPorId(id);
        return ResponseEntity.ok("Livro removido com sucesso.");
    }

    @PostMapping("/clientes")
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
        funcionarioService.cadastrarCliente(cliente);
        return ResponseEntity.ok("Cliente cadastrado com sucesso.");
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        funcionarioService.atualizarCliente(cliente);
        return ResponseEntity.ok("Cliente atualizado com sucesso.");
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<String> removerClientePrId(@PathVariable Long id) {
        funcionarioService.removerClientePorId(id);
        return ResponseEntity.ok("Cliente removido com sucesso.");
    }
}
