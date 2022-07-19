# Aceleração em Java - Desafio Final

Esta é uma solução para o problema proposto pela [Trybe](https://www.betrybe.com/) em parceria com a [Wipro](https://www.wipro.com/), para a validação dos conhecimentos em Java adquiridos durante a Aceleração. 

## Conteúdo

- [Visão Geral](#visão-geral)
  - [O Desafio](#o-desafio)
  - [Tecnologias](#tecnologias)
- [Instruções de Uso](#instruções-de-uso)
- [Roadmap](#roadmap)
- [Autores](#autores)

## Visão Geral

### O Desafio

A empresa FutuereH conseguiu uma nova patente que permitirá a entrega de pacotes com drones. Nossa equipe é responsável por montar o serviço Back-end, que vai fornecer informações aos drones. O Back-end foi batizado como Drone Feeder. A Stack escolhida para a criação dele foi a linguagem Java, o banco de dados MySQL, e tudo deve rodar em containers Docker.

São esperadas as seguintes funcionalidades:
- Implementar um C.R.U.D. para os drones;
- Implementar um C.R.U.D. para uma entrega associada a um drone;
- Alterar o status da entrega;

### Tecnologias
- [Java](https://www.java.com/)
- [Maven](https://maven.apache.org/)
- [Quarkus](https://quarkus.io/)
- [MySQL](https://www.mysql.com/)
- [Docker](https://www.docker.com/)

## Instruções de Uso

### 1 - Instalação

- Clone este repositório:
    - `git clone git@github.com:palucas94/FutuereH-drone-feeder.git`

- Acesse a raíz da aplicação:
    - `cd FutuereH-drone-feeder`
    
- Instale as dependências do projeto:
    - `mvn install`

### 2 - Rodar a aplicação localmente

- Inicie o container docker:
    - `docker-compose up`

- Para rodar a aplicação sem o container Docker, e com o MySQL instalado, basta utilizar o comando:
    - `mvn compile quarkus:dev`

### 3 - Testes
- Para rodar os testes:
    - `mvn test`

- Para checar a cobertura dos testes:
    - `mvn verify`

## Roadmap
- Adicionar e implementar exceptions
- Implementar endpoints referentes ao vídeo da entrega sendo realizada (inserir, listar, baixar)

## Autores
- [Álvaro Gularte](https://www.linkedin.com/in/alvarogularte/)
- [Lucas Pontes Arruda](https://www.linkedin.com/in/lucas-pontes-arruda/)
