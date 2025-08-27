(ns difference-of-squares)

(defn- n->square [n] (* n n))

(defn square-of-sum [n]
  (->> (inc n)
       (range 1)
       (apply +)
       n->square))

(defn sum-of-squares [n]
  (->> (inc n)
       (range 1)
       (map n->square)
       (apply +)))

(defn difference [n]
  (- (square-of-sum n) (sum-of-squares n)))
