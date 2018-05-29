(ns views.home
  (:require [clojure.string :as str]
            [hiccup.page :as page]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Customers: " title)]])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/add-customer"} "Add a customer"]
   " | "
   [:a {:href "/customers"} "View all customers"]
   " ]"])

(defn home-page
  []
  (page/html5
   (gen-page-head "Home")
   header-links
   [:h1 "Home"]
   [:p "CRUD customers"]))