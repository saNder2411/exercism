(ns sublist)

(defn- contains-list? [coll part]
  (if (<= (count coll) (count part))
    false
    (->> coll
         (partition (count part) 1)
         (some (partial = part)))))

(defn classify [a b]
  (cond (= a b) :equal
        (contains-list? a b) :superlist
        (contains-list? b a) :sublist
        :else :unequal))
