(ns example.ui.main
  (:require [example.ui.pages :as pages]
            [example.ui.routing :as routing]
            [example.ui.bus :as bus]))

(enable-console-print!)

(defonce state (atom {:route (routing/route-current)}))

(add-watch state :render-after-change
           (fn [_ _ _ new-state]
             (pages/render new-state)))

(bus/watch :page-change :route-to-new-page
           (fn [_]
             (swap! state assoc :route (routing/route-current))))

(defonce initialize-once-only ;; not re-evaluated when figwheel reloads file
  (do
    (.addEventListener js/window "popstate" #(bus/publish :page-change))
    (pages/render @state)))
