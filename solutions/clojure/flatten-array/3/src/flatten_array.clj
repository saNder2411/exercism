(ns flatten-array)

(defn flatten [coll]
  (loop [[fst & rst :as data] coll
         result []]
    (cond (empty? data) result
          (coll? fst) (recur (into fst rst) result)
          (nil? fst) (recur rst result)
          :else (recur rst (conj result fst)))))