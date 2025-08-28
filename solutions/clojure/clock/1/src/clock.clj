(ns clock)

(defn- n->str-with-0 [n]
  (cond->> n
           (< n 10) (str "0")
           :else (str)))

(defn- normalize-time [m]
  (if (< m 0)
    (let [day-m (* 24 60)]
      (+ day-m (rem m day-m)))
    m))

(defn- minutes->h-m [m]
  ((juxt #(rem (quot % 60) 24) #(rem % 60)) (normalize-time m)))

(defn clock->string [[h m]]
  (str (n->str-with-0 h) ":" (n->str-with-0 m)))

(defn clock [hours minutes]
  (minutes->h-m (+ (* hours 60) minutes)))

(defn add-time [[h m] time]
  (clock h (+ m time)))
