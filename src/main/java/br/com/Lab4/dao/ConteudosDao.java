package br.com.Lab4.dao;

import br.com.Lab4.domain.Conteudos;

import java.util.List;

public interface ConteudosDao {

    void salvar(Conteudos conteudos);
    List<Conteudos> recuperarPorGeneros(long generosId);
    Conteudos recuperarPorGenerosIdEConteudosId(long generosId, long conteudosId);
    void atualizar(Conteudos conteudos);
    void excluir(long conteudosId);

}
