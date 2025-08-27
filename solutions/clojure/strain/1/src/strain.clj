(ns strain)

(defn retain [pred coll]
  (let [last-i (dec (count coll))]
    (loop [i 0
           res []]
      (if (<= i last-i)
        (let [item (get coll i)
              res! (if (pred item) (conj res item) res)]
          (recur (inc i) res!))
        res))))

(defn discard [pred coll]
  (retain (comp not pred) coll))