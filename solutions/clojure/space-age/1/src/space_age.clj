(ns space-age)

(defn sec->years [seconds coeff]
  (/ seconds (* 60 60 24 365.25 coeff)))

(defn on-mercury [seconds]
  (sec->years seconds 0.2408467))

(defn on-venus [seconds]
  (sec->years seconds 0.61519726))

(defn on-earth [seconds]
  (sec->years seconds 1.0))

(defn on-mars [seconds]
  (sec->years seconds 1.8808158))

(defn on-jupiter [seconds]
  (sec->years seconds 11.862615))

(defn on-saturn [seconds]
  (sec->years seconds 29.447498))

(defn on-uranus [seconds]
  (sec->years seconds 84.016846))

(defn on-neptune [seconds]
  (sec->years seconds 164.79132))
