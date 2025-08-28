(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform [source]
  (reduce (fn [acc [k v]]
            (apply assoc acc (mapcat #(vec [(lower-case %) k]) v))) {} source))
