package br.com.Lab4.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "generos")
public class Generos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String nome;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String descricao;

    @OneToMany(mappedBy = "generos", cascade = CascadeType.ALL)
    private List<Conteudos> conteudos;

    @ManyToOne
    @JoinColumn(name = "id_categorias_fk")
    private Categorias categorias;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public List<Conteudos> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudos> conteudos) {
        this.conteudos = conteudos;
    }

}
