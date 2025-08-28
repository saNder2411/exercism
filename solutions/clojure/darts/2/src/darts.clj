(ns darts)

(defn- hypo [x y]
  (Math/sqrt (+ (* x x) (* y y))))

(defn score [x y]
  (condp >= (hypo x y)
    1 10
    5 5
    10 1
    0))