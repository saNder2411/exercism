(ns matrix
  (:require [clojure.string :as st]))

(defn- str->matrix [s]
  (->> s
       (st/split-lines)
       (mapv (comp read-string #(format "[%s]" %)))))

(defn get-row [s i]
  (get (str->matrix s) (dec i)))

(defn get-column [s i]
  (mapv #(get % (dec i)) (str->matrix s)))