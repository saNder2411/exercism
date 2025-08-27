(ns allergies)

(def allergens [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats])

(defn allergies [score]
  (keep-indexed #(when (bit-test score %1) %2) allergens))

(defn allergic-to? [score allergen]
  (boolean (some #{allergen} (allergies score))))
