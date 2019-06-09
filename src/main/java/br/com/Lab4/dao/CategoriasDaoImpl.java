package br.com.Lab4.dao;

import br.com.Lab4.domain.Categorias;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoriasDaoImpl implements CategoriasDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Categorias categorias) {
        em.persist(categorias);
    }

    @Override
    public List<Categorias> recuperar() {
        return em.createQuery("select p from Categorias p", Categorias.class).getResultList();
    }

    @Override
    public Categorias recuperarPorID(long id) {
        return em.find(Categorias.class, id);
    }

    @Override
    public void atualizar(Categorias categorias) {
        em.merge(categorias);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Categorias.class, id));
    }

}