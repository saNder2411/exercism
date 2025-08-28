(ns dnd-character)

(defn score-modifier [score]
  (int (Math/floor (float (/ (- score 10) 2)))))

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
