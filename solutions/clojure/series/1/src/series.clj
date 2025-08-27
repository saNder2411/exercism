(ns series)

(defn slices [s n]
  (cond (empty? s) (throw (IllegalArgumentException. "series cannot be empty"))
        (> n (count s)) (throw (IllegalArgumentException. "slice length cannot be greater than series length"))
        (zero? n) (throw (IllegalArgumentException. "slice length cannot be zero"))
        (neg? n) (throw (IllegalArgumentException. "slice length cannot be negative"))
        :else (->> s
                   (partition n 1)
                   (mapv #(apply str %)))))
