(ns examples.functions)

(def numbers [1 2 3 4 5])
(def people [{:nome "Ana" :idade 28}
						 {:nome "Bruno" :idade 17}
						 {:nome "Carla" :idade 33}])

(defn demo-map
	"Aplica transformação em cada elemento de uma coleção."
	[]
	(println "Dobrar números (map #(* 2 %) numbers):" (map #(* 2 %) numbers))
	(println "Uppercase nomes (map :nome people):" (map :nome people)))

(defn demo-filter
	"Filtra elementos que satisfazem uma condição."
	[]
	(println "Maiores que 3 (filter #(> % 3) numbers):" (filter #(> % 3) numbers))
	(println "Pessoas adultas (filter #(>= (:idade %) 18) people):" (filter #(>= (:idade %) 18) people)))

(defn demo-reduce
	"Acumula valores a partir de uma coleção."
	[]
	(println "Somar números (reduce + numbers):" (reduce + numbers))
	(println "Concat nomes (reduce #(str %1 ", " %2) (map :nome people)):"
					 (reduce #(str %1 ", " %2) (map :nome people))))

(defn demo-fn-forms
	"Mostra diferentes formas de declarar funções."
	[]
	(letfn [(soma [a b] (+ a b))]
		(println "Função com letfn (soma 2 3):" (soma 2 3)))
	(println "Função anônima (#(+ %1 %2) 4 5):" (#(+ %1 %2) 4 5))
	(let [partial-soma (partial + 10)]
		(println "Função parcial (partial + 10) 5:" (partial-soma 5))))

(defn -main
	"Executa todos os exemplos deste arquivo."
	[& _]
	(demo-map)
	(println)
	(demo-filter)
	(println)
	(demo-reduce)
	(println)
	(demo-fn-forms))
