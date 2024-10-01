create table tb_usuario (
	id bigint not null auto_increment,
	nome_completo varchar(100) not null,
	cpf varchar(11),
	email varchar(80) not null unique,
	senha varchar(16) not null,
	celular varchar(11) not null,
	
	primary key(id)
) engine=InnoDB charset=utf8mb4;

create table tb_produto(
	id bigint not null auto_increment,
    nome varchar(50) not null,
    preco decimal(38,2) not null,
    descricao varchar(100),
    qtd_estoque int not null,
    url_img varchar(255) not null,
    
    primary key(id)
) engine=InnoDB charset=utf8mb4;