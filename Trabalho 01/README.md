# Trabalho Prático 01 - Prazo limite: 31/10/2021 (Domingo)

## Resolver

**1**. Defina uma entidade principal relacionada a um domínio de problema e crie uma classe Java para representá-la. Exemplo: Livro: isbn, titulo, editora, ano_publicacao.

**2**. Crie uma classe Java para cadastrar dados relacionados à entidade definida na questão 1. A classe deve receber dados via teclado e os salvar ao final de um arquivo CSV (append).

**3**. Crie uma classe Java que recebe como entrada o arquivo salvo na questão 2, lê o arquivo e o transforma em objetos Java em memória. Depois, salva os objetos em formatos XML e JSON.

## Como executar

Versão do java que o arquivo foi compilado: `jdk-11.0.12.7-hotspot`

Dependendo do terminal e da configuração do java, os caracteres mostrados no console, podem ficar fora do padrão UTF-8.

```bash
$ java -jar 'Trabalho 01.jar'
```

O csv se encontra será gerado em `data/data.csv`

Os objetos serializados em `xml` e `json` serão salvos em `data/users/*.{json,xml}`

## Como funciona o menu

1. A primeira opção do menu registra as informações dos usuários com o append no csv.
2. A segunda opção do menu mostra todos os usuários registrados no `data.csv` que ainda não foram serializados, ou seja, não possuem um objeto serializado em `data/users/*.{json, xml}`.
3. Ainda na segunda opção do menu, ao selecionar um index de um usuário e confirmar a serialização, o objeto do usuário é salvo em `data/users/*.{json, xml}` como `json` e `xml`.
4. Na terceira opção do menu é possível visualizar os usuários serializados em objetos, como também é possível ver em quais tipos de arquivos eles foram salvos.
5. A quarta opção pede pra informar o email e senha do usuário, e se esses dados baterem com os objetos serializados em `data/users/*.{json, xml}`, então ele mostra os dados do usuário.
6. A quinta e última opção ela apenas finaliza o aplicativo.
