package br.com.Lab4.service;

import br.com.Lab4.dao.CategoriasDao;
import br.com.Lab4.domain.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoriasServiceImpl implements CategoriasService {

    @Autowired
    private CategoriasDao categoriasDao;

    @Override
    public void salvar(Categorias categorias) {
        categoriasDao.salvar(categorias);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categorias> recuperar() {
        return categoriasDao.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public Categorias recuperarPorId(long id) {
        return categoriasDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(Categorias categorias) {
        categoriasDao.atualizar(categorias);
    }

    @Override
    public void excluir(long id) {
        categoriasDao.excluir(id);
    }

}