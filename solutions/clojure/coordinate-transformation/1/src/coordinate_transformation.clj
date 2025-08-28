(ns coordinate-transformation)

(defn translate2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y]
    [(+ x dx) (+ y dy)]))

(defn scale2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y]
    [(* x sx) (* y sy)])
  )

(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [x y]
    (->> (f x y)
        (apply g))))

(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call,
   the memoized result is returned."
  [f]
  (let [cache (atom {:args [] :res nil})]
    (fn [x y]
      (let [{:keys [args res]} @cache
            [xc yc] args]
        (if (and (= x xc) (= y yc))
          res
          (:res (swap! cache assoc :args [x y] :res (f x y))))))))
