(ns prime-factors)

(defn of [num]
  (loop [div 2
         r num
         res []]
    (cond (<= r 1) res
          (zero? (mod r div)) (recur div (/ r div) (conj res div))
          :else (recur (inc div) r res))))
