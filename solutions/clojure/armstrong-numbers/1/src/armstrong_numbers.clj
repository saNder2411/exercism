(ns armstrong-numbers
  (:require [clojure.math :as math]))

(defn armstrong? [num]
  (let [nums (map #(-> % str read-string) (str num))
        exponent (count nums)
        res (apply + (map #(math/pow % exponent) nums))]
    (= (float num) (float res))))
