(ns proverb
  (:require [clojure.string :as s]))

(defn- row [a b] (format "For want of a %s the %s was lost." a b))

(defn- last-row [word] (format "And all for the want of a %s." word))

(defn recite [words]
  (if (empty? words)
    ""
    (let [rows (mapv #(apply row %) (partition 2 1 words))]
      (s/join "\n" (conj rows (last-row (first words)))))))