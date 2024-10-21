package br.biblioteca.raul.controllerBiblioteca;

import br.biblioteca.raul.servicesBiblioteca.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/alugar/{livroId}")
    public ResponseEntity<String> alugarLivro(@RequestParam Long clienteId, @PathVariable Long livroId) {
        clienteService.alugarLivro(clienteId, livroId);
        return ResponseEntity.ok("Livro alugado com sucesso.");
    }

    @PostMapping("/devolver/{livroId}")
    public ResponseEntity<String> devolverLivro(@RequestParam Long clienteId, @PathVariable Long livroId) {
        clienteService.devolverLivro(clienteId, livroId);
        return ResponseEntity.ok("Livro devolvido com sucesso.");
    }
}