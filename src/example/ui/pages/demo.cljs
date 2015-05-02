(ns example.ui.pages.demo
  (:require [quiescent.core :as q]
            [quiescent.dom :refer [h1 div]]
            [example.ui.components :refer [MyComponent]]))

(q/defcomponent DemoPage [state]
  (div {}
       (h1 {} "Demo")
       (MyComponent)))
