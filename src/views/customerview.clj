(ns views.customerview
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

(defn all-customers-page
  []
  (page/html5
   (gen-page-head "Add a Customer")
   header-links
   [:h1 "All Customers"]
     [:table
      [:tr [:th "id"] [:th "First Name"] [:th "Last Name"] [:th "Email"] [:th "age"]]
      [:tr [:td "1"] [:td "Milos"] [:td "Marinkovic"] [:td "marinkovicmilos@gmail.com"] [:td "26"]]
      [:tr [:td "2"] [:td "Matija"] [:td "Marjanovic"] [:td "marjanovicmatija@gmail.com"] [:td "25"]]]))

