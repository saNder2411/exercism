(ns bank-account)

(defn open-account []
  (atom {:balance 0
         :status  "open"}))

(defn close-account [account]
  (swap! account assoc :status "closed")
  account)

(defn get-balance [account]
  (if (= (:status @account) "open")
    (:balance @account)
    nil))

(defn update-balance [account sum]
  (swap! account update :balance + sum)
  account)
