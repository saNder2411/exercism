(ns isogram
  (:require [clojure.string :as s]))

(defn isogram? [string]
  (let [letters (re-seq #"[a-zA-Z]" (s/lower-case string))]
    (= (count (distinct letters)) (count letters))))