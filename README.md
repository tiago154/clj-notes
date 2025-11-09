# Clojure Notes

Coleção de exemplos em Clojure para consulta rápida sobre estruturas de dados, funções utilitárias e desafios práticos de programação.

## Estrutura do projeto

```
clj-notes/
├── deps.edn
└── src/
    ├── examples/         ; exemplos básicos por tópico
    │   ├── basic_functions.clj   ; operações básicas, aritmética, comparações
    │   ├── data_structures.clj   ; operações com vetores, mapas e sets
    │   ├── functions.clj         ; funções de ordem superior e utilidades
    │   └── sequences.clj         ; sequências, lazy, destructuring
    └── challenges/       ; desafios práticos usando múltiplos conceitos
        └── order_processing.clj  ; sistema de processamento de pedidos
```

### Examples vs Challenges

- **examples/**: Exemplos isolados de conceitos específicos da linguagem
- **challenges/**: Problemas práticos que combinam múltiplos conceitos em cenários realistas

## Pré-requisitos

- [Clojure CLI](https://clojure.org/guides/install_clojure) instalada e disponível no `PATH` (o comando `clj` precisa funcionar no terminal).

## Executando os exemplos

### Rodar exemplos básicos por tópico

```bash
clj -M -m examples.basic-functions
clj -M -m examples.data-structures
clj -M -m examples.functions
clj -M -m examples.sequences
```

### Rodar desafios práticos

```bash
clj -M -m challenges.order-processing
```

### Usando aliases prontos (opcional)

O arquivo `deps.edn` possui aliases para facilitar:

**Exemplos:**
```bash
clj -M:run-basic    # basic functions
clj -M:run-data     # data structures
clj -M:run-fn       # functions
clj -M:run-seq      # sequences
```

**Desafios:**
```bash
clj -M:challenge-orders  # processamento de pedidos
```

**Linting:**
```bash
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

Dentro do REPL carregue o namespace desejado e execute as funções:

**Exemplos básicos:**
```clojure
(require 'examples.basic-functions)
(examples.basic-functions/demo-arithmetic)

(require 'examples.data-structures)
(examples.data-structures/demo-maps)

(require 'examples.functions)
(examples.functions/demo-reduce)
```

**Desafios:**
```clojure
(require 'challenges.order-processing :reload)
(challenges.order-processing/demo-order-processing)

;; Ou teste funções específicas:
(challenges.order-processing/analyze-top-customers 
  challenges.order-processing/sample-orders 3)
```

Adicione mais exemplos e desafios conforme aprender novos recursos. Manter os exemplos temáticos ajuda a localizar rapidamente a referência que você precisa.
