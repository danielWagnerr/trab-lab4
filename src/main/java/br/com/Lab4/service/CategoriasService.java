package br.com.Lab4.service;

import br.com.Lab4.domain.Categorias;

import java.util.List;

public interface CategoriasService {

    void salvar(Categorias categorias);
    List<Categorias> recuperar();
    Categorias recuperarPorId(long id);
    void atualizar(Categorias categorias);
    void excluir(long id);

}