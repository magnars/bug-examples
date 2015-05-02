(ns cljs.user
  (:require [figwheel.client :as fw]
            [example.ui.bus :as bus]))

(fw/start {:websocket-url "ws://localhost:3449/figwheel-ws"
           :on-jsload (fn [] (bus/publish :page-change))})
