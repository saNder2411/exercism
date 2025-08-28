(ns anagram
  (:require [clojure.string :as s]))

(defn- anagrams? [word candidate]
  (let [w-l (s/lower-case word)
        c-l (s/lower-case candidate)]
    (if (or (not= (count word) (count candidate)) (= w-l c-l))
      nil
      (let [w-f (frequencies w-l)
            c-f (frequencies c-l)
            compare-result (reduce (fn [sum [k v]]
                                     (if (= (get w-f k) v)
                                       sum
                                       (inc sum)))
                                   0 c-f)]
        (zero? compare-result)))))

(defn anagrams-for [word prospect-list]
  (filter (partial anagrams? word) prospect-list))
