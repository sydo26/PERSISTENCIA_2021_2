## Descrição

Escreva uma aplicação para ler um arquivo binário origem e gravá-lo em outro arquivo (arquivo destino).

- Os nomes dos arquivos (origem e destino) devem ser definidos na chamada da aplicação via argumento de linha de comando.
- A leitura e gravação devem ser realizadas em blocos de bytes e não byte a byte.
- Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida.
- Teste vários tamanhos de bloco e encontre um tamanho que ofereça um bom desempenho. Crie uma tabela para comparar os resultados encontrados.

## Estrutura das pastas

A estrutura das pastas contém duas principais pastas, que são:

- `src`: a pasta onde se encontra o código fonte
- `lib`: a pasta onde se encontra as dependências

Os arquivos compilados serão gerados na pasta `bin` por padrão.

## Como executar

Versão do java que o arquivo foi compilado: `jdk-11.0.12.7-hotspot`

```bash
$ java -jar 01.jar
```

Arquivo de teste utilizado: `resources/example.jpg`

As métricas com os testes da aplicação se encontram no arquivo [table.md](table.md).
