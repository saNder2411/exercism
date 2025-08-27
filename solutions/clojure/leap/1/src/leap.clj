(ns leap)

(defn leap-year? [year]
  (or (and (zero? (mod year 4)) (> (mod year 100) 0))
      (zero? (mod year 400))))
