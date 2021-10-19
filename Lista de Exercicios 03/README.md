# Lista de Exercícios 03 - Prazo limite: 19/10/2021 (Terça)

## Resolver

**01**. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

- arquivo config.properties
  - **linha_inicial** = 1
  - **linha_final** = 3
- Depois, escreva uma classe Java que recebe via linha de comando o nome de um arquivo texto, e exibe da **linha_inicial** até a **linha_final**, conforme definidas no arquivo de propriedades `config.properties`.

**02**. Crie uma classe Java de entidade. Exemplo: _Pessoa (id, nome, email, fone)_. A classe deve implementar a interface `java.io.Serializable`.

**03**. Crie uma classe Java de nome **Serializa** para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois percorrer a lista e Serializar os objetos em disco/ssd. Serialize para os formatos a seguir:

- Serialização de objetos da própria API Java [Introduction to Java Serialization | Baeldung](https://www.baeldung.com/java-serialization).
- JSON usando a biblioteca Jackson [Intro to the Jackson ObjectMapper | Baeldung](https://www.baeldung.com/jackson-object-mapper-tutorial).
- XML usando a biblioteca Jackson [XML Serialization and Deserialization with Jackson | Baeldung](https://www.baeldung.com/jackson-xml-serialization-and-deserialization).

**04**. Crie uma classe java de nome **Desserializa** para ler / desserializar os objetos Serializados na Questão 2 e exibi-los. Não precisa implementar nos 3 formatos usados na Questão 3. Basta escolher um deles (Objeto Java, JSON ou XML).
