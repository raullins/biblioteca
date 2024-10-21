package br.biblioteca.raul.controllerBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.servicesBiblioteca.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/{categoriaId}/adicionar-livro")
    public ResponseEntity<String> adicionarLivro(@PathVariable Long categoriaId, @RequestBody Livro livro) {
        categoriaService.adicionarLivro(categoriaId, livro);
        return ResponseEntity.ok("Livro adicionado à categoria com sucesso.");
    }

    @DeleteMapping("/{categoriaId}/remover-livro/{livroId}")
    public ResponseEntity<String> removerLivro(@PathVariable Long categoriaId, @PathVariable Long livroId) {
        categoriaService.removerLivro(categoriaId, livroId);
        return ResponseEntity.ok("Livro removido da categoria com sucesso.");
    }
}
