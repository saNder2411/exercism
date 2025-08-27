(ns proverb
  (:require [clojure.string :as s]))

(defn- row [[a b]] (format "For want of a %s the %s was lost." a b))

(defn- last-row [a] (format "And all for the want of a %s." a))

(defn recite [[fst & rst :as words]]
  (cond (nil? fst) ""
        (nil? rst) (last-row fst)
        :else (->> words
                   (partition 2 1)
                   (mapv row)
                   (#(conj % (last-row fst)))
                   (s/join "\n"))))