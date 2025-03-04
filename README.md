# To do

Java RESTful API criada para organizar tarefas.

## Principais Tecnologias
 - **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
    class Tarefa {
        +String nome
        +String status
        +String prazo
        +Usuario responsavel
    }

    class Usuario {
        +int id
        +String nome
        +String email
    }

    Usuario "1" --> "0..*" Tarefa : "é responsável por"
```
