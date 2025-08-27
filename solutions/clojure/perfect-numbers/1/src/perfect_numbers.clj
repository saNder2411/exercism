(ns perfect-numbers)

(defn- factors [n]
  (->> (range 1 (inc (quot n 2)))
       (filter #(zero? (mod n %)))))

(defn classify [num]
  (let [f-sum (apply + (factors num))]
    (cond (< f-sum num) :deficient
          (> f-sum num) :abundant
          :else :perfect)))
