package br.com.Lab4.service;

import br.com.Lab4.dao.GenerosDao;
import br.com.Lab4.domain.Generos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenerosServiceImpl implements GenerosService {

    @Autowired
    private GenerosDao generosDao;

    @Autowired
    private CategoriasService categoriasService;

    @Override
    public void salvar(Generos generos, long categoriasId) {
        generos.setCategorias(categoriasService.recuperarPorId(categoriasId));
        generosDao.salvar(generos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Generos> recuperarPorCategorias(long categoriasId) {
        return generosDao.recuperarPorCategorias(categoriasId);
    }

    @Override
    @Transactional(readOnly = true)
    public Generos recuperarPorCategoriasIdEGenerosId(long categoriasId, long generosId) {
        return generosDao.recuperarPorCategoriasIdEGenerosId(categoriasId, generosId);
    }

    @Override
    public void atualizar(Generos generos, long categoriasId) {
        generos.setCategorias(categoriasService.recuperarPorId(categoriasId));
        generosDao.atualizar(generos);
    }

    @Override
    public void excluir(long categoriasId, long generosId) {
        generosDao.excluir(recuperarPorCategoriasIdEGenerosId(categoriasId, generosId).getId());
    }

    @Override
    @Transactional(readOnly = true)
    public Generos recuperarPorId(long id) {
        return generosDao.recuperarPorID(id);
    }

}