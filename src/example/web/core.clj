(ns example.web.core
  (:require [clojure.java.io :as io]
            [compojure.core :refer [routes GET]]
            [compojure.route :refer [resources not-found]]
            ring.middleware.content-type
            ring.middleware.not-modified))

(defn serve-single-page-app []
  {:status 200
   :body (slurp (io/resource "public/index.html"))
   :headers {"Content-Type" "text/html; charset=utf-8"}})

(defn app-routes []
  (routes
   (GET "/" [] {:status 301, :headers {"Location" "/intro"}})
   (GET "/intro" [] (serve-single-page-app))
   (GET "/demo" [] (serve-single-page-app))
   (resources "/")
   (not-found "Not found")))

(defn create-app []
  (-> (app-routes)
      (ring.middleware.content-type/wrap-content-type)
      (ring.middleware.not-modified/wrap-not-modified)))
