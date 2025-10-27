(ns examples.data-structures)

(def sample-vector [1 2 3 4])
(def sample-map {:nome "Tiago" :idade 30 :pais "Brasil"})
(def sample-set #{:clojure :java})

(defn demo-vectors
  "Mostra operações comuns com vetores."
  []
  (let [vector sample-vector]
    (println "Vector original:" vector)
    (println "Adicionar elemento (conj vector 5):" (conj vector 5))
    (println "Atualizar posição (assoc vector 0 99):" (assoc vector 0 99))
    (println "Primeiro elemento (first vector):" (first vector))
    (println "Demais elementos (rest vector):" (rest vector))))

(defn demo-maps
  "Mostra operações comuns com mapas."
  []
  (let [m sample-map]
    (println "Mapa original:" m)
    (println "Adicionar chave (assoc m :cidade \"Recife\"):" (assoc m :cidade "Recife"))
    (println "Remover chave (dissoc m :pais):" (dissoc m :pais))
    (println "Buscar valor (:nome m):" (:nome m))
    (println "Atualizar valor (update m :idade inc):" (update m :idade inc))))

(defn demo-sets
  "Mostra operações comuns com conjuntos."
  []
  (let [s sample-set]
    (println "Set original:" s)
    (println "Adicionar elemento (conj s :python):" (conj s :python))
    (println "Remover elemento (disj s :java):" (disj s :java))
    (println "Checar existência (contains? s :clojure):" (contains? s :clojure))))

(defn -main
  "Executa todos os exemplos deste arquivo."
  [& _]
  (demo-vectors)
  (println)
  (demo-maps)
  (println)
  (demo-sets))
