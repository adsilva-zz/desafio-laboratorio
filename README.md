# desafio-laboratorio
API para gerenciamento de laboratórios e exames permite realizar CRUD para exame e laboratório, assosiar um exame a um laboratório, desassociar um exame de um laboratório e lista todos os laboratórios associados a um exame através da busca por nome do exame. 

## Tecnologias Utilizadas
O projeto foi criado com Spring Boot na linguagem de programação Java com BD MySQL, utilizando Spring Data JPA e o gerenciador de dependência Maven.

## Arquitetura 
O projeto está divido nas seguintes camadas:

*main:*
1. Entidade  
2. Repositório
3. Serviço
4. Controle
5. DTO
6. Converte
7. Exceção

## Como executar
1. Clonar o projeto
2. Ter instalado o BD MySQL 
3. Configurar no aplication.properties a conexão do BD
4. Executar no terminal o comando: ``mvn spring-boot:run``
5. Chamar os endpoint.
