package com.urbanfrutti.urbanfrutti.domain.entity.enums;

public enum TipoPagamento  {

	PIX("PIX"),
	BOLETO("BOLETO"),
	CARTAO_CREDITO("CARTAO DE CREDITO");
	
	private final String pagamento;
	
	TipoPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getPagamento() {
		return pagamento;
	}
}
