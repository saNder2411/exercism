(ns raindrops)

(defn convert [num]
  (let [res (cond-> ""
                    (zero? (mod num 3)) (str "Pling")
                    (zero? (mod num 5)) (str "Plang")
                    (zero? (mod num 7)) (str "Plong"))]
    (if (empty? res) (str num) res)))
