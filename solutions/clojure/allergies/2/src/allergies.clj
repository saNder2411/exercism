(ns allergies)

(def allergens {1   :eggs
                2   :peanuts
                4   :shellfish
                8   :strawberries
                16  :tomatoes
                32  :chocolate
                64  :pollen
                128 :cats})

(defn allergies [score]
  (loop [[fst & rst] (reverse (take-while #(<= % score) (iterate #(* % 2) 1)))
         sum score
         result '()]
    (cond (or (= sum 0) (nil? fst)) (remove nil? result)
          (< (- sum fst) 0) (recur rst sum result)
          :else (recur rst (- sum fst) (conj result (get allergens fst))))))

(defn allergic-to? [score allergen]
  (boolean (some #{allergen} (allergies score))))
