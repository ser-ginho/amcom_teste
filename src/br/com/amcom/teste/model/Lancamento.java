package br.com.amcom.teste.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lancamento implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
//    @SequenceGenerator(sequenceName = "id_lancamento_seq", name = "id_lancamento_seq", allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_lancamento_seq")  
    private int oid;
    
    @Column(name="dt_inicial")
    private Date dataInicial;
	
    @Column(name="dt_final")
    private Date dataFinal;

    @Column(name="vl_total", precision=8, scale=2)
    private BigDecimal valorTotal;
    
    @Column(length=1000)
    private String observacao;
    
    @OneToMany(fetch=FetchType.EAGER)
    private List<Item> listaItem;

	public final int getOid() {
		return oid;
	}

	public final void setOid(int oid) {
		this.oid = oid;
	}

	public final Date getDataInicial() {
		return dataInicial;
	}

	public final void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public final Date getDataFinal() {
		return dataFinal;
	}

	public final void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public final BigDecimal getValorTotal() {
		return valorTotal;
	}

	public final void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public final String getObservacao() {
		return observacao;
	}

	public final void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public final List<Item> getListaItem() {
		return listaItem;
	}

	public final void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}

	public Lancamento(Date dataInicial, Date dataFinal, BigDecimal valorTotal, String observacao) {
		super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
	}

	public Lancamento() {
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
		Lancamento other = (Lancamento) obj;
		if (oid != other.oid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lancamento [oid=" + oid + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", valorTotal="
				+ valorTotal + ", observacao=" + observacao + "]";
	}
}