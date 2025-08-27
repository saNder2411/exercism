(ns nucleotide-count)

(defn- valid-nucleotide? [nucleotide]
  (not (nil? (#{\A \C \G \T } nucleotide))))

(defn- valid-strand? [strand]
  (or (empty? strand) (every? valid-nucleotide? strand)))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (valid-nucleotide? nucleotide)
    (let [res (get (frequencies strand) nucleotide)]
      (if (nil? res) 0 res))
    (throw (IllegalArgumentException. "invalid nucleotide"))))

(defn nucleotide-counts [strand]
  (if (valid-strand? strand)
    (into {\A 0, \T 0, \C 0, \G 0} (frequencies strand))
    (throw (IllegalArgumentException. "invalid strand"))))
