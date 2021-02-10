(ns shadow-cljs-require.core
  (:require [reagent.core :as reagent :refer [atom]]
            ["@elastic/eui" :refer [EuiIcon]]))

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(def icon (reagent/adapt-react-class EuiIcon))

(defn hello-world []
  [:> EuiIcon
   {:type "plus"}])

(defn start []
  (reagent/render-component [hello-world]
                            (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
