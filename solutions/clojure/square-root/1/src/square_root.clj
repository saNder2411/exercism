(ns square-root)

(defn square-root [n]
  (loop [l 0
         r (inc n)]
    (cond
      (= l (dec r)) l
      :else (let [m (quot (+ l r) 2)
                  [l1 r1] (if (<= (* m m) n) [m r] [l m])]
              (recur l1 r1)))))