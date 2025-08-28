(ns word-count
  (:require [clojure.string :as string]))

(defn- remove-apo-start-end [s]
  (apply str (cond-> s
                     (= \' (first s)) rest
                     (= \' (last s)) butlast)))

(defn word-count [s]
  (let [s-coll (-> s
                   remove-apo-start-end
                   string/lower-case
                   (string/split #"[^a-zA-Z0-9'’]+"))]
    (->> s-coll
         (filter (complement empty?))
         (map remove-apo-start-end)
         frequencies)))

