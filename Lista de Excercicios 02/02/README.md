## Descrição

Escolha e baixe um arquivo csv a partir do [link](https://zenodo.org/record/3469741#.X8jwkapKhQI) e use-o nas questões a seguir. Na resolução desta questão, não enviar os arquivos envolvidos, mas somente os resultados pedidos em arquivo PDF.

- Gere as somas md5 e sha1 do arquivo encriptado.
- Compacte via linha de comando o arquivo csv original usando compressões zip, gzip, bzip2, rar e 7zip. Depois disso compare os tempos e tamanhos dos arquivos gerados. Dica: para obter o tempo de execução, use o comando time.
  - Exemplo: `time zip iris.zip iris.csv`


## Resultados
- `7zip`: 1 minuto e 24.30 segundos
- `bzip2`: 42.523 segundos
- `rar`: 30.6 segundos
- `zip`: 22.243 segundos
- `gzip`: 16.593 segundos

