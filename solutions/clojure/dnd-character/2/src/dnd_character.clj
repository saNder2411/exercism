(ns dnd-character
  (:require [clojure.math :as m]))

(defn score-modifier [score]
  (int (m/floor (/ (- score 10) 2))))

(defn rand-ability []
  (+ 3 (rand-int 16)))

(defn rand-character []
  (let [constitution (rand-ability)]
    {:strength     (rand-ability)
     :dexterity    (rand-ability)
     :charisma     (rand-ability)
     :wisdom       (rand-ability)
     :intelligence (rand-ability)
     :constitution constitution
     :hitpoints    (+ (score-modifier constitution) 10)}))
