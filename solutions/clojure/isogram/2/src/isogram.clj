(ns isogram
  (:require [clojure.string :as s]))

(defn isogram? [string]
  (if (empty? string)
    true
    (->> string
         s/lower-case
         (re-seq #"[a-zA-Z]")
         (apply distinct?))))