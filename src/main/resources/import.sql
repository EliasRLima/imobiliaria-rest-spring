insert into clientes(id, nome_cliente, cpf, telefone, email, dt_nascimento) values (1, 'Artur', '11111111111', '989999999', 'artur@email', '11-02-2022');
insert into clientes(id, nome_cliente, cpf, telefone, email, dt_nascimento) values (2, 'Elias', '11111111111', '989999999', 'elias@email', '11-02-2022');
insert into clientes(id, nome_cliente, cpf, telefone, email, dt_nascimento) values (3, 'Italo Auau', '11111111111', '989999999', 'auau@email', '11-02-2022');

insert into imoveis(id, tipo_imovel, endereco, cep, dormitorios, banheiros, suites, metragem, valor_aluguel_sug, obs ) values (1, 'residencia', 'numero 103 - rua 01 - bairro 02 - Cidade 03', '00000-000', 2, 1, 0, 50, 200.0, 'A casa tem um fantasma (mas é gente boa)');
insert into imoveis(id, tipo_imovel, endereco, cep, dormitorios, banheiros, suites, metragem, valor_aluguel_sug, obs ) values (2, 'residencia', 'numero 104 - rua 01 - bairro 02 - Cidade 03', '00000-000', 2, 1, 0, 50, 200.0, null);

insert into locacao(id, id_imovel, id_inquilino, ativo, data_fim, data_inicio, data_vencimento, perc_multa, valor_aluguel, obs) values (1, 1, 3, 2, '10-02-2022', '01-02-2022', '30-03-2022', 10, 150.0, 'Ficou com medo do fantasma.');

insert into alugueis(id, id_locacao, dt_vencimento, valor_pago, obs) values (1, 2, '30-03-2022', 75.0, 'Pagou 50%, ficou 10 dias e abandonou o imovel.');
