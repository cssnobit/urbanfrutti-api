package com.urbanfrutti.urbanfrutti.domain.entity.enums;

public enum StatusPedido {

	CRIADO("CRIADO"),
	CONFIRMADO("CONFIRMADO"),
	ENTREGUE("ENTREGUE"),
	CANCELADO("CANCELADO"),
	EM_TRANSITO("EM_TRANSITO");
	
	private final String status;
	
	StatusPedido(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
