(ns example.ui.routing
  (:require [domkm.silk :as silk]
            [quiescent.dom :refer [a]]
            [example.ui.bus :as bus]))

(def my-routes
  (silk/routes [[:intro-page [["intro"]]]
                [:demo-page [["demo"]]]]))

(defn route-current []
  (let [routing (silk/arrive my-routes (.-pathname js/location))]
    (assoc routing :page (:domkm.silk/name routing))))

(defn unroute
  ([page] (unroute page {}))
  ([page attrs]
   (try
     (silk/depart my-routes page attrs)
     (catch :default e
       (throw (ex-info "Unable to resolve URL to" page attrs))))))

(defn click-to [url]
  (fn [e _]
    (when-not (or (.-ctrlKey e) (.-altKey e) (.-metaKey e) (.-shiftKey e))
      (.preventDefault e)
      (.pushState js/history false false url)
      (bus/publish :page-change))))

(defn link-to
  ([page text] (link-to page {} text))
  ([page attrs text]
   (let [url (unroute page attrs)]
     (a {:href url,:onClick (click-to url)} text))))
