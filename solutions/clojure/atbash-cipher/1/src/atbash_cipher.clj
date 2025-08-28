(ns atbash-cipher
  (:require [clojure.string :as s]))

(def nums (mapv #(str (char %)) (range 48 58)))

(def a-z (mapv #(str (char %)) (range 97 123)))

(def z-a (mapv #(str (char %)) (range 122 96 -1)))

(def code-map (into (zipmap nums nums) (zipmap a-z z-a)))

(defn encode [plaintext]
  (->> plaintext
       (s/lower-case)
       (re-seq #"[a-z0-9]")
       (map code-map)
       (partition-all 5)
       (map #(apply str %))
       (#(s/join " " %))))

(defn decode [ciphertext]
  (->> ciphertext
       (re-seq #"[a-z0-9]")
       (map code-map)
       (apply str)))
