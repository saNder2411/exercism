(ns binary-search-tree)

(defrecord Node [value left right])

(defn singleton [v] (map->Node {:value v :left nil :right nil}))

(def value :value)
(def left :left)
(def right :right)

(defn insert [v node]
  (if (nil? node)
    (singleton v)
    (let [cur-v (value node)
          dir (if (<= v cur-v) :left :right)
          next-node (dir node)]
      (assoc node dir (insert v next-node)))))

(defn to-list [{:keys [value left right] :as node}]
  (when node
    (lazy-cat (to-list left) [value] (to-list right))))

(defn from-list [[f & rs]]
  (reduce #(insert %2 %1) (singleton f) rs))
