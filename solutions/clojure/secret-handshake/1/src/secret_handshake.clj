(ns secret-handshake)

(def cmds-kit ["wink" "double blink" "close your eyes" "jump" "reverse"])

(defn- dec->bin [n]
  (loop [div n
         res '()]
    (cond (and (= div 0) (empty? res)) '(0)
          (= div 0) res
          :else (recur (quot div 2) (conj res (mod div 2))))))

(defn- revers-cmds [cmds]
  (if (= (last cmds) "reverse")
    (reverse (butlast cmds))
    cmds))

(defn commands [n]
  (->> n
       dec->bin
       reverse
       (map #(if (zero? %2) nil %1) cmds-kit)
       (remove nil?)
       revers-cmds))
