(ns views.create
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

(defn add-customer-page
  []
  (page/html5
   (gen-page-head "Add a Customer")
   header-links
   [:h1 "Add a Customer"]
   [:form {:action "/add-customer" :method "POST"}
    [:p "First name: " [:input {:type "text" :name "fistName"}]]
    [:p "Last name: " [:input {:type "text" :name "lastName"}]]
    [:p "Email: " [:input {:type "text" :name "email"}]]
    [:p "Age: " [:input {:type "text" :name "age"}]]
    [:p [:input {:type "submit" :value "save customer"}]]]))


