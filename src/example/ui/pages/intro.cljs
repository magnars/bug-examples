(ns example.ui.pages.intro
  (:require [quiescent.core :as q]
            [quiescent.dom :refer [h1 div p ul li code]]))

(q/defcomponent IntroPage [state]
  (div {}
       (h1 {} "Intro")
       (p {} "Hi Bruce! I've tried to keep this minimal, but that turns out to be harder
              than I thought. Here are steps to reproduce the case:")
       (ul {}
           (li {} "Go to the demo page (link above)")
           (li {} "Open " (code {} "src/example/ui/pages/demo.cljs")
               " and change the " (code {} "h1") ". See that the change is"
               " immediately visible.")
           (li {} "Now, open " (code {} "src/example/ui/components.cljs")
               " and change the " (code {} "p") ". See that the change is"
               " not visible")
           (li {} "Finally, flip between the pages to see the change after all."))
       (p {} "Note that switching pages triggers the " (code {} ":page-change")
          " event, just like the " (code {} ":on-jsload") " event as seen in "
          (code {} "dev/cljs/user.cljs") ".")
       (p {} "This should demonstrate that the change has been loaded properly,
              but it is not visible until a manual re-render.")))
