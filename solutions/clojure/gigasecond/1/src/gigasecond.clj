(ns gigasecond
  (:import [java.time LocalDateTime]))

(defn- date->obj-date [y m d]
  (LocalDateTime/of y m d 0 0 0))

(def obj-date->vec-date (juxt #(.getYear %) #(.getMonthValue %) #(.getDayOfMonth %)))

(defn from [y m d]
  (-> (date->obj-date y m d)
      (.plusSeconds (Math/pow 10 9))
      (obj-date->vec-date)))
