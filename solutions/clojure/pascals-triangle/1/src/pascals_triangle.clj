(ns pascals-triangle)

(defn row [prev-row]
  (into [1] (map #(apply + %) (partition 2 1 nil prev-row))))

(def triangle (iterate row [1]))
