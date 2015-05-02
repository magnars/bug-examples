(ns user
  (:require [example.system :refer [create-system]]
            [reloaded.repl :refer [system init start stop go reset]]))

(reloaded.repl/set-init! #(create-system))
