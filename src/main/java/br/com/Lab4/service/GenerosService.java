package br.com.Lab4.service;

import br.com.Lab4.domain.Generos;

import java.util.List;

public interface GenerosService {

    void salvar(Generos generos, long playlistId);
    List<Generos> recuperarPorCategorias(long playlistId);
    Generos recuperarPorCategoriasIdEGenerosId(long playlistId, long generosId);
    void atualizar(Generos generos, long playlistId);
    void excluir(long playlistId, long generosId);
    Generos recuperarPorId(long id);
}