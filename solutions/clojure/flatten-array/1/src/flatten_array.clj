(ns flatten-array
  (:require [clojure.core :as clj]))

(defn flatten [coll]
  (->> coll
       (clj/flatten)
       (filter (complement nil?))
       (vec)))
