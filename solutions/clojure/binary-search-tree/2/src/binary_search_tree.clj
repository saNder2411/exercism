(ns binary-search-tree)

(def value :value)

(def left :left)

(def right :right)

(defn singleton [v]
  {:value v :left nil :right nil})

(defn insert [v tree]
  (loop [cur-node tree
         path []]
    (let [cur-v (value cur-node)
          direction (if (> v cur-v) :right :left)
          path-to-next (conj path direction)
          next-node (get-in tree path-to-next)]
      (if (nil? next-node)
        (assoc-in tree path-to-next (singleton v))
        (recur next-node path-to-next)))))


(defn to-list [{:keys [value left right] :as tree}]
  (when tree
    (lazy-cat (to-list left) [value] (to-list right))))

(defn from-list [[f & rs]]
  (reduce #(insert %2 %1) (singleton f) rs))
