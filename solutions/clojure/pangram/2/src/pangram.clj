(ns pangram)

(def default-count (zipmap (map char (range (int \a) (inc (int \z)))) (repeat 0)))

(defn pangram? [s]
  (let [fr (frequencies (clojure.string/lower-case s))
        res (into default-count fr)]
    (every? (fn [[_ v]] (< 0 v)) res)))
