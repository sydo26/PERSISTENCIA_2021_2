# Lista de Exercícios 8 - Prazo limite: 01/02/2022 (Terça)

## O que deve ter

Crie uma aplicação Java para permitir a inclusão e consultas a artigos e tags no Redis, de acordo com a modelagem de dados e os exemplos apresentados no seguinte link. Não é necessário adicionar interação com o usuário, nem precisa usar o Spring Boot. Sua aplicação deve listar:

- Todas as tags de um determinado artigo.
- Todos os artigos de uma determinada tag.
- Nome e descrição de todos os artigos.

Dica: exemplos de uso da API Jedis do Redis nos slides da disciplina e no link a seguir:

- Intro to Jedis - the Java Redis Client Library | Baeldung

## Como executar

Versão do java que o arquivo foi compilado: `JavaSE-1.8`

```bash
$ docker-compose up -d
$ java -jar '.\Lista de Exercicios 08.jar'
```
