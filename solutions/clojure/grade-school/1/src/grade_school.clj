(ns grade-school)

(defn grade [school grade]
  (get school grade []))

(defn add [school name grade]
  (update school grade (comp vec conj) name))

(defn sorted [school]
  (into (sorted-map) (update-vals school (comp vec sort))))
