(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (let [[_ m] (clojure.string/split s #":")]
    (clojure.string/trim m)))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (let [[l] (clojure.string/split s #":")
        l-text (subs l 1 (dec (count l)))]
    (clojure.string/lower-case l-text)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [m (message s)
        l (log-level s)]
    (format "%1s (%2s)" m l)))
