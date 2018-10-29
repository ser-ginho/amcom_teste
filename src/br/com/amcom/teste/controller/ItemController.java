package br.com.amcom.teste.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.amcom.teste.dao.ItemDAO;
import br.com.amcom.teste.model.Item;

@ManagedBean
@ViewScoped
public class ItemController {
	
	private Item item = new Item();
	
	private ItemDAO itemDao = new ItemDAO();

	public final Item getItem() {
		return item;
	}

	public final ItemDAO getItemDao() {
		return itemDao;
	}
	
	public List<Item> getListaItem() {
		return getItemDao().listar();
	}
	
	public void salvar() throws Exception {
		getItemDao().salvar(item);
		item = new Item();
	}
	
	public void remover(int id) throws Exception {
		getItemDao().remover(id);
	}
	
}
