(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (update birds (dec (count birds)) inc))

(defn day-without-birds? [birds]
  (boolean (some #(= % 0) birds)))

(defn n-days-count [birds n]
  (apply + (take n birds)))

(defn busy-days [birds]
  (reduce #(if (> %2 4) (inc %1) %1) 0 birds))

(defn odd-week? [birds]
  (every? #(if (= % 0) true (odd? %)) birds))
