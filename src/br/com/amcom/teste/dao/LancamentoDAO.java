package br.com.amcom.teste.dao;

import java.util.List;

import br.com.amcom.teste.interfaces.InterfacePersistencia;
import br.com.amcom.teste.model.Lancamento;

public class LancamentoDAO implements InterfacePersistencia<Lancamento> {

	DAO<Lancamento> lancamentoDao = new DAO<>();
	
	@Override
	public Lancamento salvar(Lancamento entidade) throws Exception {
		return lancamentoDao.salvar(entidade);
	}
	
	@Override
	public Lancamento buscar(int id) {
		return lancamentoDao.buscar(new Lancamento(), id);
	}

	@Override
	public void atualizar(Lancamento entidade) throws Exception {
		lancamentoDao.atualizar(entidade);
	}

	@Override
	public void remover(int id) throws Exception {
		lancamentoDao.remover(new Lancamento(), id);
	}

	@Override
	public List<Lancamento> listar() {
		return lancamentoDao.listar(new Lancamento());
	}
}
