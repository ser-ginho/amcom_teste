package br.com.amcom.teste.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.amcom.teste.dao.ItemDAO;
import br.com.amcom.teste.dao.LancamentoDAO;
import br.com.amcom.teste.model.Item;
import br.com.amcom.teste.model.Lancamento;

@ManagedBean
@ViewScoped
public class LancamentoController {
	
	private Lancamento lancamento = new Lancamento();
	
	private LancamentoDAO lancamentoDao = new LancamentoDAO();

	private List<String> listaItemSelecionados;
	
	public final Lancamento getLancamento() {
		return lancamento;
	}

	public final LancamentoDAO getLancamentoDao() {
		return lancamentoDao;
	}
	
	public List<String> getListaItemSelecionados() {
		return listaItemSelecionados;
	}

	public void setListaItemSelecionados(List<String> listaItemSelecionados) {
		this.listaItemSelecionados = listaItemSelecionados;
	}

	public List<Lancamento> getListaLancamento() {
		return getLancamentoDao().listar();
	}
	
	public void salvar() throws Exception {
		lancamento.setListaItem(retornaItens());
		
		lancamento.setValorTotal(lancamento.getListaItem().stream().map(item->item.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add));
		
		getLancamentoDao().salvar(lancamento);
		
		lancamento = new Lancamento();
	}
	
	public void remover(int id) throws Exception {
		getLancamentoDao().remover(id);
	}
	
	private List<Item> retornaItens() {
		if(listaItemSelecionados.size() > 0) {
			List<Item> itens = new ArrayList<>();
			
			for (String itemId : listaItemSelecionados) {
				itens.add(new ItemDAO().buscar(Integer.parseInt(itemId)));
			}
			
			return itens;
		}
		
		return new ArrayList<>();
	}
	
	public void removerItem(int idItem, int idLancamento) throws Exception {
		Item item = new ItemDAO().buscar(idItem);
		
		Lancamento lancamentoRemoverItem = lancamentoDao.buscar(idLancamento);
		
		lancamentoRemoverItem.getListaItem().remove(item);
		
		lancamentoRemoverItem.setValorTotal(lancamentoRemoverItem.getListaItem().stream().map(i -> i.getValor()).reduce(BigDecimal.ZERO,BigDecimal::add));
		
		getLancamentoDao().atualizar(lancamentoRemoverItem);
	}
}
