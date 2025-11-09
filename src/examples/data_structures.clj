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

(defn demo-advanced-maps
  "Operações avançadas com mapas."
  []
  (println "=== OPERAÇÕES AVANÇADAS COM MAPAS ===")
  (let [pessoa {:nome "Ana" :idade 25 :endereco {:rua "A" :cidade "SP"}}
        pessoas [{:nome "João" :idade 30} {:nome "Maria" :idade 25}]]
    (println "Mapa aninhado:" pessoa)
    (println)
    (println "Acessar valor aninhado (get-in pessoa [:endereco :cidade]):")
    (println "Resultado:" (get-in pessoa [:endereco :cidade]))
    (println)
    (println "Atualizar valor aninhado (assoc-in pessoa [:endereco :cep] \"01000-000\"):")
    (println "Resultado:" (assoc-in pessoa [:endereco :cep] "01000-000"))
    (println)
    (println "Atualizar valor aninhado (update-in pessoa [:endereco :rua] str \" Modificada\"):")
    (println "Resultado:" (update-in pessoa [:endereco :rua] str " Modificada"))
    (println)
    (println "Merge de mapas (merge {:a 1} {:b 2} {:a 3}):")
    (println "Resultado:" (merge {:a 1} {:b 2} {:a 3}))
    (println)
    (println "Select-keys (select-keys pessoa [:nome :idade]):")
    (println "Resultado:" (select-keys pessoa [:nome :idade]))
    (println)
    (println "Group-by em coleção (group-by :idade pessoas):")
    (println "Resultado:" (group-by :idade pessoas))))

(defn demo-sequences-utils
  "Utilitários para trabalhar com sequências."
  []
  (println "=== UTILITÁRIOS DE SEQUÊNCIAS ===")
  (let [nums [1 2 3 4 5 6]
        mixed [1 "a" 2 "b" 3 "c"]]
    (println "Números:" nums)
    (println "Mixed:" mixed)
    (println)
    (println "Particionar (partition 2 nums):")
    (println "Resultado:" (partition 2 nums))
    (println)
    (println "Particionar com step (partition 2 1 nums):")
    (println "Resultado:" (partition 2 1 nums))
    (println)
    (println "Split-at (split-at 3 nums):")
    (println "Resultado:" (split-at 3 nums))
    (println)
    (println "Interleave (interleave [1 2 3] [:a :b :c]):")
    (println "Resultado:" (interleave [1 2 3] [:a :b :c]))
    (println)
    (println "Zipmap (zipmap [:a :b :c] [1 2 3]):")
    (println "Resultado:" (zipmap [:a :b :c] [1 2 3]))
    (println)
    (println "Frequencies (frequencies \"abracadabra\"):")
    (println "Resultado:" (frequencies "abracadabra"))
    (println "Frequencies de vetor (frequencies [1 1 2 2 2 3]):")
    (println "Resultado:" (frequencies [1 1 2 2 2 3]))))

(defn demo-nested-structures
  "Trabalhar com estruturas aninhadas complexas."
  []
  (println "=== ESTRUTURAS ANINHADAS ===")
  (let [empresa {:nome "TechCorp"
                 :funcionarios [{:nome "João" :cargo "Dev" :salario 5000}
                               {:nome "Maria" :cargo "Designer" :salario 4500}
                               {:nome "Pedro" :cargo "Dev" :salario 5500}]}]
    (println "Empresa:" empresa)
    (println)
    (println "Buscar todos os desenvolvedores:")
    (println "Comando: (->> empresa :funcionarios (filter #(= (:cargo %) \"Dev\")))")
    (println "Resultado:" (->> empresa :funcionarios (filter #(= (:cargo %) "Dev"))))
    (println)
    (println "Aumentar salário de todos os funcionários em 10%:")
    (println "Comando: (update empresa :funcionarios #(map (fn [f] (update f :salario * 1.1)) %))")
    (let [empresa-updated (update empresa :funcionarios
                                  #(map (fn [f] (update f :salario * 1.1)) %))]
      (println "Resultado:" (:funcionarios empresa-updated)))
    (println)
    (println "Somar todos os salários:")
    (println "Comando: (->> empresa :funcionarios (map :salario) (reduce +))")
    (println "Resultado:" (->> empresa :funcionarios (map :salario) (reduce +)))))

(defn -main
  "Executa todos os exemplos deste arquivo."
  [& _]
  (demo-vectors)
  (println)
  (demo-maps)
  (println)
  (demo-sets)
  (println)
  (demo-advanced-maps)
  (println)
  (demo-sequences-utils)
  (println)
  (demo-nested-structures))
