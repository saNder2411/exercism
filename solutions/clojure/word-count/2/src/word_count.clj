(ns word-count
  (:require [clojure.string :as string]))

(defn- remove-apo-start-end [s]
  (-> s
      (string/replace #"^'" "")
      (string/replace #"'$" "")))

(defn word-count [s]
  (let [s-coll (-> s
                   string/lower-case
                   (string/split #"[^a-zA-Z0-9'’]+"))]
    (->> s-coll
         (map remove-apo-start-end)
         (remove empty?)
         frequencies)))

