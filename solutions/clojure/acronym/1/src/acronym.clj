(ns acronym)

(defn acronym [phrase]
  (let [words (-> phrase
                  (clojure.string/replace #"-" " ")
                  (clojure.string/replace #"_" " ")
                  (clojure.string/split #" "))]
    (apply str (map #(clojure.string/upper-case (if (empty? %) "" (first %))) words))))
