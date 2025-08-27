(ns interest-is-interesting)

(defn interest-rate [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (and (>= balance 1000) (< balance 5000)) 1.621
    :else 2.475))

(defn annual-balance-update [balance]
  (let [deb (bigdec (* (bigdec (/ balance 100)) (bigdec (interest-rate balance))))
        deb! (if (< balance 0) (* deb -1) deb)]
    (bigdec (+ balance deb!))))

(defn amount-to-donate [balance tax-free-percentage]
  (if (< balance 0)
    0
    (int (* (* (bigdec (/ balance 100)) tax-free-percentage) 2))))