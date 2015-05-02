(ns example.ui.pages
  (:require [quiescent.core :as q]
            [example.ui.layout :as layout]
            [example.ui.pages.intro :refer [IntroPage]]
            [example.ui.pages.demo :refer [DemoPage]]))

(defonce main-element (.getElementById js/document "main"))

(defn get-page-component [name]
  (case name
    :intro-page IntroPage
    :demo-page DemoPage))

(defn render-current-page [state]
  (let [page-name (:page (:route state))
        render-page (or (get-page-component page-name)
                        (throw (ex-info "Unknown page" page-name)))]
    (render-page state)))

(defn render [state]
  (q/render (layout/render state (render-current-page state))
            main-element))
