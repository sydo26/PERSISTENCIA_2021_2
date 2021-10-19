## Descrição

Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

- arquivo config.properties
  - **linha_inicial** = 1
  - **linha_final** = 3
- Depois, escreva uma classe Java que recebe via linha de comando o nome de um arquivo texto, e exibe da **linha_inicial** até a **linha_final**, conforme definidas no arquivo de propriedades `config.properties`.

## Estrutura das pastas

A estrutura das pastas contém duas principais pastas, que são:

- `src`: a pasta onde se encontra o código fonte
- `lib`: a pasta onde se encontra as dependências

Os arquivos compilados serão gerados na pasta `bin` por padrão.

## Como executar

Versão do java que o arquivo foi compilado: `jdk-11.0.12.7-hotspot`

```bash
$ java -jar 03.jar resources/file.txt
```

Arquivo usado nos testes: `resources/file.txt`
