(ns phone-number)

(def invalid-template "0000000000")

(defn- check-11-digit-number [t]
  (if (and (= (count t) 11) (= \1 (first t)))
    (apply str (rest t))
    t))

(defn check-10-digit-number [t]
  (if (re-matches #"[2-9]\d{2}[2-9]\d{6}" t)
    t
    invalid-template))

(defn number [s]
  (->> s
       (re-seq #"\d")
       (apply str)
       check-11-digit-number
       check-10-digit-number))
