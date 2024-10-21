package br.biblioteca.raul.modelsBiblioteca;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_biblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "biblioteca_id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany
    @JoinColumn(name = "biblioteca_id")
    private List<Funcionario> funcionarios;

    @OneToMany
    @JoinColumn(name = "biblioteca_id")
    private List<Livro> livros;

    @OneToMany
    @JoinColumn(name = "biblioteca_id")
    private List<Categoria> categorias;

    @OneToMany
    @JoinColumn(name = "biblioteca_id")
    private List<Cliente> clientes;
}