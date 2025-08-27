(ns largest-series-product)

(defn- includes-letter [s]
  (boolean (re-find #"\p{L}" s)))

(defn largest-product [span s]
  (cond (neg? span) (throw (IllegalArgumentException. "span must not be negative"))
        (< (count s) span) (throw (IllegalArgumentException. "span must not exceed string length"))
        (includes-letter s) (throw (IllegalArgumentException. "digits input must only contain digits"))
        :else (->> s
                   (map #(^[char int] Character/digit % 10))
                   (partition span 1)
                   (map #(apply * %))
                   (apply max))))
