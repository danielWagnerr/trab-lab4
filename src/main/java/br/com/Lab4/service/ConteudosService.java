package br.com.Lab4.service;

import br.com.Lab4.domain.Conteudos;

import java.util.List;

public interface ConteudosService {

    void salvar(Conteudos conteudos, long playlistId);
    List<Conteudos> recuperarPorGeneros(long playlistId);
    Conteudos recuperarPorGenerosIdEConteudosId(long playlistId, long conteudosId);
    void atualizar(Conteudos conteudos, long playlistId);
    void excluir(long playlistId, long conteudosId);

}