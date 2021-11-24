# Lista de Exercícios 05 - Prazo limite: 23/11/2020 (Terça)

## O que deve ter

Converter a Lista de Exercícios 04 sobre JDBC para usar o Spring, como implementado na aula de 17/11/2021 (Quarta). Usar o Lombok para definição de construtores, getters e setters das classes de entidade (modelo).

Lista 04:

**1**. Crie uma aplicação que use um banco relacional contendo uma tabela de funcionários, com suas respectivas classes Java.

**2**. Cada funcionário deve ter um id, cpf, matrícula, nome, email e telefone.

**3**. Os campos id, cpf e matrícula devem não devem permitir duplicação, ou seja devem ser únicos.

**4**. Crie uma implementação de DAO usando JDBC que representa uma interface única para persistência dos dados.

**5**. Crie e use no DAO somente os métodos realmente necessários para a resolução desta lista. Crie-os sob demanda.

**6**. Crie métodos no DAO para inserir, deletar, alterar e consultar funcionários.

**7**. A aplicação deve ter um menu para realizar as funcionalidades previstas nas questões anteriores (consultas e atualizações).

## Como executar

Versão do java que o arquivo foi compilado: `jdk-11.0.12.7-hotspot`

Dependendo do terminal e da configuração do java, os caracteres mostrados no console, podem ficar fora do padrão UTF-8.

Obs: Ocorreu um problema ao compilar o arquivo `Lista de Exercicios 05.jar`, pois o mesmo ao executar causa o erro: `No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.`. Mas o app funciona corretamente caso execute pelo maven.

```bash
$ docker-compose up -d
$ mvn spring-boot:run
```

O arquivo de configuração do spring se encontra em `src/main/resources/config.yaml`

O schema do banco de dados se encontra em `src/mainresources/schema.sql`

## Como funciona o menu

1. A primeira opção do menu, `Registrar funcionário`, é responsável por cadastrar um novo funcionário no banco de dados.
2. A segunda opção, `Mostrar todos os funcionários`, lista até 50 funcionários em ordem decrescente para visualizarmos os últimos adicionados.
3. A terceira opção, `Gerar funcionários fakes`, é para fins de testes, onde são gerados 20 funcionários com dados fakes.
4. Na quarta opção, `Procurar funcionário`, procura um funcionário pelo primeiro resultado do cpf, id ou matrícula.
5. A quinta opção, `Deletar um funcionário`, deleta um funcionário pelo id.
6. O `(exit)` finaliza a aplicação e a conexão com o banco de dados.
