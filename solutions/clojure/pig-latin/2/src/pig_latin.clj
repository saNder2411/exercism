(ns pig-latin
  (:require [clojure.string :as s]))

(def vowels? (set "aeiou"))

(def consonant? (complement vowels?))

(def ny-cons? (every-pred consonant? (partial not= \y)))

(defn- vowely? [s]
  (some (partial s/starts-with? s) ["xr" "yt"]))

(defn- y-first? [s]
  (= \y (first s)))

(defn- qu-after-cc? [cc rst]
  (and (= \q (last cc)) (= \u (first rst))))

(defn- split-cons [s]
  (let [[cc rst] (split-with ny-cons? s)]
    (cond (vowely? s) [s]
          (y-first? s) [(rest s) "y"]
          (qu-after-cc? cc rst) [(rest rst) cc "u"]
          :else [rst cc])))

(defn- pigify [s]
  (->> "ay"
       (conj (split-cons s))
       flatten
       (apply str)))

(defn translate [phrase]
  (->> (s/split phrase #" ")
       (map pigify)
       (s/join " ")))
