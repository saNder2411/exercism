(ns resistor-color-duo)

(def colors->num
  {"black" 0
   "brown" 1
   "red" 2
   "orange" 3
   "yellow" 4
   "green" 5
   "blue" 6
   "violet" 7
   "grey" 8
   "white" 9})

(defn resistor-value [colors]
  (->> colors
       (take 2)
       (map colors->num)
       (reduce (fn [acc n] (+ (* acc 10) n)) 0)))

