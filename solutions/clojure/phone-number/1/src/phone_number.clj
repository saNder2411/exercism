(ns phone-number)

(def no-valid-template "0000000000")

(defn- check-11-digit-number [t]
  (if (and (= (count t) 11) (= \1 (first t)))
    (apply str (rest t))
    t))

(defn check-10-digit-number [t]
  (let [[c-fst _ _ e-fst] t]
    (cond (not= (count t) 10) no-valid-template
          (or (= \0 c-fst) (= \1 c-fst)) no-valid-template
          (or (= \0 e-fst) (= \1 e-fst)) no-valid-template
          :else t)))

(defn number [s]
  (->> s
       (re-seq #"\d")
       (apply str)
       check-11-digit-number
       check-10-digit-number))
