package br.com.vrrecife.dominio;

import java.util.Date;

public class LogProduto {
	
	private String ean;
	private Date dataLancamento;
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	

}
