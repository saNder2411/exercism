(ns bob
  (:require [clojure.string :as s]))

(defn contains-uppercase-word? [s]
  (boolean (some #(not (#{ "OK" "DMV" } %)) (re-seq #"\b[A-Z]+\b" s))))

(defn response-for [s]
  (let [s-trim! (s/trim s)]
    (cond (empty? s-trim!) "Fine. Be that way!"
          (and (s/ends-with? s-trim! "?") (contains-uppercase-word? s-trim!)) "Calm down, I know what I'm doing!"
          (s/ends-with? s-trim! "?") "Sure."
          (contains-uppercase-word? s-trim!) "Whoa, chill out!"
          :else "Whatever.")))
