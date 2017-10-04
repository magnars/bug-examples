(defproject trymod "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [org.clojure/clojurescript "1.9.908"]]
  :profiles {:dev {:plugins [[lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]
                             [lein-figwheel "0.5.15-SNAPSHOT" :exclusions [org.clojure/clojure]]]
                   :dependencies []
                   :source-paths ["dev"]
                   :cljsbuild {:builds [{:id "dev"
                                         :source-paths ["src"]
                                         :figwheel true
                                         :compiler {:asset-path "js/compiled/out"
                                                    :output-dir "resources/public/js/compiled/out"
                                                    :source-map-timestamp true
                                                    :modules {:foo {:entries #{"foo.core"}
                                                                    :output-to "resources/public/js/compiled/out/foo.js"}
                                                              :bar {:entries #{"bar.core"}
                                                                    :output-to "resources/public/js/compiled/out/bar.js"}}}}]}}})
