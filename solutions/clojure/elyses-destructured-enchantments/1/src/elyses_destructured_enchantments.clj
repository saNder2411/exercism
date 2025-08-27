(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [[f]]
  f)

(defn second-card
  "Returns the second card from deck."
  [[_ s]]
  s)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[f s & remaining]]
  (into [s f] remaining))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [[f & remaining]]
  (into [f] [remaining]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [[f & remaining]]
  (vec (concat (if (nil? f) [] [f]) face-cards remaining)))
