(ns example.web.server
  (:require [org.httpkit.server :refer [run-server]]))

(defn create-and-start [handler port]
  (let [server (run-server handler {:port port})]
    (println "Server started on port" port)
    server))

(defn stop [server]
  (server :timeout 100)) ; run-server returns a function to stop itself
