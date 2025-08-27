(ns binary-search-tree)

(def value :value)

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

(def left :left)

(def right :right)

(defn to-list [tree]
  (if (nil? tree)
    []
    (vec (concat (to-list (left tree)) [(value tree)] (to-list (right tree))))))

(defn from-list [[fst & rst]]
  (reduce #(insert %2 %1) (singleton fst) rst))
