package br.com.Lab4.dao;

import br.com.Lab4.domain.Generos;

import java.util.List;

public interface GenerosDao {

    void salvar(Generos generos);
    List<Generos> recuperarPorCategorias(long categoriasId);
    Generos recuperarPorCategoriasIdEGenerosId(long categoriasId, long generosId);
    void atualizar(Generos generos);
    void excluir(long generosId);
    Generos recuperarPorID(long id);

}
