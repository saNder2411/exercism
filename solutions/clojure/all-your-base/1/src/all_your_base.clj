(ns all-your-base
  (:require [clojure.math :as math]))

(defn base-n->base-10 [base-n nums]
  (let [exponents (range (dec (count nums)) -1 -1)]
    (int (apply + (map #(* %1 (math/pow base-n %2)) nums exponents)))))

(defn base-10->list-div [num]
  (map read-string (clojure.string/split (str num) #"")))

(defn base-10->base-n [base nums]
  (let [b10 (base-n->base-10 10 nums)]
    (loop [div b10
           res '()]
      (if (= div 0)
        (if (empty? res) '(0) res)
        (recur (quot div base) (conj res (mod div base)))))))

(defn convert [base-in nums base-out]
  (cond
    (or (< base-in 2) (< base-out 2)) nil
    (empty? nums) nums
    (some #(< % 0) nums) nil
    (some #(>= % base-in) nums) nil
    (= base-out 10) (base-10->list-div (base-n->base-10 base-in nums))
    :else (let [nums-10 (base-10->list-div (base-n->base-10 base-in nums))]
            (base-10->base-n base-out nums-10))))
