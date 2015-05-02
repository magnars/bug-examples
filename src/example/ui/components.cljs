(ns example.ui.components
  (:require [quiescent.core :as q]
            [quiescent.dom :refer [p]]))

(q/defcomponent MyComponent []
  (p {} "My component is here."))
