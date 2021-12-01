# Lista de Exercícios 06 - Prazo limite: 30/11/2020 (Terça)

## O que deve ter

A Lista 06 é pegar seu projeto da Lista 05 e adicionar uma implementação DAO usando JPA, como nos exemplos que disponibilizei. Pode anotar esse novo DAO que você criar com @Repository e @Primary para que o Spring Boot disponibilize esse bean para injetá-lo como dependência à sua classe que tem o main. Por enquanto, vamos usar o Spring Boot apenas.

## Como executar

Versão do java que o arquivo foi compilado: `jdk-11.0.12.7-hotspot`

Dependendo do terminal e da configuração do java, os caracteres mostrados no console, podem ficar fora do padrão UTF-8.

Obs: Ocorreu um problema ao compilar o arquivo `Lista de Exercicios 06.jar`, pois o mesmo ao executar causa o erro: `No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.`. Mas o app funciona corretamente caso execute pelo maven.

```bash
$ docker-compose up -d
$ mvn spring-boot:run
```

O arquivo de configuração do spring se encontra em `src/main/resources/application.properties`

## Como funciona o menu

1. A primeira opção do menu, `Registrar funcionário`, é responsável por cadastrar um novo funcionário no banco de dados.
2. A segunda opção, `Mostrar todos os funcionários`, lista até 50 funcionários em ordem decrescente para visualizarmos os últimos adicionados.
3. A terceira opção, `Gerar funcionários fakes`, é para fins de testes, onde são gerados 20 funcionários com dados fakes.
4. Na quarta opção, `Procurar funcionário`, procura um funcionário pelo primeiro resultado do cpf, id ou matrícula.
5. A quinta opção, `Deletar um funcionário`, deleta um funcionário pelo id.
6. O `(exit)` finaliza a aplicação e a conexão com o banco de dados.
