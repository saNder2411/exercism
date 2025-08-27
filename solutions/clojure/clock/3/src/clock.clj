(ns clock)

(def min-in-day (* 24 60))

(defn- minutes->h-m [m]
  ((juxt #(quot % 60) #(mod % 60)) (mod m min-in-day)))

(defn clock->string [[h m]]
  (format "%02d:%02d" h m))

(defn clock [h m]
  (minutes->h-m (+ (* h 60) m)))

(defn add-time [[h m] time]
  (clock h (+ m time)))