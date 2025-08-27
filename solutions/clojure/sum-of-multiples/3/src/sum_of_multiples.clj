(ns sum-of-multiples)

(defn- multiples-of-n [n limit]
  (map #(* % n) (range 1 (inc (quot (dec limit) n)))))

(defn sum-of-multiples [factors limit]
  (->> factors
       (reduce #(into %1 (multiples-of-n %2 limit)) #{0})
       (apply +)))

