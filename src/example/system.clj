(ns example.system
  (:gen-class
   :main true)
  (:require [com.stuartsierra.component :as component]
            [example.web.core :as web]
            [example.web.server :as server]))

(defrecord ExampleSystem []
  component/Lifecycle

  (start [component]
    (let [handler (web/create-app)
          server (server/create-and-start handler 9999)]
      (assoc component
             :handler handler
             :server server)))

  (stop [component]
    (when (:server component)
      (server/stop (:server component)))
    (dissoc component :handler :server)))

(defn create-system []
  (ExampleSystem.))

(defn -main [& args]
  (.start (create-system)))
