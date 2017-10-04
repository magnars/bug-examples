(ns foo.core
  (:require [baz.core :as baz]
            [cljs.loader :as loader]
            [goog.dom :as gdom]
            [goog.events :as events])
  (:import [goog.events EventType]))

(defn ^:export main []
  (println "I'm foo.main, baz is" (baz/get-name) "!"))

(main)

(events/listen (gdom/getElement "button") EventType.CLICK
               (fn [e]
                 (println "Loading bar")
                 (loader/load :bar
                              (fn []
                                (println "Loaded bar")
                                ((resolve 'bar.core/woz))))))

(loader/set-loaded! :foo)

