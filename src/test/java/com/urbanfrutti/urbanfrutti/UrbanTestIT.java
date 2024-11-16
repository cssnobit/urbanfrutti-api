package com.urbanfrutti.urbanfrutti;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.urbanfrutti.urbanfrutti.domain.entity.ItemPedido;
import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;
import com.urbanfrutti.urbanfrutti.domain.entity.Produto;
import com.urbanfrutti.urbanfrutti.domain.entity.Usuario;
import com.urbanfrutti.urbanfrutti.domain.entity.enums.TipoPagamento;
import com.urbanfrutti.urbanfrutti.domain.service.PedidoService;
import com.urbanfrutti.urbanfrutti.domain.service.ProdutoService;
import com.urbanfrutti.urbanfrutti.domain.service.UsuarioService;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrbanTestIT {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private UsuarioService usuarioService;

	/*
	 * Teste de API - Este teste deve retornar status HTTP 400 ao pedir quantidade de
	 * um produto maior do que o disponível
	 * */
	@Test
	public void deveRetornar400_QuandoPedeQtdProdutoMaiorQueODisponivel() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		List<ItemPedido> itens = new ArrayList<>();
		
		Produto produto1 = produtoService.getProduto(7l);
		
		Pedido novoPedido = new Pedido();
		
		Usuario cliente = usuarioService.getUsuario(2l);
		
		ItemPedido item1 = new ItemPedido();
		item1.setProduto(produto1);
		item1.setQtdProduto(50);
		itens.add(item1);
		
		novoPedido.setCliente(cliente);
		novoPedido.setBairro("Centro");
		novoPedido.setCep("11040010");
		novoPedido.setLogradouro("Rua João Pessoa");
		novoPedido.setNumero("120");
		novoPedido.setComplemento("Casa");
		novoPedido.setItens(itens);
		novoPedido.setTipoPagamento(TipoPagamento.PIX);
		

		given()
			.basePath("/pedidos")
			.port(port)
			.accept(ContentType.JSON)
			.body(novoPedido)
			.contentType(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	/*
	 * 	Teste de API - Este teste deve ser válido quando retornar status 201 e
	 * 	os itens pedidos sejam de fato a cebola nacional e a maçã fuji
	 * */
	@Test
	public void deveRetornar201_QuandoCriaPedido() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		List<ItemPedido> itens = new ArrayList<>();
		
		Produto produto1 = produtoService.getProduto(3l);
		Produto produto2 = produtoService.getProduto(1l);
		
		Pedido novoPedido = new Pedido();
		
		Usuario cliente = usuarioService.getUsuario(2l);
		
		ItemPedido item1 = new ItemPedido();
		item1.setProduto(produto1);
		item1.setQtdProduto(3);
		itens.add(item1);
		
		ItemPedido item2 = new ItemPedido();
		item2.setProduto(produto2);
		item2.setQtdProduto(1);
		itens.add(item2);
		
		novoPedido.setCliente(cliente);
		novoPedido.setBairro("Centro");
		novoPedido.setCep("11040010");
		novoPedido.setLogradouro("Rua João Pessoa");
		novoPedido.setNumero("120");
		novoPedido.setComplemento("Casa");
		novoPedido.setItens(itens);
		novoPedido.setTipoPagamento(TipoPagamento.PIX);
		

		given()
			.basePath("/pedidos")
			.port(port)
			.accept(ContentType.JSON)
			.body(novoPedido)
			.contentType(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value())
			.and()
			.body("itens.produto.nome", hasItems("Maçã Fuji Unidade", "Cebola Nacional Unidade"));
	}
	
	/*
	 * Teste de API - Deve retornar status 404 ao buscar por um produto que nao existe
	 * */
	@Test
	public void deveRetornar404_QuandoBuscaProdutoPeloIdInexistente() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		given()
			.basePath("/produtos/51")
			.port(port)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	/*
	 * 	Teste de Integração - O estoque do produto deve ser atualizado após a criação de um pedido
	 * 	No teste abaixo o produto tinha 50 no estoque, no teste colocamos que o pedido é de 3,
	 * 	portanto deve retornar 47.
	 * */
	@Test
	public void deveAtualizarEstoque_QuandoCriarPedido() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		List<ItemPedido> itens = new ArrayList<>();
		
		Produto produto1 = produtoService.getProduto(2l);
		int estoqueEsperado = 47;
	
		Pedido pedido = new Pedido();
		
		Usuario cliente = usuarioService.getUsuario(2l);
		
		ItemPedido item1 = new ItemPedido();
		item1.setProduto(produto1);
		item1.setQtdProduto(3);
		itens.add(item1);
		
		
		pedido.setCliente(cliente);
		pedido.setBairro("Centro");
		pedido.setCep("11040010");
		pedido.setLogradouro("Rua João Pessoa");
		pedido.setNumero("120");
		pedido.setComplemento("Casa");
		pedido.setItens(itens);
		pedido.setTipoPagamento(TipoPagamento.PIX);
		
		Pedido novoPedido = pedidoService.savePedido(pedido);
		
		/*given()
			.basePath("/produtos/2")
			.port(port)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.body("qtdEstoque", equalTo(estoqueEsperado));*/
		assertEquals(estoqueEsperado, produtoService.getProduto(2l).getQtdEstoque());
	}
	
	/*
	 * Teste Unitário - O valor vinal deve ser 6.00, visto que o produto do id 3 custa 2.00
	 * a unidade e foram pedidos 3.
	 * */
	@Test
	public void deveCalcularValorFinalCorreto_QuandoCriaPedido() {
		BigDecimal valorEsperado = new BigDecimal("6.00");
		
		List<ItemPedido> itens = new ArrayList<>();
		
		Produto produto1 = produtoService.getProduto(3l);
	
		Pedido pedido = new Pedido();
		
		Usuario cliente = usuarioService.getUsuario(2l);
		
		ItemPedido item1 = new ItemPedido();
		item1.setProduto(produto1);
		item1.setQtdProduto(3);
		itens.add(item1);
		
		
		pedido.setCliente(cliente);
		pedido.setBairro("Centro");
		pedido.setCep("11040010");
		pedido.setLogradouro("Rua João Pessoa");
		pedido.setNumero("120");
		pedido.setComplemento("Casa");
		pedido.setItens(itens);
		pedido.setTipoPagamento(TipoPagamento.PIX);
		
		Pedido novoPedido = pedidoService.savePedido(pedido);
		
		assertEquals(valorEsperado, novoPedido.getTotal());
	}
}
