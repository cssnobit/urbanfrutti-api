INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Maçã Fuji Unidade', 5.49, null, 50, 'https://ibassets.com.br/ib.item.image.large/l-db2ce09871a848fbbffb1ce6497e0b3d.jpeg');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Alface Crespa Unidade', 2.11, 'Aproximadamente 100g', 50, 'https://cdn.awsli.com.br/800x800/1304/1304130/produto/50538831/0792430fe7.jpg');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Cebola Nacional Unidade', 2.00, null, 35, 'https://crsupermercados.com.br/cdn/shop/files/cebola-nacional.png?v=1710415970');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Banana Nanica', 9.99, 'Aproximadamente 1kg', 50, 'https://images.tcdn.com.br/img/img_prod/1180228/banana_nanica_6_unidades_9_1_e37954717acfebbb861a1a435b397c1c.png');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Laranja Importada', 3.20, null, 60, 'https://prezunic.vtexassets.com/arquivos/ids/181443-800-auto?v=638368814312430000&width=800&height=auto&aspect=true');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Melancia Unidade', 20.00, null, 47, 'https://obahortifruti.vtexassets.com/arquivos/ids/5191636-800-auto?v=638331429801830000&width=800&height=auto&aspect=true');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Tomate Italiano Unidade', 2.00, null, 31, 'https://mambodelivery.vtexassets.com/arquivos/ids/182916-800-auto?v=637883976709070000&width=800&height=auto&aspect=true');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Batata Lavada Unidade', 4.29, null, 0, 'https://mambodelivery.vtexassets.com/arquivos/ids/157831-800-auto?v=637883110873400000&width=800&height=auto&aspect=true');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Brócolis Ninja Buquê', 12.00, 'Aproximadamente 100g', 50, 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcS-JArv8nbwMldUHO-wL4J-EamLB3nW-6qXMyEWUA3f8n21aw7TL0wqPvHyHHVYe8yjRJzjU0oTlx6LEElPS-X3VwggGuGl');
INSERT INTO tb_produto(nome, preco, descricao,qtd_estoque, url_img) VALUES('Repolho Verde Unidade', 4.00, null, 10, 'https://carrefourbrfood.vtexassets.com/arquivos/ids/38215804/repolho-liso-fresco-inteiro-carrefour-aproximadamente-15-kg-1.jpg?v=637819398764030000');

INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Lucas Almeida Silva', '12345678901', 'lucas.silva@email.com', 'senha123', '13912345678');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Mariana Costa Oliveira', '98765432102', 'mariana.oliveira@email.com', 'senha456', '13987654321');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Carlos Eduardo Santos', '11122233344', 'carlos.santos@email.com', 'senha789', '13923456789');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Fernanda Lima Souza', '55566677788', 'fernanda.souza@email.com', 'senha101', '13999998888');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('João Pedro Pereira', '22233344455', 'joao.pereira@email.com', 'senha202', '13912223344');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Roberta Martins Silva', '44455566677', 'roberta.martins@email.com', 'senha303', '13919998765');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Ana Clara Ferreira', '33344455566', 'ana.ferreira@email.com', 'senha404', '13938885555');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Felipe Rocha Lima', '66677788899', 'felipe.lima@email.com', 'senha505', '13944441234');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Juliana Mendes Costa', '88899900011', 'juliana.mendes@email.com', 'senha606', '13955559876');
INSERT INTO tb_usuario (nome_completo, cpf, email, senha, celular) VALUES ('Rafael Teixeira Lopes', '77788899900', 'rafael.lopes@email.com', 'senha707', '13922221111');

INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (1, '11013000', 'Avenida Ana Costa', '100', 'Apto 201', 'Gonzaga', 'CONFIRMADO', 'CARTAO_CREDITO', '2024-10-01 08:00:00', '2024-10-01 08:00:00', 27.74);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (1, '11013000', 'Avenida Ana Costa', '100', 'Apto 201', 'Gonzaga', 'CRIADO', 'CARTAO_CREDITO', '2024-10-09 08:00:00', '2024-12-01 09:00:00', 10.00);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (2, '11040010', 'Rua João Pessoa', '120', 'Casa', 'Centro', 'ENTREGUE', 'BOLETO', '2024-10-02 09:00:00', '2024-10-03 10:00:00', 10.98);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (3, '11025030', 'Rua Alexandre Herculano', '150', 'Apto 103', 'Boqueirão', 'CRIADO', 'PIX', '2024-10-04 10:30:00', '2024-10-04 10:30:00', 14.98);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (4, '11013020', 'Avenida Conselheiro Nébias', '200', 'Loja 2', 'Vila Matias', 'CANCELADO', 'CARTAO_CREDITO', '2024-10-05 11:00:00', '2024-10-05 11:00:00', 15.00);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (5, '11015000', 'Rua Amador Bueno', '300', 'Casa', 'Centro', 'ENTREGUE', 'PIX', '2024-10-06 12:00:00', '2024-10-07 14:00:00', 21.87);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (6, '11030020', 'Rua São Francisco', '400', 'Apto 702', 'Vila Belmiro', 'CONFIRMADO', 'BOLETO', '2024-10-08 13:00:00', '2024-10-08 13:00:00', 9.99);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (7, '11045030', 'Rua General Câmara', '500', 'Apto 305', 'Embaré', 'CRIADO', 'PIX', '2024-10-09 15:00:00', '2024-10-09 15:00:00', 17.58);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (8, '11013040', 'Avenida Bernardino de Campos', '600', 'Apto 104', 'Pompéia', 'CONFIRMADO', 'CARTAO_CREDITO', '2024-10-10 16:30:00', '2024-10-10 16:30:00', 21.00);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (9, '11030010', 'Rua Almeida de Moraes', '700', 'Apto 801', 'Boqueirão', 'ENTREGUE', 'PIX', '2024-10-11 17:30:00', '2024-10-11 17:30:00', 13.08);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (10, '11045010', 'Rua Doutor Cochrane', '800', 'Casa', 'Centro', 'CANCELADO', 'BOLETO', '2024-10-12 18:00:00', '2024-10-12 18:00:00', 15.99);
INSERT INTO tb_pedido (cliente_id, cep, logradouro, numero, complemento, bairro, status, tipo_pagamento, data_criacao, data_atualizacao, total) VALUES (1, '11013000', 'Avenida Ana Costa', '100', 'Apto 201', 'Gonzaga', 'CRIADO', 'CARTAO_CREDITO', '2024-10-09 08:00:00', '2024-12-01 09:00:00', 10.00);

INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (3, 1, 1, 16.47);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (2, 1, 2, 4.22);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (1, 1, 4, 9.99);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (2, 2, 5, 6.40);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (2, 2, 2, 4.22);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (3, 3, 2, 6.33);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (1, 3, 4, 9.99);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (5, 4, 3, 10.00);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (1, 4, 5, 3.20);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (3, 5, 1, 16.47);
INSERT INTO tb_item_pedido (qtd_produto, pedido_id, produto_id, subtotal) VALUES (2, 12, 10, 10.00);
