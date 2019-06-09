package br.com.Lab4.dao;

import br.com.Lab4.domain.Categorias;

import java.util.List;

public interface CategoriasDao {

    void salvar(Categorias categorias);
    List<Categorias> recuperar();
    Categorias recuperarPorID(long id);
    void atualizar(Categorias categorias);
    void excluir(long id);

}