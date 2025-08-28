(ns flatten-array
  (:require [clojure.core :as clj]))

(defn flatten [coll]
  (->> coll
       (clj/flatten)
       (remove nil?)))
