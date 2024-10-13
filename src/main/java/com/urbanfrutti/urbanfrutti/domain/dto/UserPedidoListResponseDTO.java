package com.urbanfrutti.urbanfrutti.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;
import com.urbanfrutti.urbanfrutti.domain.entity.enums.StatusPedido;
import com.urbanfrutti.urbanfrutti.domain.entity.enums.TipoPagamento;

public class UserPedidoListResponseDTO {
	
	private Long id;
	private TipoPagamento tipoPagamento;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	private BigDecimal total;
	private StatusPedido status;
	
	public UserPedidoListResponseDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.tipoPagamento = pedido.getTipoPagamento();
		this.dataCriacao = pedido.getDataCriacao();
		this.dataAtualizacao = pedido.getDataAtualizacao();
		this.total = pedido.getTotal();
		this.status = pedido.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
}
