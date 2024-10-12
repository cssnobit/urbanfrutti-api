create table tb_produto(
	id bigint not null auto_increment,
	nome varchar(50) not null,
	preco decimal(38,2) not null,
	descricao varchar(100),
	qtd_estoque int not null,
	url_img varchar(255) not null,
    
	primary key(id)
) engine=InnoDB charset=utf8mb4;

create table tb_usuario (
	id bigint not null auto_increment,
	nome_completo varchar(100) not null,
	cpf varchar(11),
	email varchar(80) not null unique,
	senha varchar(16) not null,
	celular varchar(11) not null,
	
	primary key(id)
) engine=InnoDB charset=utf8mb4;

create table tb_pedido (
	id bigint not null auto_increment,
	cliente_id bigint not null, 
	cep varchar(8) not null, 
	logradouro varchar(150) not null, 
	numero varchar(4) default 'S/N', 
	complemento varchar(50), 
	bairro varchar(50) not null, 
	status enum ('CANCELADO','CONFIRMADO','CRIADO','ENTREGUE', 'EM_TRANSITO') not null, 
	tipo_pagamento enum ('PIX', 'CARTAO_CREDITO', 'BOLETO') not null, 
	data_criacao datetime(6) not null, 
	data_atualizacao datetime(6) not null, 
	total decimal(38, 2) not null,

	primary key(id)
) engine=InnoDB charset=utf8mb4;

create table tb_item_pedido (
	id bigint not null auto_increment,
        subtotal decimal(38,2) not null,
	qtd_produto int not null default 1,
        pedido_id bigint not null,
        produto_id bigint not null,
	
	primary key(id)
) engine=InnoDB charset=utf8mb4;

alter table tb_pedido add constraint fk_cliente foreign key (cliente_id) references tb_usuario (id);

alter table tb_item_pedido add constraint fk_pedido foreign key (pedido_id) references tb_pedido (id);

alter table tb_item_pedido add constraint fk_produto foreign key (produto_id) references tb_produto (id);