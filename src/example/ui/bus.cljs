(ns example.ui.bus)

(defonce watchers (atom {}))

(defn publish [topic & messages]
  (doseq [[_ watcher] @watchers]
    (when (= topic (:topic watcher))
      (apply (:handler watcher) messages))))

(defn watch [topic name handler]
  (swap! watchers assoc [topic name]
         {:topic topic, :handler handler}))
