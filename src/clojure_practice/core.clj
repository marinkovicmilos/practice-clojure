(ns clojure-practice.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn hello
  [request]
  (if (= "/" (:uri request))
    {:status 200
     :body "<h1>Hello World</h1>
            <p>My first Clojure app.</p>"
     :headers {}}
    {:status 404
     :body "<h1>Error 404</h1>
            <p>Page not found</p>"
     :headers {}}))

(defn -main
  [port-number]
  (jetty/run-jetty hello
    {:port (Integer. port-number)}))

(defn -wrap-reload-main
  [port-number]
  (jetty/run-jetty (wrap-reload #'hello)
     {:port (Integer. port-number)}))

