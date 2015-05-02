(ns example.ui.layout
  (:require [quiescent.core :as q]
            [quiescent.dom :refer [div a ul li]]
            [example.ui.routing :refer [link-to]]))

(q/defcomponent Navbar
  [state]
  (let [current-page (-> state :route :page)]
    (div {:className "navbar navbar-inverse navbar-static-top"}
         (div {:className "container"}
              (div {:className "navbar-header"}
                   (a {:className "navbar-brand"
                       :href "#"}
                      "Minimal example?"))
              (ul {:className "nav navbar-nav"}
                  (li {:className (when (= :intro-page current-page) "active")}
                      (link-to :intro-page "Intro"))
                  (li {:className (when (= :demo-page current-page) "active")}
                      (link-to :demo-page "Demo")))))))

(defn render [state page-elements]
  (div {}
       (Navbar state)
       (div {:className "container"}
            page-elements)))
