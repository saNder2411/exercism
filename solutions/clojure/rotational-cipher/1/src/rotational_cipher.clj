(ns rotational-cipher)

(defn- letter? [ch]
  (or (< 96 (int ch) 123)
      (< 64 (int ch) 91)))

(defn- letter-ch-start-idx [letter-ch-idx]
  (if (< letter-ch-idx 91) 65 97))

(defn- shift-letter-idx [letter-ch-idx shift]
  (let [start-idx (letter-ch-start-idx letter-ch-idx)
        shifted-idx (+ letter-ch-idx shift)]
    (+ start-idx (mod (- shifted-idx start-idx) 26))))

(defn rotate [msg shift]
  (->> msg
       (reduce (fn [acc ch]
                 (if (letter? ch)
                   (let [shifted-idx (shift-letter-idx (int ch) shift)]
                     (conj acc (char shifted-idx)))
                   (conj acc ch))
                 ) [])
       (apply str)))