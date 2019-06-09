package br.com.Lab4.service;

import br.com.Lab4.dao.ConteudosDao;
import br.com.Lab4.domain.Conteudos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConteudosServiceImpl implements ConteudosService {

    @Autowired
    private ConteudosDao conteudosDao;

    @Autowired
    private GenerosService generosService;

    @Override
    public void salvar(Conteudos conteudos, long generosId) {
        conteudos.setGeneros(generosService.recuperarPorId(generosId));
        conteudosDao.salvar(conteudos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Conteudos> recuperarPorGeneros(long generosId) {
        return conteudosDao.recuperarPorGeneros(generosId);
    }

    @Override
    @Transactional(readOnly = true)
    public Conteudos recuperarPorGenerosIdEConteudosId(long generosId, long conteudosId) {
        return conteudosDao.recuperarPorGenerosIdEConteudosId(generosId, conteudosId);
    }

    @Override
    public void atualizar(Conteudos conteudos, long generosId) {
        conteudos.setGeneros(generosService.recuperarPorId(generosId));
        conteudosDao.atualizar(conteudos);
    }

    @Override
    public void excluir(long generosId, long conteudosId) {
        conteudosDao.excluir(recuperarPorGenerosIdEConteudosId(generosId, conteudosId).getId());
    }

}