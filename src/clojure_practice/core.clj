(ns clojure-practice.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [views.home :as home]
            [views.create :as create]
            [views.customerview :as customerview]))

(defn hello
  [request]
  {:status 200
     :body "<h1>Hello World</h1>  
     		<p>My first Clojure app with defroutes for requests</p>"
   :headers {}})

(defn about
  [request]
  {:status 200
   :body "<h1>About page</h1>  
     	  <p>Milos Marinkovic, Sofrware Developer</p>"
   :headers {}})

(defn greeting
  [request]
  (let [name (get-in request [:route-params :name])]
    {:status 200
     :body (str "Hello " name ".")
     :headers {}}))

(defn greeting-full-name
  [request]
  (let [firstName (get-in request [:route-params :firstName]) 
  		lastName (get-in request [:route-params :lastName])]
    {:status 200
     :body (str "Hello " firstName ", " lastName ".")
     :headers {}}))


(defroutes app
  ;;(GET "/" [] hello)
  (GET "/" [] (home/home-page))
  (GET "/add-customer" [] (create/add-customer-page))
  (GET "/customers" [] (customerview/all-customers-page))
  (GET "/about" [] about)
  (GET "/greeting/:name" [] greeting)
  (GET "/greeting/:firstName/:lastName" [] greeting-full-name)
  (not-found "<h1>Error 404</h1>
              <p>Page not found</p>"))


(defn -main
  [port-number]
  (jetty/run-jetty app
    {:port (Integer. port-number)}))

(defn -wrap-reload-main
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
     {:port (Integer. port-number)}))

