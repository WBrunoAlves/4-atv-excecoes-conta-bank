package model.entitites;

import model.exception.DomainException;

public class Conta {
	private Integer numero;
	private String titular;
	private Double balanco;
	private Double limiteSaque;
	
	public Conta(Integer numero, String titular, Double balanco, Double limiteSaque) {
		
		this.numero = numero;
		this.titular = titular;
		this.balanco = balanco;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getBalanco() {
		return balanco;
	}


	public Double getLimiteSaque() {
		return limiteSaque;
	}


	
	public void deposito(Double montante) {
		balanco += montante;		
	}
	
	public void saque(double montante) {
		if (montante > limiteSaque ) {
			throw new DomainException("Saque maior que o limite da conta $" + limiteSaque);
		}
		if (montante > balanco) {
			throw new DomainException("Saldo insuficiente para efetuar o saque");
		}
		balanco -= montante;
	}

	@Override
	public String toString() {
		return "Status da conta: $" + balanco;
	}
	
	
	
	

}
