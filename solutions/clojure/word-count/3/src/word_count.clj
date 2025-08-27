(ns word-count
  (:require [clojure.string :as string]))

(defn word-count [s]
  (->> s
       string/lower-case
       (re-seq #"\b\w+'?\w*\b")
       frequencies))

