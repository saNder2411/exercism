(ns sublist)

(defn- sub-seq? [coll part]
  (if (<= (count coll) (count part))
    false
    (->> coll
         (partition (count part) 1)
         (some (partial = part)))))

(defn classify [a b]
  (cond (= a b) :equal
        (sub-seq? a b) :superlist
        (sub-seq? b a) :sublist
        :else :unequal))

