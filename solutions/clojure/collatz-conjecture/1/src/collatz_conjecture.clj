(ns collatz-conjecture)

(defn- collatz-step [n]
  (if (odd? n)
    (inc (* 3 n))
    (/ n 2)))

(defn collatz [num]
  (loop [i 0
         next-n num]
    (if (= next-n 1)
      i
      (recur (inc i) (collatz-step next-n)))))
