(ns secret-handshake)

(def msgs ["wink" "double blink" "close your eyes" "jump" "reverse"])

(defn- revers-cmds [cmds]
  (if (= (last cmds) "reverse")
    (reverse (butlast cmds))
    cmds))

(defn commands [n]
  (->> (range 5)
       (filter #(bit-test n %))
       (map #(get msgs %))
       revers-cmds))
