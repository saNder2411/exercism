(ns eliuds-eggs)

(defn num-10->binary [num]
  (loop [div num
         res '()]
    (if (= div 0)
      (if (empty? res) '(0) res)
      (recur (quot div 2) (conj res (mod div 2))))))

(defn egg-count [number]
  (apply + (num-10->binary number)))
