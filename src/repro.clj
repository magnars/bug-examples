(ns repro
  (:require [clojure.core.match :refer [match]]))

(defn -main []
  (println)
  (prn 'with-shadowed-var
       (let [foo [:bar :baz]]
         (match foo
           [:bar foo] foo
           :else :got-else)))

  (prn 'without-shadowing
       (let [foo [:bar :baz]]
         (match foo
           [:bar boo] boo
           :else :got-else)))

  (println)
  (println "macro-expanded with shadowed var:")
  (println (macroexpand-1
            `(match foo
               [:bar foo] foo
               :else :got-else)))

  (println)
  (println "macro-expanded without shadowing:")
  (prn (macroexpand-1
        `(match foo
           [:bar boo] boo
           :else :got-else)))

  (println "
The only differences are in the gensym numbers and the var name (foo
vs bar). And still, one gives a different result than the other.

How come the let does not shadow the var properly?"))
