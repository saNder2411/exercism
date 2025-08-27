(ns largest-series-product)

(defn largest-product [span s]
  (cond (neg? span) (throw (IllegalArgumentException. "span must not be negative"))
        (< (count s) span) (throw (IllegalArgumentException. "span must not exceed string length"))
        (not= nil (re-find #"[a-zA-Z]" s)) (throw (IllegalArgumentException. "digits input must only contain digits"))
        :else (->> (clojure.string/split s #"")
                   (map parse-long)
                   (partition span 1)
                   (map #(apply * %))
                   (apply max))))
