(ns darts)

(defn- n->pos [n]
  (cond-> n
          (neg? n) (* -1)))

(defn calc-radius [x y]
  (let [a (n->pos x)
        b (n->pos y)]
    (Math/sqrt (+ (* a a) (* b b)))))

(defn- circle-area [r] (* 3.14 (* r r)))

(def darts-circles {:inner  (circle-area 1)
                    :middle (circle-area 5)
                    :outer  (circle-area 10)})

(defn score [x y]
  (let [r (calc-radius x y)
        hit-area (circle-area r)]
    (cond
      (<= hit-area (:inner darts-circles)) 10
      (<= hit-area (:middle darts-circles)) 5
      (<= hit-area (:outer darts-circles)) 1
      :else 0)))