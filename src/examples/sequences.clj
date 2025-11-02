(ns examples.sequences)

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

(defn -main
  "Executa todos os exemplos deste arquivo."
  [& _]
  (demo-list-comprehension)
  (println)
  (demo-lazy)
  (println)
  (demo-destructuring))
