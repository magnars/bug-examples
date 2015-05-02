(defproject example "0.1.0-SNAPSHOT"
  :description "Minimal example of issue 136"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3126"]
                 [com.stuartsierra/component "0.2.3"]
                 [compojure "1.3.2"]
                 [ring "1.3.2" :exclusions [org.clojure/java.classpath]]
                 [cheshire "5.4.0"]
                 [quiescent "0.2.0-alpha1"]
                 [http-kit "2.1.19"]
                 [com.domkm/silk "0.0.4"]]
  :main example.system
  :profiles {:dev {:dependencies [[reloaded.repl "0.1.0"]
                                  [figwheel "0.2.6"]]
                   :plugins [[lein-cljsbuild "1.0.5"]
                             [lein-figwheel "0.2.6"]]
                   :source-paths ["dev"]
                   :cljsbuild {:builds [{:source-paths ["src" "dev"]
                                         :compiler {:output-to "target/classes/public/app.js"
                                                    :output-dir "target/classes/public/out"
                                                    :externs ["resources/cljs-externs.js"]
                                                    :optimizations :none
                                                    ;:recompile-dependents true
                                                    :source-map true}}]}
                   :figwheel {:server-port 3449
                              :nrepl-port 7888}}})
