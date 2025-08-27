(ns pig-latin
  (:require [clojure.string :as s]))

(def vowels? #{\a \e \i \o \u})

(defn not-vowels? [vowels-set c]
  (not (vowels-set c)))

(defn- add-ay [w] (str w "ay"))

(defn- validate-1 [[l l1]]
  (or (vowels? l) (= (str l l1) "xr") (= (str l l1) "yt")))

(defn- validate-2 [[l]]
  (not (vowels? l)))

(defn- validate-3 [[l l1 l2 l3]]
  (or (= (str l l1) "qu")
      (= (str l1 l2) "qu")
      (= (str l2 l3) "qu")))

(defn- validate-4 [[l l1 l2]]
  (or (and (not (vowels? l)) (= l1 \y))
      (and (not (vowels? l)) (not (vowels? l1)) (= l2 \y))))

(defn- consonants-from-start->end [vowels-set word]
  (reduce (fn [res f]
            (apply str res (f #(not-vowels? vowels-set %) word))) "" [drop-while take-while]))

(defn- translate-word [w]
  (cond (validate-1 w) (add-ay w)
        (validate-4 w) (->> w (consonants-from-start->end (conj vowels? \y)) add-ay)
        (validate-3 w) (->> w (consonants-from-start->end (disj vowels? \u)) add-ay)
        (validate-2 w) (->> w (consonants-from-start->end vowels?) add-ay)
        :else w))

(defn translate [phrase]
  (s/join " " (map translate-word (s/split phrase #" "))))
