package br.biblioteca.raul.modelsBiblioteca;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_livro")
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "livro_id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "categoria_principal")
    private String categoriaPrincipal;

    @Column(name = "numero_de_copias")
    private Integer numeroDeCopias;

    @Column(name = "situacao")
    private String situacao;
}