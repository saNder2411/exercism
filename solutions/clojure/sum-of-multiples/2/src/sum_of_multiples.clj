(ns sum-of-multiples)

(defn- multiples-of-n [n limit]
  (loop [i 1
         result []]
    (if (>= (* i n) limit)
      result
      (recur (inc i) (conj result (* i n))))))

(defn sum-of-multiples [factors limit]
  (->> factors
       (reduce #(into %1 (multiples-of-n %2 limit)) #{0})
       (apply +)))
