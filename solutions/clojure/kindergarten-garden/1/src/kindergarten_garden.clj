(ns kindergarten-garden
  (:require [clojure.string :as s]))

(def kids-l '("Alice" "Bob" "Charlie" "David" "Eve" "Fred"
               "Ginny" "Harriet" "Ileana" "Joseph" "Kincaid" "Larry"))

(def kids-m (zipmap (range) (map #(keyword (s/lower-case %)) kids-l)))

(def plants {\G :grass \C :clover \R :radishes \V :violets})

(defn garden [s-data]
  (->> (s/split s-data #"\n")
       (map (partial partition 2))
       (apply map vector)
       (map-indexed (fn [i coll]
                      [(kids-m i) (mapv plants (flatten coll))]))
       (into {})))
