INSERT INTO role (nome) VALUES ('ADMIN');
INSERT INTO role (nome) VALUES ('OPERADOR');


INSERT INTO permissao (nome) VALUES ('CONSULTA-LISTA');
INSERT INTO permissao (nome) VALUES ('DELETA-ITEM');

INSERT INTO role_permissao (role_id, permissao_id) VALUES (1, 1);
INSERT INTO role_permissao (role_id, permissao_id) VALUES (2, 1);
--INSERT INTO role_permissao (role_id, permissao_id) VALUES (1, 2);

--INSERT INTO usuario_role (role_id, usuario_id) VALUES (1, 1);


INSERT INTO produto (nome, valor, descricao) VALUES ('Fone Bluetooth Pro', 249.90, 'Fone de ouvido sem fio com cancelamento de ruído');
INSERT INTO produto (nome, valor, descricao) VALUES ('Teclado Mecânico RGB', 399.90, 'Teclado gamer mecânico com iluminação RGB');
INSERT INTO produto (nome, valor, descricao) VALUES ('Monitor 27 Polegadas 4K', 1799.90, 'Monitor UHD 4K para trabalho e jogos');
INSERT INTO produto (nome, valor, descricao) VALUES ('Mouse Gamer Ultra', 199.99, 'Mouse com 16000 DPI e sensor óptico');
INSERT INTO produto (nome, valor, descricao) VALUES ('Cadeira Gamer Confort', 1299.00, 'Cadeira ergonômica com ajuste lombar');
INSERT INTO produto (nome, valor, descricao) VALUES ('Notebook Ultra Slim', 4499.99, 'Notebook leve com SSD 512GB e 16GB RAM');
INSERT INTO produto (nome, valor, descricao) VALUES ('Smartphone XTurbo', 3499.00, 'Smartphone com 128GB, câmera tripla');
INSERT INTO produto (nome, valor, descricao) VALUES ('Tablet Pro 11', 2899.90, 'Tablet com tela de 11 polegadas e caneta');
INSERT INTO produto (nome, valor, descricao) VALUES ('Impressora Multifuncional', 599.90, 'Impressora com scanner e Wi-Fi');
INSERT INTO produto (nome, valor, descricao) VALUES ('Caixa de Som Bluetooth', 349.00, 'Caixa potente com grave reforçado');
INSERT INTO produto (nome, valor, descricao) VALUES ('HD Externo 2TB', 499.00, 'HD externo portátil com 2TB de armazenamento');
INSERT INTO produto (nome, valor, descricao) VALUES ('SSD NVMe 1TB', 699.99, 'SSD ultrarrápido para notebooks e desktops');
INSERT INTO produto (nome, valor, descricao) VALUES ('Webcam Full HD', 249.90, 'Webcam com microfone estéreo e 1080p');
INSERT INTO produto (nome, valor, descricao) VALUES ('Microfone Condensador', 549.90, 'Microfone profissional para podcasts');
INSERT INTO produto (nome, valor, descricao) VALUES ('Placa de Vídeo RTX 4060', 2699.99, 'Placa gráfica para alto desempenho');
INSERT INTO produto (nome, valor, descricao) VALUES ('Fonte 750W Modular', 599.00, 'Fonte de alimentação 80 Plus Gold');
INSERT INTO produto (nome, valor, descricao) VALUES ('Gabinete Mid Tower', 399.00, 'Gabinete com vidro temperado e RGB');
INSERT INTO produto (nome, valor, descricao) VALUES ('Headset Gamer Surround', 499.90, 'Fone gamer com som 7.1 e microfone');
INSERT INTO produto (nome, valor, descricao) VALUES ('Controle Sem Fio', 299.90, 'Controle compatível com PC e consoles');
INSERT INTO produto (nome, valor, descricao) VALUES ('Carregador Portátil 20000mAh', 189.90, 'Power Bank de alta capacidade');
