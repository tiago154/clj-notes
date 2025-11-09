# Challenges

Esta pasta contém desafios práticos em Clojure que combinam múltiplos conceitos da linguagem em cenários realistas.

## Objetivos dos Challenges

- **Aplicação prática**: Usar Clojure em problemas do mundo real
- **Múltiplos conceitos**: Combinar threading macros, manipulação de coleções, funções de alta ordem
- **Experiência completa**: Desde estruturação de dados até apresentação de resultados
- **Aprendizado progressivo**: Cada challenge introduz complexidade gradualmente

## Challenges Disponíveis

### 📦 Order Processing (`order_processing.clj`)

**Cenário**: Sistema de processamento de pedidos de um e-commerce

**Conceitos praticados**:
- Threading macros (`->>`)
- Funções de alta ordem (`map`, `filter`, `reduce`)
- Manipulação de coleções (`group-by`, `frequencies`, `sort-by`)
- Destructuring e transformação de dados
- Keyword/namespace conversions

**Execute com**:
```bash
clj -M:challenge-orders
# ou
clj -M -m challenges.order-processing
```

## Como usar os Challenges

1. **Leia o enunciado**: Cada arquivo começa com o problema a ser resolvido
2. **Execute o código**: Use os comandos indicados para ver a solução funcionando
3. **Analise a implementação**: Estude como os conceitos se combinam
4. **Experimente no REPL**: Teste funções individuais para entender cada parte
5. **Modifique e expanda**: Adicione novos recursos ou otimizações

## Sugestões de novos Challenges

- **Análise de logs**: Processar arquivos de log e extrair métricas
- **API client**: Consumir APIs REST e processar respostas JSON
- **Sistema bancário**: Gerenciar contas, transferências e extração de relatórios
- **Análise de texto**: Processamento de linguagem natural básica
- **Game of Life**: Implementação do jogo da vida de Conway

Contribua adicionando novos desafios seguindo o mesmo padrão!