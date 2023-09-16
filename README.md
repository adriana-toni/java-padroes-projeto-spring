# Explorando Padrões de Projetos na Prática com Java

Projeto desenvolvido em Spring Boot 3 a partir de start realizado através do site [Spring initializr](https://start.spring.io/) 
utilizando as seguintes dependências:

* Spring Web
* Spring Data JPA
* Lombok
* OpenFeign
* H2 Database

e a documentação da API desenvolvida utilizando OpenAPI 3.

## Configuração

- Clonar o repositório:<br>
  ``git clone https://github.com/adriana-toni/java-padroes-projeto-spring.git``

- Importar o projeto em uma IDE Java

- Para iterar com a API:<br>
  ``http://localhost:8080/swagger-ui/index.html``

  - Corpo básico das requisições:<br>
    ``
    {
      "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
      "nome": "Márcia",
      "endereco": {
          "cep": "31.140-020"
      }
    }
    ``
## Características

- CRUD completo de cadastro de cliente e endereço
- Integração com API pública [ViaCEP](https://viacep.com.br/) 
- Tratamento de algumas exceções 
- Dados gravados em memória (H2 Database)
- Possibilidade de informar CEP com ou sem máscara


## Documentação de Referência
Para referência adicional, considere as seguintes seções:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
* [OpenAPI 3 Library for spring-boot](https://springdoc.org/)

## Guias
Os guias abaixo ilustram como usar alguns recursos concretamente:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

## Links adicionais
Estas referências adicionais também devem ajudá-lo:

* [Declarative REST calls with Spring Cloud OpenFeign sample](https://github.com/spring-cloud-samples/feign-eureka)

