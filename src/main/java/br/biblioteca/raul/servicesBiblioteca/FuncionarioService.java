package br.biblioteca.raul.servicesBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Cliente;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.repositoryBiblioteca.ClienteRepository;
import br.biblioteca.raul.repositoryBiblioteca.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    private final LivroRepository livroRepository;
    private final ClienteRepository clienteRepository;

    public FuncionarioService(LivroRepository livroRepository, ClienteRepository clienteRepository) {
        this.livroRepository = livroRepository;
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public void atualizarLivro(Livro livro) {

        Optional<Livro> livroExistente = livroRepository.findById(livro.getId());

        if (livroExistente.isPresent()) {
            Livro toUpdate = livroExistente.get();
            toUpdate.setTitulo(livro.getTitulo());
            toUpdate.setAutor(livro.getAutor());
            toUpdate.setCategoriaPrincipal(livro.getCategoriaPrincipal());
            toUpdate.setNumeroDeCopias(livro.getNumeroDeCopias());
            toUpdate.setSituacao(livro.getSituacao());
            livroRepository.save(toUpdate);
        }
    }

    public void removerLivroDoAcervo(Livro livro) {
        livroRepository.delete(livro);
    }

    public void removerLivroDoAcervoPorId(Long id) {
        livroRepository.deleteById(id);
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(Cliente cliente) {

        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId());

        if (clienteExistente.isPresent()) {

            Cliente toUpdate = clienteExistente.get();

            toUpdate.setNome(cliente.getNome());
            toUpdate.setEmail(cliente.getEmail());
            toUpdate.setTelefone(cliente.getTelefone());

            clienteRepository.save(toUpdate);
        }
    }

    public void removerCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public void removerClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
