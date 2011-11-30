-- You can use this file to load seed data into the database using SQL statements
insert into Shopping (id, cidade, estado, logradouro, nome) values (1, 'Sao Paulo', 'SP', 'Av Raimundo Pereira de Magalhaes', 'Shopping Grande Pirituba');
insert into loja (id, descricao, localizacao, nome, shopping_id, logo) 
values (20,
'A Fast Shop é uma rede de lojas brasileira de comercialização de eletrodomésticos e eletroeletrônicos de luxo. Fundada em 1986, a empresa possui lojas nos principais estados brasileiros. A Empresa já patrocinou dois grandes clubes brasileiros. Em fevereiro de 2006 patrocionou o São Paulo Futebol Clube[1], estampando sua marca nas mangas da camisa, parceria essa que durou até ínicio de 2009, quando passou a patrocinar a Sociedade Esportiva Palmeiras[2] com sua marca também nas mangas da camisa.',
'Primeiro Andar, Ala D',
'FastShop', 
1,
'fastshop.jpg');

insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 