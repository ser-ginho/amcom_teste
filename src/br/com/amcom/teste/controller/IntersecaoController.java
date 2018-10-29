package br.com.amcom.teste.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class IntersecaoController {
	
	private Integer faixa1Valor1;
	
	private Integer faixa1Valor2;
	
	private Integer faixa2Valor1;
	
	private Integer faixa2Valor2;

	public Integer getFaixa1Valor1() {
		return faixa1Valor1;
	}

	public void setFaixa1Valor1(Integer faixa1Valor1) {
		this.faixa1Valor1 = faixa1Valor1;
	}

	public Integer getFaixa1Valor2() {
		return faixa1Valor2;
	}

	public void setFaixa1Valor2(Integer faixa1Valor2) {
		this.faixa1Valor2 = faixa1Valor2;
	}

	public Integer getFaixa2Valor1() {
		return faixa2Valor1;
	}

	public void setFaixa2Valor1(Integer faixa2Valor1) {
		this.faixa2Valor1 = faixa2Valor1;
	}

	public Integer getFaixa2Valor2() {
		return faixa2Valor2;
	}

	public void setFaixa2Valor2(Integer faixa2Valor2) {
		this.faixa2Valor2 = faixa2Valor2;
	}
	
	public void verificar() {
		if(faixa1Valor1 > faixa1Valor2) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Valor 1 da Faixa 1 deve ser menor que Valor 2 da Faixa 1"));
			
			return;
		}
		
		if(faixa2Valor1 > faixa2Valor2) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Valor 1 da Faixa 2 deve ser menor que Valor 2 da Faixa 2"));
			
			return;
		}
		
		if(faixa1Valor1 < faixa2Valor1) {
			if(faixa1Valor2 >= faixa2Valor2) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Existe uma interseção entre os valores."));
				
				return;
			}
			if(faixa1Valor2 >= faixa2Valor1) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Existe uma interseção entre os valores."));
				
				return;
			}
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não existe interseção entre os valores."));
			
			return;
		}
		
		if(faixa1Valor1 > faixa2Valor1) {
			if(faixa2Valor2 >= faixa1Valor2) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Existe uma interseção entre os valores."));
			
				return;
			}
			
			if(faixa2Valor2 >= faixa1Valor1) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Existe uma interseção entre os valores."));
				
				return;
			}
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não existe uma interseção entre os valores."));
			
			return;
		}
	}
}
