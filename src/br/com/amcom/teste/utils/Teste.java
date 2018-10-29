package br.com.amcom.teste.utils;

import java.util.List;

import br.com.amcom.teste.controller.LancamentoController;
import br.com.amcom.teste.model.Lancamento;

public class Teste {

	public static void main(String[] args) throws Exception {
		List<Lancamento> lancamentos = new LancamentoController().getLancamentoDao().listar();
	}

}
