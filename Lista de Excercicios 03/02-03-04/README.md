## Descrição

2. Crie uma classe Java de entidade. Exemplo: _Pessoa (id, nome, email, fone)_. A classe deve implementar a interface `java.io.Serializable`.

3. Crie uma classe Java de nome **Serializa** para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois percorrer a lista e Serializar os objetos em disco/ssd. Serialize para os formatos a seguir:

   - Serialização de objetos da própria API Java [Introduction to Java Serialization | Baeldung](https://www.baeldung.com/java-serialization).
   - JSON usando a biblioteca Jackson [Intro to the Jackson ObjectMapper | Baeldung](https://www.baeldung.com/jackson-object-mapper-tutorial).
   - XML usando a biblioteca Jackson [XML Serialization and Deserialization with Jackson | Baeldung](https://www.baeldung.com/jackson-xml-serialization-and-deserialization).

4. Crie uma classe java de nome **Desserializa** para ler / desserializar os objetos Serializados na Questão 2 e exibi-los. Não precisa implementar nos 3 formatos usados na Questão 3. Basta escolher um deles (Objeto Java, JSON ou XML).

## Estrutura das pastas

A estrutura das pastas contém duas principais pastas, que são:

- `resources`: a posta onde estará os arquivos usados pela aplicação.
- `src`: a posta onde tem o código fonte da aplicação

## Como executar

Versão do java que o arquivo foi compilado: `jdk-11.0.12.7-hotspot`

```bash
$ java -jar 02-03-04.jar
```

Arquivo usado nos testes serão gerados em: `resources/*`
Para testar, recomendo deletar os arquivos da pasta `resources`
