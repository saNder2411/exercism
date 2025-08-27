(ns sum-of-multiples)

(defn- multiples-of-n [n limit]
  (loop [i 1
         result []]
    (if (>= (* i n) limit)
      result
      (recur (inc i) (conj result (* i n))))))

(defn sum-of-multiples [factors limit]
  (apply +
         (reduce (fn [acc n]
                   (into acc (multiples-of-n n limit))) #{0} factors)))
