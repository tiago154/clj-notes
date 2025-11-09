(ns examples.functions)

(def numbers [1 2 3 4 5])
(def people [{:nome "Ana" :idade 28}
						 {:nome "Bruno" :idade 17}
						 {:nome "Carla" :idade 33}])

(defn demo-map
	"Aplica transformação em cada elemento de uma coleção."
	[]
	(println "Numbers originais:" numbers)
	(println "People originais:" people)
	(println "Dobrar números (map #(* 2 %) numbers):" (map #(* 2 %) numbers))
	(println "Extrair nomes (map :nome people):" (map :nome people)))

(defn demo-filter
	"Filtra elementos que satisfazem uma condição."
	[]
	(println "Numbers originais:" numbers)
	(println "People originais:" people)
	(println "Maiores que 3 (filter #(> % 3) numbers):" (filter #(> % 3) numbers))
	(println "Pessoas adultas (filter #(>= (:idade %) 18) people):" (filter #(>= (:idade %) 18) people)))

(defn demo-reduce
	"Acumula valores a partir de uma coleção."
	[]
	(println "Numbers originais:" numbers)
	(println "People originais:" people)
	(println "Somar números (reduce + numbers):" (reduce + numbers))
	(println "Concat nomes (reduce #(str %1 \", \" %2) (map :nome people)):"
					 (reduce #(str %1 ", " %2) (map :nome people))))

(defn demo-fn-forms
	"Mostra diferentes formas de declarar funções."
	[]
	(println "=== FORMAS DE DECLARAR FUNÇÕES ===")
	(letfn [(soma [a b] (+ a b))]
		(println "1. Função local com letfn:")
		(println "   (letfn [(soma [a b] (+ a b))] (soma 2 3))")
		(println "   Resultado:" (soma 2 3)))
	(println)
	(println "2. Função anônima com #():")
	(println "   (#(+ %1 %2) 4 5)")
	(println "   Resultado:" (#(+ %1 %2) 4 5))
	(println)
	(let [partial-soma (partial + 10)]
		(println "3. Função parcial:")
		(println "   (partial + 10) -> adiciona 10 a qualquer número")
		(println "   ((partial + 10) 5)")
		(println "   Resultado:" (partial-soma 5))))

(defn demo-juxt-comp
	"Funções juxt e comp para composição avançada."
	[]
	(println "=== JUXT E COMP ===")
	(let [pessoa {:nome "João" :idade 30 :salario 5000}]
		(println "Pessoa:" pessoa)
		(println)
		(println "juxt - aplica múltiplas funções ao mesmo valor:")
		(println "Comando: ((juxt :nome :idade :salario) pessoa)")
		(println "Resultado:" ((juxt :nome :idade :salario) pessoa))
		(println)
		(println "juxt com funções customizadas:")
		(let [stats (juxt count first last)]
			(println "stats = (juxt count first last)")
			(println "Aplicar em" numbers "-> (stats numbers)")
			(println "Resultado:" (stats numbers)))
		(println)
		(println "comp - compõe funções (direita para esquerda):")
		(let [proc (comp str inc #(* 2 %))]
			(println "proc = (comp str inc #(* 2 %))")
			(println "Aplicar em 5 -> (proc 5) = str(inc(* 2 5))")
			(println "Resultado:" (proc 5)))))

(defn demo-advanced-higher-order
	"Funções de ordem superior avançadas."
	[]
	(println "=== FUNÇÕES AVANÇADAS ===")
	(let [nums [1 2 3 4 5 6 7 8 9 10]]
		(println "Números:" nums)
		(println)
		(println "keep - filtra e transforma simultaneamente (remove nils):")
		(println "Comando: (keep #(when (even? %) (* % 2)) nums)")
		(println "Resultado:" (keep #(when (even? %) (* % 2)) nums))
		(println)
		(println "some - encontra primeiro elemento que satisfaz condição:")
		(println "Comando: (some #(when (> % 5) %) nums)")
		(println "Resultado:" (some #(when (> % 5) %) nums))
		(println)
		(println "every? - verifica se todos elementos satisfazem condição:")
		(println "Comando: (every? pos? nums)")
		(println "Resultado:" (every? pos? nums))
		(println "Comando: (every? even? nums)")
		(println "Resultado:" (every? even? nums))
		(println)
		(println "not-any? - verifica se nenhum elemento satisfaz condição:")
		(println "Comando: (not-any? neg? nums)")
		(println "Resultado:" (not-any? neg? nums))))

(defn demo-transducers
	"Introdução básica a transducers."
	[]
	(println "=== TRANSDUCERS BÁSICOS ===")
	(let [dados [1 2 3 4 5 6 7 8 9 10]]
		(println "Dados:" dados)
		(println)
		(println "Operação tradicional (aninhada):")
		(println "(->> dados (filter even?) (map #(* % 2)) (take 3))")
		(println "Resultado:" (->> dados (filter even?) (map #(* % 2)) (take 3)))
		(println)
		(println "Com transducer (composição eficiente):")
		(let [xf (comp (filter even?) (map #(* % 2)) (take 3))]
			(println "xf = (comp (filter even?) (map #(* % 2)) (take 3))")
			(println "Comando: (transduce xf conj [] dados)")
			(println "Resultado:" (transduce xf conj [] dados)))
		(println)
		(println "Into com transducer:")
		(println "Comando: (into [] xf dados)")
		(println "Resultado:" (into [] (comp (filter even?) (map #(* % 2)) (take 3)) dados))))

(defn demo-memoization
	"Memoização para cache de resultados."
	[]
	(println "=== MEMOIZAÇÃO ===")
	(letfn [(fib-lento [n]
						(if (<= n 1)
							n
							(+ (fib-lento (- n 1)) (fib-lento (- n 2)))))]
		(println "Fibonacci sem memoização (lento para n > 30):")
		(println "fib-lento 10 =" (fib-lento 10))
		(println)
		(println "Com memoize (cache automático de resultados):")
		(let [fib-memo (memoize fib-lento)]
			(println "fib-memo = (memoize fib-lento)")
			(println "fib-memo 10 =" (fib-memo 10))
			(println "Segunda chamada usa cache!"))))

(defn -main
	"Executa todos os exemplos deste arquivo."
	[& _]
	(demo-map)
	(println)
	(demo-filter)
	(println)
	(demo-reduce)
	(println)
	(demo-fn-forms)
	(println)
	(demo-juxt-comp)
	(println)
	(demo-advanced-higher-order)
	(println)
	(demo-transducers)
	(println)
	(demo-memoization))
