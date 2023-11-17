# cine-critique-backend

## Features

- Cadastro, Atualização e Lstagem de Usuários
- Cadastro, Atualização e Lstagem de Filmes
- Cadastro, Atualização e Lstagem de Gêneros
- Cadastro, Atualização e Lstagem de Avaliações

## Arquitetura

Esta aplicação segue os princípios da clean arq. Isolando
as regras de negócio da camada de infraestrutura.

### Estrutura de pastas

- app: Contém as regras de negócio da aplicação
  - model: Contem as entidades da aplicação
  - usecases: Contém os casos de uso da aplicação, implementando as regras de negócio e manipulam as entidades
  - gateways: Contém as interfaces que devem ser implementadas pela camada de infraestrutura, para comunicação dos interactors


## Execução
Para executar a aplicação, existem 2 possbilidades:
- Executar o jar gerado pelo maven
- Executar o container docker
### 1. Executar o jar gerado pelo maven

Como a aplicação é feita em Java, é necessário ter o JDK 17 instalado na máquina,
além do maven, que gerencia as dependências e builda a aplicação.

- Com o maven e o jdk instalado, basta executar

```shell
mvn clean install
```

Este processo builda e testa a aplicação, para rodar os scripts de testes:

```shell
mvn test
```

### 2. Executar o container docker

O docker é uma ferramenta de virtualização de aplicações, que permite a execução de aplicações em containers, que são ambientes isolados.
Com o docker instalado na máquina, baixe a imagem do dockerhub:

```shell
docker pull joaovitorsd/cine-critique-backend:latest
docker run -p 8080:8080 joaovitorsd/cine-critique-backend:latest
```
Este container, irá expor a porta 8080, para acessar a aplicação, basta acessar o endereço:

```shell
http://localhost:8080/ap1/v1
```


## Documentação

Esta aplicação possui uma documentação da api gerada automaticamente pelo swagger, que pode ser acessada pelo endereço:

```shell
http://localhost:8080/swagger-ui/index.html
```