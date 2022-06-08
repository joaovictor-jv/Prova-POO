create database ProjetoFinal;
use ProjetoFinal;

CREATE TABLE Produto (
    idProduto int not null auto_increment PRIMARY KEY,
    nomeProduto varchar(50),
    valorUnitario double,
    tipoUnidade varchar(10),
    qtdEstoque int
);
select * from Produto;

insert into Produto(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values("Miojo",1.25,"Gramas",50);
insert into Produto(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values("Iogurte",8.00,"Gramas",35);
insert into Produto(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values("Bolacha",3.50,"Gramas",75);
insert into Produto(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values("Achocolatado",8.90,"Gramas",20);
insert into Produto(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values("Cookie",5.99,"Gramas",60);