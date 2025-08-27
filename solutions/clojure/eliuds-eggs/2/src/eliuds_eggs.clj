(ns eliuds-eggs)

(defn egg-count [n]
  (->> n
       (iterate #(quot % 2))
       (take-while pos?)
       (map #(rem % 2))
       (apply +)))
