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
    (println "Divisão (/ a b):" (/ a b) "ou" (float (/ a b)) "como decimal")
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

(defn demo-predicates
  "Funções predicado úteis (retornam true/false)."
  []
  (println "=== PREDICADOS ÚTEIS ===")
  (let [valores [nil 0 "" [] {} :keyword "texto" 42]]
    (println "Valores testados:" valores)
    (println)
    (doseq [v valores]
      (println (format "%-10s -> nil? %s, empty? %s, zero? %s, pos? %s, neg? %s"
                       (str v)
                       (nil? v)
                       (if (coll? v) (empty? v) "N/A")
                       (if (number? v) (zero? v) "N/A")
                       (if (number? v) (pos? v) "N/A")
                       (if (number? v) (neg? v) "N/A"))))
    (println)
    (println "Checagem de tipos:")
    (doseq [v valores]
      (println (format "%-10s -> number? %s, string? %s, keyword? %s, coll? %s"
                       (str v)
                       (number? v)
                       (string? v)
                       (keyword? v)
                       (coll? v))))))

(defn demo-threading
  "Threading macros para encadear operações."
  []
  (println "=== THREADING MACROS ===")
  (let [dados {:nome "João" :idade 30 :salario 5000}]
    (println "Dados originais:" dados)
    (println)
    (println "Thread-first (->): passa resultado como primeiro argumento")
    (println "Comando: (-> dados :salario (* 1.1) int)")
    (println "Resultado:" (-> dados :salario (* 1.1) int))
    (println)
    (println "Thread-last (->>): passa resultado como último argumento") 
    (println "Comando: (->> [1 2 3 4 5] (filter odd?) (map #(* % 2)) (reduce +))")
    (println "Resultado:" (->> [1 2 3 4 5] (filter odd?) (map #(* % 2)) (reduce +)))
    (println)
    (println "Some-> (thread-first com nil safety):")
    (println "Comando: (some-> {:a {:b 10}} :a :b inc)")
    (println "Resultado:" (some-> {:a {:b 10}} :a :b inc))
    (println "Com nil: (some-> {:a nil} :a :b inc)")
    (println "Resultado:" (some-> {:a nil} :a :b inc))))

(defn demo-apply-partial
  "Funções apply e partial para composição."
  []
  (println "=== APPLY E PARTIAL ===")
  (let [nums [1 2 3 4 5]]
    (println "Números:" nums)
    (println)
    (println "apply - aplica função a coleção como argumentos separados:")
    (println "Comando: (apply + nums)")
    (println "Resultado:" (apply + nums))
    (println "Comando: (apply max nums)")
    (println "Resultado:" (apply max nums))
    (println)
    (println "partial - cria função com alguns argumentos pré-definidos:")
    (let [add-10 (partial + 10)
          multiply-by-3 (partial * 3)]
      (println "add-10 = (partial + 10)")
      (println "multiply-by-3 = (partial * 3)")
      (println "Aplicar add-10 em cada número: (map add-10 nums)")
      (println "Resultado:" (map add-10 nums))
      (println "Aplicar multiply-by-3 em cada número: (map multiply-by-3 nums)")
      (println "Resultado:" (map multiply-by-3 nums)))))

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
  (demo-conditionals)
  (println)
  (demo-predicates)
  (println)
  (demo-threading)
  (println)
  (demo-apply-partial))
