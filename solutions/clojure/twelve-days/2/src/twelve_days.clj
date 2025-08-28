(ns twelve-days
  (:require [clojure.string :as s]))

(def days ["first" "second" "third" "fourth" "fifth" "sixth" "seventh" "eighth" "ninth" "tenth" "eleventh" "twelfth"])

(def gifts ["a Partridge in a Pear Tree"
            "two Turtle Doves" "three French Hens"
            "four Calling Birds"
            "five Gold Rings"
            "six Geese-a-Laying"
            "seven Swans-a-Swimming"
            "eight Maids-a-Milking"
            "nine Ladies Dancing"
            "ten Lords-a-Leaping"
            "eleven Pipers Piping"
            "twelve Drummers Drumming"])


(defn- n->gifts [n]
  (let [[f & rst] (take (inc n) gifts)]
    (if (< n 1)
      f
      (s/join ", " (reverse (cons (str "and " f) rst))))))

(defn- verse [n]
  (format "On the %s day of Christmas my true love gave to me: %s." (get days n) (n->gifts n)))

(defn recite [start-verse end-verse]
  (->> (range (dec start-verse) end-verse)
       (map verse)
       (s/join "\n")))