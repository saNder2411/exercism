(ns bank-account)

(defn open-account [] (atom 0))

(defn close-account [account]
  (reset! account nil)
  account)

(defn get-balance [account] @account)

(defn update-balance [account sum]
  (swap! account + sum)
  account)
