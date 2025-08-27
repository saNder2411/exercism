(ns resistor-color)

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(defn color-code [color]
  (first (keep-indexed  #(when (= color %2) %1) colors)))