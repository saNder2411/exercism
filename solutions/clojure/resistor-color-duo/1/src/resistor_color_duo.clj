(ns resistor-color-duo)

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(defn color-code [color]
  (first (keep-indexed #(when (= color %2) %1) colors)))

(defn resistor-value [colors]
  (let [[tens ones] (->> colors
                         (take 2)
                         (map color-code))]
    (if (or (nil? tens) (nil? ones))
      0
      (+ (* tens 10) ones))))

