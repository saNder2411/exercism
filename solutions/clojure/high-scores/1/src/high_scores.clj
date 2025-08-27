(ns high-scores)

(defn scores [scores] scores)

(defn latest [scores] (last scores))

(defn personal-best [scores] (-> scores sort last))

(defn personal-top-three [scores]
  (->> scores
       (sort >)
       (take 3)))
