# O estilo Kick Foward

Variação do estilo pipeline com restrições adicionais

- Cada função recebe uma função como parâmetro adicional
- A função parâmetro é aplicada ao final da função atual
- A função parâmetro recebe o output da função atual
- O problema é resolvido como um pipeline de funções, porém a próxima função a ser aplicada é passada como parâmetro da função atual

# Uso

- Compile com

```
sbt compile
```

- E execute com

```
sbt run --words <input>
```

em que *count* é a contagem de palavras desejada e *input* é o arquivo contendo o texto de entrada
