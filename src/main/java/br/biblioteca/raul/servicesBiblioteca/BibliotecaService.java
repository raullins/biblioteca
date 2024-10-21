package br.biblioteca.raul.servicesBiblioteca;

import br.biblioteca.raul.modelsBiblioteca.Categoria;
import br.biblioteca.raul.modelsBiblioteca.Cliente;
import br.biblioteca.raul.modelsBiblioteca.Funcionario;
import br.biblioteca.raul.modelsBiblioteca.Livro;
import br.biblioteca.raul.repositoryBiblioteca.CategoriaRepository;
import br.biblioteca.raul.repositoryBiblioteca.ClienteRepository;
import br.biblioteca.raul.repositoryBiblioteca.FuncionarioRepository;
import br.biblioteca.raul.repositoryBiblioteca.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    private final FuncionarioRepository funcionarioRepository;
    private final ClienteRepository clienteRepository;
    private final LivroRepository livroRepository;
    private final CategoriaRepository categoriaRepository;

    public BibliotecaService(FuncionarioRepository funcionarioRepository,
                             ClienteRepository clienteRepository,
                             LivroRepository livroRepository,
                             CategoriaRepository categoriaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }
}
