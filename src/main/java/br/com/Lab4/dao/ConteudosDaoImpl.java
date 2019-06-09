package br.com.Lab4.dao;

import br.com.Lab4.domain.Conteudos;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConteudosDaoImpl implements ConteudosDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Conteudos conteudos) {
        em.persist(conteudos);
    }

    @Override
    public List<Conteudos> recuperarPorGeneros(long generosId) {
        return em.createQuery("select m from Conteudos m where m.generos.id = :generosId", Conteudos.class)
                .setParameter("generosId", generosId)
                .getResultList();
    }

    @Override
    public Conteudos recuperarPorGenerosIdEConteudosId(long generosId, long conteudosId) {
        return em.createQuery("select m from Conteudos m where m.generos.id = :generosId and m.id = :conteudosId", Conteudos.class)
                .setParameter("generosId", generosId)
                .setParameter("conteudosId", conteudosId)
                .getSingleResult();
    }

    @Override
    public void atualizar(Conteudos conteudos) {
        em.merge(conteudos);
    }

    @Override
    public void excluir(long conteudosId) {
        em.remove(em.getReference(Conteudos.class, conteudosId));
    }

}