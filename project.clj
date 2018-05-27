(defproject clojure-practice "0.1.0-SNAPSHOT"
  :description "School clojure project"
  :url "http://example.com/FIXME"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
  				 [ring "1.6.0"]]
  :main clojure-practice.core
  :profiles {:dev 
            	{:main clojure-practice.core/-wrap-reload-main}})
