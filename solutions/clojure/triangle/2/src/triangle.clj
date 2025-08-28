(ns triangle)

(defn- triangle? [a b c]
  (and (< 0 a)
       (< 0 b)
       (< 0 c)
       (>= (+ a b) c)
       (>= (+ c b) a)
       (>= (+ c a) b)))

(defn equilateral? [a b c]
  (and (triangle? a b c)
       (= a b c)))

(defn isosceles? [a b c]
  (and (triangle? a b c)
       (or (= a b) (= a c) (= b c))))

(defn scalene? [a b c]
  (and (triangle? a b c)
       (not (isosceles? a b c))))
