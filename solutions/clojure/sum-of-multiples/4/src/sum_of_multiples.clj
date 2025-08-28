(ns sum-of-multiples)

(defn sum-of-multiples [factors limit]
  (->> factors
       (reduce #(into %1 (range %2 limit %2)) #{0})
       (apply +)))

