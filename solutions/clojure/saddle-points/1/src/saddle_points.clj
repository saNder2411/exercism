(ns saddle-points)

(defn- turn-over-matrix [matrix]
  (vec (map-indexed (fn [i _]
                      (mapv #(get % i) matrix))
                    (first matrix))))

(defn saddle-points [matrix]
  (let [col-matrix (turn-over-matrix matrix)]
    (:res (reduce (fn [{:keys [row-i res]} row]
                    (let [y-x (keep-indexed
                                (fn [i v]
                                  (let [col (get col-matrix i)]
                                    (when (and (= v (apply max row)) (= v (apply min col)))
                                      [(inc row-i) (inc i)])))
                                row)]
                      {:row-i (inc row-i)
                       :res   (into res y-x)}))
                  {:row-i 0 :res #{}}
                  matrix))))
