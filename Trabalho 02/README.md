# Trabalho Prático 02 - Prazo limite: 12/01/2022 (Terça)

## O que deve ter

1. Crie uma aplicação que use um banco relacional contendo uma tabela de alunos e suas disciplinas cursadas, com suas respectivas classes Java. Cada aluno deve ter um id, cpf, matrícula, nome, email e data de nascimento. Cada disciplina tem somente id, código e nome. Os campos id, código, matrícula e email, considerados individualmente, não devem permitir duplicação, ou seja devem ser únicos. Existe uma associação entre alunos e disciplinas de modo que um aluno pode cursar várias disciplinas e uma disciplinas pode ser cursada por vários alunos. As tabelas devem ser criadas a partir dos mapeamentos das classes (entidades) através do JPA.
   Use o padrão de persistência DAO neste trabalho usando os recursos do Spring Boot / Spring Data JPA.

1. Crie uma classe para adicionar via DAO pelo menos 6 alunos com suas respectivas disciplinas cursadas no banco de dados. Pelo menos 50% dos alunos devem ter disciplinas cursadas.

1. Crie uma classe para inserir, atualizar e deletar alunos e disciplinas separadamente. A classe deve permitir também adicionar disciplinas cadastradas a um determinado aluno também já cadastrado.

1. Crie e exiba o resultado de consultas usando @Query ou @NamedQuery ou consultas do Spring Data JPA baseadas apenas em nomes de métodos (pelo menos uma consulta de cada um desses tipos) no Spring para as consultas abaixo:
   <ol type="a">
    <li>Mostrar os nomes os alunos e todas as suas disciplinas cursadas somente para alunos com nomes contendo determinada string. Ou seja: a string de busca deve ser um parâmetro nomeado da consulta.</li>

    <li>Dado um código de disciplina, mostrar todos os alunos que a cursaram.</li>

    <li>Mostrar os nomes de todos os alunos com suas respectivas quantidades de disciplinas cursadas.</li>

    <li>Dada uma matrícula, mostrar o nome e email do aluno.</li>

    <li>Dada uma data, mostrar somente os alunos que nasceram depois dela. </li>
   </ol>

## Como executar

Versão do java que o arquivo foi compilado: `jdk-11.0.12.7-hotspot`

Dependendo do terminal e da configuração do java, os caracteres mostrados no console, podem ficar fora do padrão UTF-8.

```bash
$ docker-compose up -d
$ mvn spring-boot:run
```

O arquivo de configuração do spring se encontra em `src/main/resources/application.properties`

## Como funciona o menu

Exatamente a mesma função pedida na questão, em cada letra.
