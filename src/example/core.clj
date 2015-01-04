(ns example.core
  (:require [ring.middleware.cookies]))

(def my-routes nil)

(def app
  (ring.middleware.cookies/wrap-cookies my-routes))
