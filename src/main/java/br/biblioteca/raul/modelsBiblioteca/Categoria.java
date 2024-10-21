package br.biblioteca.raul.modelsBiblioteca;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_categoria")
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoria_id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany
    @JoinColumn(name = "categoria_id")
    private List<Livro> livros;
}