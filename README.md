# Clojure Notes

Coleção simples de exemplos em Clojure para consulta rápida sobre estruturas de dados, funções utilitárias e manipulação de sequências.

## Estrutura sugerida

```
clj-notes/
├── deps.edn
└── src/
    └── examples/
        ├── data_structures.clj   ; operações com vetores, mapas e sets
        ├── functions.clj         ; funções de ordem superior e utilidades
        └── sequences.clj         ; sequências, lazy, destructuring
```

Você pode adicionar mais arquivos dentro de `src/examples` seguindo o mesmo padrão. Cada namespace possui uma função `-main` que executa os exemplos do arquivo.

## Pré-requisitos

- [Clojure CLI](https://clojure.org/guides/install_clojure) instalada e disponível no `PATH` (o comando `clj` precisa funcionar no terminal).

## Executando os exemplos

### Rodar tudo de um arquivo específico

```bash
clj -M -m examples.data-structures
clj -M -m examples.functions
clj -M -m examples.sequences
```

### Usando aliases prontos (opcional)

O arquivo `deps.edn` possui aliases para facilitar:

```bash
clj -M:run-data
clj -M:run-fn
clj -M:run-seq
clj -M:lint
```

### Verificar o código com lint

O alias `lint` usa [clj-kondo](https://github.com/clj-kondo/clj-kondo) para analisar os arquivos em `src`:

```bash
clj -M:lint
```

O primeiro uso baixa o binário do clj-kondo automaticamente pelo Maven.

### Explorar no REPL

Para abrir um REPL interativo:

```bash
clj
```

Dentro do REPL carregue o namespace desejado e execute as funções expondo exemplos isolados:

```clojure
(require 'examples.data-structures)
(examples.data-structures/demo-maps)

(require 'examples.functions)
(examples.functions/demo-reduce)
```

Adicione mais funções e exemplos conforme aprender novos recursos. Manter os exemplos curtos e temáticos ajuda a localizar rapidamente a referência que você precisa.
