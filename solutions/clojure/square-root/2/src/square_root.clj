(ns square-root)

(defn square-root [n]
  (if (<= n 1)
    n
    (int (loop [a (/ n 2)
                b (float (/ (+ a (/ n a)) 2))]
           (cond
             (< b a) (recur b (float (/ (+ b (/ n b)) 2)))
             :else a)))))