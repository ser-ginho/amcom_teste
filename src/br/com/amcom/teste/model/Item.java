package br.com.amcom.teste.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int oid;
    
    @Column(length=255)
    private String descricao;
    
    @Column(precision=8, scale=2)
    private BigDecimal valor;

	public final int getOid() {
		return oid;
	}

	public final void setOid(int oid) {
		this.oid = oid;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public final BigDecimal getValor() {
		return valor;
	}

	public final void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Item(String descricao, BigDecimal valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + oid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (oid != other.oid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [oid=" + oid + ", descricao=" + descricao + ", valor=" + valor + "]";
	}
}