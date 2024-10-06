package com.urbanfrutti.urbanfrutti.domain.entity.enums;

public enum StatusPedido {

	PENDENTE("PENDENTE"),
	CONFIRMADO("CONFIRMADO"),
	ENTREGUE("ENTREGUE"),
	CANCELADO("CANCELADO");
	
	private final String status;
	
	StatusPedido(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
