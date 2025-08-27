(ns binary-search)

(defn search-for [num coll]
  (loop [l-i  0
         h-i (dec (count coll))]
    (if (< h-i l-i)
      -1
      (let [m-i (quot (+ l-i h-i) 2)
            el (get coll m-i)]
        (cond (= el num) m-i
              (> el num) (recur l-i (dec m-i))
              (< el num) (recur (inc m-i) h-i))))))
