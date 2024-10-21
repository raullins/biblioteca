package br.biblioteca.raul.servicesBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Cliente;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.repositoryBiblioteca.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final LivroService livroService;

    public ClienteService(ClienteRepository clienteRepository, LivroService livroService) {
        this.clienteRepository = clienteRepository;
        this.livroService = livroService;
    }

    public void alugarLivro(Long clienteId, Long livroId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Livro livro = livroService.alugarLivro(livroId); //Chama o serviço para alugar o livro
        cliente.getLivrosAlugados().add(livro); //Adiciona à lista de livros alugados do cliente
        clienteRepository.save(cliente);
    }

    public void devolverLivro(Long clienteId, Long livroId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Livro livro = livroService.devolverLivro(livroId); //Chama o serviço para devolver o livro
        cliente.getLivrosAlugados().remove(livro); //Remove da lista de livros alugados do cliente
        clienteRepository.save(cliente);
    }
}
