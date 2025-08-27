(ns collatz-conjecture)

(defn- collatz-step [n]
  (if (odd? n)
    (inc (* 3 n))
    (/ n 2)))

(defn collatz [n]
  (->> n
       (iterate collatz-step)
       (take-while (partial not= 1))
       count))
