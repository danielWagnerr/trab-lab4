package br.com.Lab4.dao;

import br.com.Lab4.domain.Generos;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenerosDaoImpl implements GenerosDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Generos generos) {
        em.persist(generos);
    }

    @Override
    public List<Generos> recuperarPorCategorias(long categoriasId) {
        return em.createQuery("select m from Generos m where m.categorias.id = :categoriasId", Generos.class)
                .setParameter("categoriasId", categoriasId)
                .getResultList();
    }

    @Override
    public Generos recuperarPorCategoriasIdEGenerosId(long categoriasId, long generosId) {
        return em.createQuery("select m from Generos m where m.categorias.id = :categoriasId and m.id = :generosId", Generos.class)
                .setParameter("categoriasId", categoriasId)
                .setParameter("generosId", generosId)
                .getSingleResult();
    }

    @Override
    public void atualizar(Generos generos) {
        em.merge(generos);
    }

    @Override
    public void excluir(long generosId) {
        em.remove(em.getReference(Generos.class, generosId));
    }

    @Override
    public Generos recuperarPorID(long id) {
        return em.find(Generos.class, id);
    }

}

