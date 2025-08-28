(ns binary-search)

(defn search-for [num coll]
  (loop [size (count coll)
         i (quot size 2)]
    (let [el (get coll i)
          shift (if (zero? (quot size 4)) 1 (quot size 4))]
      (cond (= el num) i
            (or (nil? el) (zero? size)) -1
            (> el num) (recur (quot size 2) (- i shift))
            (< el num) (recur (quot size 2) (+ i shift))))))
