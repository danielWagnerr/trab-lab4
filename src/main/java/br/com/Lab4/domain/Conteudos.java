package br.com.Lab4.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "conteudos")
public class Conteudos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String titulo;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String sinopse;

    @NotBlank
    @Column(nullable = false)
    private String avaliacao;



    @ManyToOne
    @JoinColumn(name = "id_generos_fk")
    private Generos generos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }


    public Generos getGeneros() {
        return generos;
    }

    public void setGeneros(Generos generos) {
        this.generos = generos;
    }

}
