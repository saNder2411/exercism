(ns anagram
  (:require [clojure.string :as s]))

(defn- anagrams? [word candidate]
  (let [w-l (s/lower-case word)
        c-l (s/lower-case candidate)]
    (and (not= w-l c-l) (= (sort w-l) (sort c-l)))))

(defn anagrams-for [word prospect-list]
  (filter (partial anagrams? word) prospect-list))
