(ns strain)

(defn retain [pred coll]
  (loop [result []
         [fst & rest] coll]
    (cond (nil? fst) result
          (pred fst) (recur (conj result fst) rest)
          :else (recur result rest))))

(defn discard [pred coll]
  (retain (complement pred) coll))