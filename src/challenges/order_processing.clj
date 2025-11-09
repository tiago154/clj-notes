(ns challenges.order-processing
  "Challenge: Sistema de Processamento de Pedidos
   
   Você é responsável por criar um sistema que processa uma lista de pedidos
   de um e-commerce. Cada pedido possui ID, cliente, valor e status.
   
   OBJETIVOS:
   1. Calcular o total de vendas por cliente (apenas pedidos aprovados)
   2. Contar quantos pedidos existem por status
   3. Ordenar todos os pedidos por valor (do maior para o menor)
   
   CONCEITOS CLOJURE UTILIZADOS:
   - Threading macros (->>)
   - Funções de alta ordem (map, filter, reduce)
   - Manipulação de coleções (group-by, frequencies, sort-by)
   - Destructuring
   - Keyword/namespace conversions"
  (:require [clojure.pprint :as pp]))

;; Dados de exemplo: pedidos de um e-commerce
(def sample-orders
  [{:id 101 :customer "Alice" :amount 120.50 :status "approved"}
   {:id 102 :customer "Bob"   :amount 90.0   :status "pending"}
   {:id 103 :customer "Alice" :amount 40.0   :status "approved"}
   {:id 104 :customer "Bob"   :amount 200.0  :status "approved"}
   {:id 105 :customer "Carol" :amount 50.0   :status "canceled"}
   {:id 106 :customer "Alice" :amount 75.25  :status "approved"}
   {:id 107 :customer "David" :amount 300.0  :status "approved"}
   {:id 108 :customer "Carol" :amount 25.0   :status "pending"}])

(defn process-orders 
  "Processa uma lista de pedidos retornando análises importantes:
   - total-by-customer: soma dos valores por cliente (só aprovados)
   - status-count: contagem de pedidos por status
   - sorted-orders: pedidos ordenados por valor (maior -> menor)"
  [orders]
  (let [;; Conta quantos pedidos existem por status
        status-count
        (->> orders
             (map (comp keyword :status))
             frequencies)

        ;; Calcula o total de vendas por cliente (apenas aprovados)
        total-by-customer
        (->> orders
             (filter #(= "approved" (:status %)))
             (group-by :customer)
             (into {}
                   (map (fn [[customer order-list]]
                          [(keyword customer)
                           (reduce + (map :amount order-list))]))))

        ;; Ordena pedidos por valor (maior para menor)
        sorted-orders
        (sort-by :amount > orders)]

    {:total-by-customer total-by-customer
     :sorted-orders sorted-orders
     :status-count status-count}))

(defn analyze-top-customers 
  "Análise adicional: encontra os top N clientes por valor total"
  [orders n]
  (->> orders
       (filter #(= "approved" (:status %)))
       (group-by :customer)
       (map (fn [[customer order-list]]
              [customer (reduce + (map :amount order-list))]))
       (sort-by second >)
       (take n)))

(defn demo-order-processing
  "Demonstra o processamento dos pedidos de exemplo"
  []
  (println "=== DESAFIO: PROCESSAMENTO DE PEDIDOS ===\n")
  
  (println "📊 DADOS ORIGINAIS:")
  (doseq [order sample-orders]
    (println (format "  Pedido #%d | Cliente: %-6s | Valor: R$ %6.2f | Status: %s"
                     (:id order)
                     (:customer order)
                     (:amount order)
                     (:status order))))
  
  (println "\n🔍 ANÁLISE PROCESSADA:")
  (let [result (process-orders sample-orders)]
    
    (println "\n📋 RESULTADO COMPLETO DA FUNÇÃO:") 
    (pp/pprint result)
    
    (println "\n1. Total por cliente (apenas aprovados):")
    (doseq [[customer total] (:total-by-customer result)]
      (println (format "   %s: R$ %.2f" (name customer) total)))
    
    (println "\n2. Contagem por status:")
    (doseq [[status count] (:status-count result)]
      (println (format "   %s: %d pedidos" (name status) count)))
    
    (println "\n3. Top 3 clientes por valor total:")
    (doseq [[customer total] (take 3 (analyze-top-customers sample-orders 5))]
      (println (format "   %s: R$ %.2f" customer total)))
    
    (println "\n4. Pedidos ordenados por valor (top 3):")
    (doseq [order (take 3 (:sorted-orders result))]
      (println (format "   #%d - %s: R$ %.2f (%s)"
                       (:id order)
                       (:customer order)
                       (:amount order)
                       (:status order))))))

(defn -main
  "Executa o desafio de processamento de pedidos"
  [& _args]
  (demo-order-processing))

;; Para testar no REPL:
;; (require 'challenges.order-processing :reload)
;; (challenges.order-processing/demo-order-processing)