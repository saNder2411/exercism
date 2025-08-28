(ns matrix
  (:require [clojure.string :as st]))

(defn- str->matrix-rows [s]
  (->> s
       (#(st/split % #"\n"))
       (mapv #(mapv read-string (st/split % #" ")))))

(defn get-row [s i]
  (get (str->matrix-rows s) (dec i)))

(defn get-column [s i]
  (reduce (fn [acc r]
            (conj acc (get r (dec i)))) [] (str->matrix-rows s)))
