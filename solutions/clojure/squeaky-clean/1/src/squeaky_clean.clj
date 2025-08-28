(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn kebab->camel-case [s]
  (if (clojure.string/includes? s "-")
    (let [[f & remaining] (clojure.string/split s #"-")]
      (apply str f (map
                     #(apply str (clojure.string/upper-case (first %)) (rest %))
                     remaining)))
    s))

(defn clean [s]
  (if (empty? s)
    s
    (->> (clojure.string/replace s #" " "_")
         (map #(cond
                 (java.lang.Character/isISOControl %) "CTRL"
                 (or (= \_ %) (= \- %)) %
                 (not (java.lang.Character/isLetter %)) ""
                 (and (>= (int %) 945) (<= (int %) 969)) ""
                 :else %))
         (apply str)
         kebab->camel-case)))
