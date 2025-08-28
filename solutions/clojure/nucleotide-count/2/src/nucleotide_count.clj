(ns nucleotide-count)

(def nucleotides #{\A \C \G \T})

(def default-count
  (zipmap nucleotides (repeat 0)))

(defn nucleotide-counts [strand]
  (into default-count (frequencies strand)))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (or ((nucleotide-counts strand) nucleotide)
      (throw (Exception. "invalid strand"))))
