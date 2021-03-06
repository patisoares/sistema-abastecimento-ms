create table tb_abastecimento (id  bigserial not null, combustivel int4, cpf_motorista varchar(255), data_do_abastecimento TIMESTAMP WITHOUT TIME ZONE, quantidade_em_litros int4, quilometragem int8, valor_por_litro float8, id_autoposto_fk int8, id_veiculo_fk int8, primary key (id));
create table tb_autoposto (id  bigserial not null, cnpj varchar(255), email varchar(255), endereco varchar(255), nome_fantasia varchar(255), telefone varchar(255), id_cidade_fk int8, primary key (id));
create table tb_cidade (id  bigserial not null, nome varchar(255), id_estado_fk int8, primary key (id));
create table tb_estado (id  bigserial not null, uf varchar(255), primary key (id));
create table tb_lotacao (id  bigserial not null, descricao varchar(255), email varchar(255), endereco varchar(255), site varchar(255), telefone varchar(255), id_cidade_fk int8, primary key (id));
create table tb_lotacao_veiculo (lotacao_id int8 not null, veiculo_id int8 not null, primary key (lotacao_id, veiculo_id));
create table tb_marca (id  bigserial not null, descricao varchar(255), primary key (id));
create table tb_modelo (id  bigserial not null, descricao varchar(255), id_marca_fk int8, primary key (id));
create table tb_tipo (id  bigserial not null, descricao varchar(255), primary key (id));
create table tb_veiculo (id  bigserial not null, ano int4, capacidade_tanque int4, chassi varchar(255), patrimonio varchar(255), placa varchar(255), renavan varchar(255), tipo_combustivel varchar(255), versao varchar(255), id_tipo_fk int8, primary key (id));
alter table if exists tb_abastecimento add constraint FKnlya1b1td55702xr6wdhg9asq foreign key (id_autoposto_fk) references tb_autoposto;
alter table if exists tb_abastecimento add constraint FK597rsuc0a1jrj7mjun6ts33h2 foreign key (id_veiculo_fk) references tb_veiculo;
alter table if exists tb_autoposto add constraint FKntjxavnhbayoeyd457x0p2x5n foreign key (id_cidade_fk) references tb_cidade;
alter table if exists tb_cidade add constraint FKapyk73v0lu8y42jbfoo9lyxbu foreign key (id_estado_fk) references tb_estado;
alter table if exists tb_lotacao add constraint FK5x3wayyok97a0dsr0bwsr70b0 foreign key (id_cidade_fk) references tb_cidade;
alter table if exists tb_lotacao_veiculo add constraint FKfa7fj4lopq5ofnqoxmpei34wp foreign key (veiculo_id) references tb_veiculo;
alter table if exists tb_lotacao_veiculo add constraint FKhkj3s4qj44uf15vjwungvh15p foreign key (lotacao_id) references tb_lotacao;
alter table if exists tb_modelo add constraint FKk6vkobcttv9a9b8rktyunwn6t foreign key (id_marca_fk) references tb_marca;
alter table if exists tb_veiculo add constraint FK478gjyglqa3aq00220m3pp8jk foreign key (id_tipo_fk) references tb_tipo;
create table tb_abastecimento (id  bigserial not null, combustivel int4, cpf_motorista varchar(255), data_do_abastecimento TIMESTAMP WITHOUT TIME ZONE, quantidade_em_litros int4, quilometragem int8, valor_por_litro float8, id_autoposto_fk int8, id_veiculo_fk int8, primary key (id));
create table tb_autoposto (id  bigserial not null, cnpj varchar(255), email varchar(255), endereco varchar(255), nome_fantasia varchar(255), telefone varchar(255), id_cidade_fk int8, primary key (id));
create table tb_cidade (id  bigserial not null, nome varchar(255), id_estado_fk int8, primary key (id));
create table tb_estado (id  bigserial not null, uf varchar(255), primary key (id));
create table tb_lotacao (id  bigserial not null, descricao varchar(255), email varchar(255), endereco varchar(255), site varchar(255), telefone varchar(255), id_cidade_fk int8, primary key (id));
create table tb_lotacao_veiculo (lotacao_id int8 not null, veiculo_id int8 not null, primary key (lotacao_id, veiculo_id));
create table tb_marca (id  bigserial not null, descricao varchar(255), primary key (id));
create table tb_modelo (id  bigserial not null, descricao varchar(255), id_marca_fk int8, primary key (id));
create table tb_tipo (id  bigserial not null, descricao varchar(255), primary key (id));
create table tb_veiculo (id  bigserial not null, ano int4, capacidade_tanque int4, chassi varchar(255), patrimonio varchar(255), placa varchar(255), renavan varchar(255), tipo_combustivel varchar(255), versao varchar(255), id_tipo_fk int8, primary key (id));
alter table if exists tb_abastecimento add constraint FKnlya1b1td55702xr6wdhg9asq foreign key (id_autoposto_fk) references tb_autoposto;
alter table if exists tb_abastecimento add constraint FK597rsuc0a1jrj7mjun6ts33h2 foreign key (id_veiculo_fk) references tb_veiculo;
alter table if exists tb_autoposto add constraint FKntjxavnhbayoeyd457x0p2x5n foreign key (id_cidade_fk) references tb_cidade;
alter table if exists tb_cidade add constraint FKapyk73v0lu8y42jbfoo9lyxbu foreign key (id_estado_fk) references tb_estado;
alter table if exists tb_lotacao add constraint FK5x3wayyok97a0dsr0bwsr70b0 foreign key (id_cidade_fk) references tb_cidade;
alter table if exists tb_lotacao_veiculo add constraint FKfa7fj4lopq5ofnqoxmpei34wp foreign key (veiculo_id) references tb_veiculo;
alter table if exists tb_lotacao_veiculo add constraint FKhkj3s4qj44uf15vjwungvh15p foreign key (lotacao_id) references tb_lotacao;
alter table if exists tb_modelo add constraint FKk6vkobcttv9a9b8rktyunwn6t foreign key (id_marca_fk) references tb_marca;
alter table if exists tb_veiculo add constraint FK478gjyglqa3aq00220m3pp8jk foreign key (id_tipo_fk) references tb_tipo;
