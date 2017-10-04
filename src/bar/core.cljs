(ns bar.core
  (:require [bar.dep :as dep]
            [baz.core :as baz]
            [cljs.loader :as loader]))

(defn woz []
  (println "bar.core/woz is invoked!"))

(defn ^:export main []
  (println "I'm bar.main? baz is" (baz/get-name) ", dep is" (dep/get-dep) "!"))

(main)

(loader/set-loaded! :bar)
