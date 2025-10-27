(ns examples.sequences)

(def words ["clojure" "é" "muito" "legal"])

(defn demo-list-comprehension
  "Mostra uso de for para gerar novas sequências."
  []
  (println "Combinações (for [w words :when (> (count w) 5)] (str w \"!\")):" (for [w words :when (> (count w) 5)] (str w "!"))))

(defn demo-lazy
  "Trabalha com sequências infinitas usando lazy-seq."
  []
  (let [pares (take 10 (iterate #(+ % 2) 0))]
    (println "Primeiros 10 pares com iterate:" pares)))

(defn demo-destructuring
  "Exibe destructuring em let e function args."
  []
  (let [[primeiro segundo & resto] words]
    (println "Primeiro:" primeiro)
    (println "Segundo:" segundo)
    (println "Resto:" resto))
  (let [{nome :nome idade :idade} {:nome "Tiago" :idade 30 :cidade "Recife"}]
    (println "Nome:" nome)
    (println "Idade:" idade)))

(defn -main
  "Executa todos os exemplos deste arquivo."
  [& _]
  (demo-list-comprehension)
  (println)
  (demo-lazy)
  (println)
  (demo-destructuring))
