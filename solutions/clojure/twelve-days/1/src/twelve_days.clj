(ns twelve-days
  (:require [clojure.string :as s]))

(def days ["first" "second" "third" "fourth" "fifth" "sixth" "seventh" "eighth" "ninth" "tenth" "eleventh" "twelfth"])

(def quantity-of ["a" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten" "eleven" "twelve"])

(def gifts ["Partridge" "Turtle Doves" "French Hens" "Calling Birds" "Gold Rings" "Geese-a-Laying" "Swans-a-Swimming" "Maids-a-Milking" "Ladies Dancing" "Lords-a-Leaping" "Pipers Piping" "Drummers Drumming"])


(defn- n->gifts [n]
  (let [[f & rst] (map #(str %1 " " %2) (take (inc n) quantity-of) (take (inc n) gifts))]
    (if (< n 1)
      f
      (s/join ", " (reverse (cons (str "and " f) rst))))))

(defn- verse [n]
  (format "On the %s day of Christmas my true love gave to me: %s in a Pear Tree." (get days n) (n->gifts n)))

(defn recite [start-verse end-verse]
  (->> (range (dec start-verse) end-verse)
       (map verse)
       (s/join "\n")))