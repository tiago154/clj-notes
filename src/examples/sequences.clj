(ns examples.sequences
  (:require [clojure.string :as str]))

(def words ["clojure" "é" "muito" "legal"])

(defn demo-list-comprehension
  "Mostra uso de for para gerar novas sequências com filtro e transformação."
  []
  (println "=== LIST COMPREHENSION COM FOR ===")
  (println "Words originais:" words)
  (println "Contagem de caracteres por palavra (map count words):" (map count words))
  (println)
  (println "FOR básico (sem filtro):")
  (println "Comando: (for [w words] (str w \"!\"))")
  (println "Resultado:" (for [w words] (str w "!")))
  (println)
  (println "FOR com filtro :when e transformação:")
  (println "  - Filtro: palavras com mais de 5 caracteres (> (count w) 5)")
  (println "  - Transformação: adicionar '!' no final (str w \"!\")")
  (println "Comando: (for [w words :when (> (count w) 5)] (str w \"!\"))")
  (println "Resultado:" (for [w words :when (> (count w) 5)] (str w "!")))
  (println)
  (println "Outros exemplos de FOR:")
  (println "Produto cartesiano: (for [x [1 2] y [:a :b]] [x y])")
  (println "Resultado:" (for [x [1 2] y [:a :b]] [x y]))
  (println "Com múltiplos filtros: (for [n (range 10) :when (even? n) :when (> n 2)] n)")
  (println "Resultado:" (for [n (range 10) :when (even? n) :when (> n 2)] n)))

(defn demo-lazy
  "Trabalha com sequências infinitas usando lazy-seq."
  []
  (println "=== SEQUÊNCIAS LAZY (PREGUIÇOSAS) ===")
  (println "Gerar sequência infinita começando em 0, incrementando de 2")
  (println "Comando: (iterate #(+ % 2) 0)")
  (println "Pegar apenas 10 elementos: (take 10 (iterate #(+ % 2) 0))")
  (let [pares (take 10 (iterate #(+ % 2) 0))]
    (println "Resultado:" pares))
  (println)
  (println "Outros exemplos de sequências lazy:")
  (println "Range infinito: (take 5 (range))" (take 5 (range)))
  (println "Repetir valor: (take 3 (repeat :x))" (take 3 (repeat :x)))
  (println "Ciclo infinito: (take 7 (cycle [1 2]))" (take 7 (cycle [1 2]))))

(defn demo-destructuring
  "Exibe destructuring em let e function args."
  []
  (println "=== DESTRUCTURING DE VETOR ===")
  (println "Vetor original:" words)
  (println "Comando: (let [[primeiro segundo & resto] words] ...)")
  (let [[primeiro segundo & resto] words]
    (println "Resultado do destructuring:")
    (println "  primeiro =" primeiro)
    (println "  segundo  =" segundo)
    (println "  resto    =" resto))
  (println)
  (println "Outros padrões de destructuring de vetor:")
  (println "Pular elementos: (let [[a _ c] [1 2 3]] [a c])" (let [[a _ c] [1 2 3]] [a c]))
  (println "Com :as: (let [[_ _ :as tudo] [1 2 3]] tudo)" (let [[_ _ :as tudo] [1 2 3]] tudo))
  (println)
  (println "=== DESTRUCTURING DE MAPA ===")
  (let [pessoa {:nome "Tiago" :idade 30 :cidade "Recife"}]
    (println "Mapa original:" pessoa)
    (println "Comando: (let [{nome :nome idade :idade} pessoa] ...)")
    (let [{nome :nome idade :idade} pessoa]
      (println "Resultado do destructuring:")
      (println "  nome  =" nome)
      (println "  idade =" idade)
      (println "  (cidade foi ignorada no destructuring)"))
    (println)
    (println "Outros padrões de destructuring de mapa:")
    (println "Com :keys: (let [{:keys [nome idade]} pessoa] [nome idade])")
    (let [{:keys [nome idade]} pessoa]
      (println "Resultado:" [nome idade]))
    (println "Com :or (valores padrão): (let [{:keys [salario] :or {salario 0}} pessoa] salario)")
    (let [{:keys [salario] :or {salario 0}} pessoa]
      (println "Resultado:" salario))))

(defn demo-sequence-operations
  "Operações avançadas com sequências."
  []
  (println "=== OPERAÇÕES AVANÇADAS DE SEQUÊNCIAS ===")
  (let [nums1 [1 2 3 4 5]
        nums2 [6 7 8 9 10]
        mixed [1 2 2 3 3 3 4]]
    (println "nums1:" nums1)
    (println "nums2:" nums2)
    (println "mixed:" mixed)
    (println)
    (println "concat - concatena sequências:")
    (println "Comando: (concat nums1 nums2)")
    (println "Resultado:" (concat nums1 nums2))
    (println)
    (println "distinct - remove duplicatas:")
    (println "Comando: (distinct mixed)")
    (println "Resultado:" (distinct mixed))
    (println)
    (println "dedupe - remove duplicatas consecutivas:")
    (println "Comando: (dedupe mixed)")
    (println "Resultado:" (dedupe mixed))
    (println)
    (println "reverse - inverte sequência:")
    (println "Comando: (reverse nums1)")
    (println "Resultado:" (reverse nums1))
    (println)
    (println "sort / sort-by - ordenação:")
    (let [pessoas [{:nome "Carlos" :idade 25} {:nome "Ana" :idade 30} {:nome "Bruno" :idade 20}]]
      (println "pessoas:" pessoas)
      (println "Comando: (sort-by :idade pessoas)")
      (println "Resultado:" (sort-by :idade pessoas)))))

(defn demo-lazy-advanced
  "Sequências lazy avançadas e infinitas."
  []
  (println "=== SEQUÊNCIAS LAZY AVANÇADAS ===")
  (println "lazy-seq - criar sequência lazy customizada:")
  (letfn [(fibonacci
            ([] (fibonacci 0 1))
            ([a b] (lazy-seq (cons a (fibonacci b (+ a b))))))]
    (println "Primeiros 10 números Fibonacci: (take 10 (fibonacci))")
    (println "Resultado:" (take 10 (fibonacci))))
  (println)
  (println "repeatedly - gera sequência aplicando função repetidamente:")
  (println "Comando: (take 5 (repeatedly #(rand-int 10)))")
  (println "Resultado:" (take 5 (repeatedly #(rand-int 10))))
  (println)
  (println "tree-seq - navega estruturas em árvore:")
  (let [arvore {:valor 1 
                :filhos [{:valor 2 :filhos []} 
                         {:valor 3 :filhos [{:valor 4 :filhos []}]}]}]
    (println "Árvore:" arvore)
    (println "Comando: (map :valor (tree-seq :filhos :filhos arvore))")
    (println "Resultado:" (map :valor (tree-seq :filhos :filhos arvore)))))

(defn demo-transient-persistent
  "Estruturas transient para performance."
  []
  (println "=== TRANSIENT E PERSISTENT ===")
  (println "Estruturas transient são mutáveis temporariamente para performance:")
  (let [nums (range 1000)]
    (println "Criando vetor de 1000 elementos...")
    (println "Método tradicional (imutável):")
    (println "Comando: (reduce conj [] nums)")
    (let [result1 (time (reduce conj [] nums))]
      (println "Tamanho:" (count result1)))
    (println)
    (println "Método transient (temporariamente mutável):")
    (println "Comando: (persistent! (reduce conj! (transient []) nums))")
    (let [result2 (time (persistent! (reduce conj! (transient []) nums)))]
      (println "Tamanho:" (count result2)))
    (println "Ambos produzem o mesmo resultado, mas transient é mais rápido!")))

(defn demo-regex-patterns
  "Padrões regex e processamento de texto."
  []
  (println "=== REGEX E PROCESSAMENTO DE TEXTO ===")
  (let [texto "João tem 25 anos, Maria tem 30 anos, Pedro tem 22 anos"]
    (println "Texto:" texto)
    (println)
    (println "re-find - encontra primeira ocorrência:")
    (println "Comando: (re-find #\"\\\\d+\" texto)")
    (println "Resultado:" (re-find #"\d+" texto))
    (println)
    (println "re-seq - encontra todas ocorrências:")
    (println "Comando: (re-seq #\"\\\\d+\" texto)")
    (println "Resultado:" (re-seq #"\d+" texto))
    (println)
    (println "re-matches - verifica se toda string casa com padrão:")
    (println "Comando: (re-matches #\"\\\\w+\" \"Joao\") (sem acentos)")
    (println "Resultado:" (re-matches #"\w+" "Joao"))
    (println "Com acentos (re-matches #\"\\\\w+\" \"João\") -> nil (acentos não casam com \\\\w)")
    (println "Resultado:" (re-matches #"\w+" "João"))
    (println)
    (println "clojure.string/split com regex:")
    (println "Comando: (str/split texto #\", \")")
    (println "Resultado:" (str/split texto #", "))))

(defn -main
  "Executa todos os exemplos deste arquivo."
  [& _]
  (demo-list-comprehension)
  (println)
  (demo-lazy)
  (println)
  (demo-destructuring)
  (println)
  (demo-sequence-operations)
  (println)
  (demo-lazy-advanced)
  (println)
  (demo-transient-persistent)
  (println)
  (demo-regex-patterns))
