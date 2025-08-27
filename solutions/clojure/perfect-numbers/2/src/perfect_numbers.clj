(ns perfect-numbers)

(defn factors [n]
  (reduce
    (fn [acc x]
      (if (zero? (mod n x))
        (conj acc x (/ n x))
        acc))
    #{}
    (range 1 (inc (Math/sqrt n)))))

(defn classify [num]
  (let [f-sum (apply + (disj (factors num) num))]
    (cond (< f-sum num) :deficient
          (> f-sum num) :abundant
          :else :perfect)))
