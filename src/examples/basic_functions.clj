(ns examples.basic-functions)

(def number 10)
(def numbers [3 7 2 9 4])

(defn demo-arithmetic
  "Operações aritméticas básicas."
  []
  (println "=== OPERAÇÕES ARITMÉTICAS ===")
  (let [a 10, b 3]
    (println "Números:" a "e" b)
    (println "Soma (+ a b):" (+ a b))
    (println "Subtração (- a b):" (- a b))
    (println "Multiplicação (* a b):" (* a b))
    (println "Divisão (/ a b):" (/ a b))
    (println "Resto (mod a b):" (mod a b))))

(defn demo-increment-decrement
  "Funções de incremento e decremento."
  []
  (println "=== INCREMENT/DECREMENT ===")
  (println "Número original:" number)
  (println "Incrementar (inc number):" (inc number))
  (println "Decrementar (dec number):" (dec number)))

(defn demo-min-max
  "Funções de mínimo e máximo."
  []
  (println "=== MIN/MAX ===")
  (println "Números:" numbers)
  (println "Maior número (apply max numbers):" (apply max numbers))
  (println "Menor número (apply min numbers):" (apply min numbers))
  (println "Max entre dois valores (max 15 8):" (max 15 8))
  (println "Min entre dois valores (min 15 8):" (min 15 8)))

(defn demo-comparison
  "Operações de comparação."
  []
  (println "=== COMPARAÇÕES ===")
  (let [x 5, y 10, z 5]
    (println "Valores:" x y z)
    (println "x = y? (= x y):" (= x y))
    (println "x = z? (= x z):" (= x z))
    (println "x < y? (< x y):" (< x y))
    (println "x > y? (> x y):" (> x y))
    (println "x <= z? (<= x z):" (<= x z))
    (println "x >= z? (>= x z):" (>= x z))))

(defn demo-conditionals
  "Estruturas condicionais básicas."
  []
  (println "=== CONDICIONAIS ===")
  (let [idade 25]
    (println "Idade:" idade)
    (println "if simples: (if (>= idade 18) \"Adulto\" \"Menor\")")
    (println "Resultado:" (if (>= idade 18) "Adulto" "Menor"))
    (println)
    (println "when (executa apenas se verdadeiro): (when (> idade 20) ...)")
    (when (> idade 20)
      (println "Resultado: Pessoa tem mais de 20 anos!"))
    (println)
    (println "cond (múltiplas condições):")
    (println "Comando: (cond (< idade 13) \"Criança\" (< idade 18) \"Adolescente\" :else \"Adulto\")")
    (println "Resultado:" 
             (cond
               (< idade 13) "Criança"
               (< idade 18) "Adolescente"  
               (< idade 60) "Adulto"
               :else "Idoso"))))

(defn -main
  "Executa todos os exemplos deste arquivo."
  [& _]
  (demo-arithmetic)
  (println)
  (demo-increment-decrement)
  (println)
  (demo-min-max)
  (println)
  (demo-comparison)
  (println)
  (demo-conditionals))
