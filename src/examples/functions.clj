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
