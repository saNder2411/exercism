(ns rotational-cipher)

(defn- shift-idx [start-idx ch-idx shift]
  (let [shifted-idx (+ ch-idx shift)]
    (+ start-idx (mod (- shifted-idx start-idx) 26))))

(defn- rotate-cipher [key ch]
  (let [ch-idx (int ch)]
    (cond (< 96 ch-idx 123) (char (shift-idx 97 ch-idx key))
          (< 64 ch-idx 91) (char (shift-idx 65 ch-idx key))
          :else ch)))

(defn rotate [msg key]
  (->> msg
       (map (partial rotate-cipher key))
       (apply str)))