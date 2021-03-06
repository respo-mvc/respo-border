
(ns respo-border.comp.spaces-demo
  (:require [respo.alias :refer [create-comp div]]
            [respo.component.text :refer [comp-text]]
            [respo-border.transform.space :refer [interpose-spaces]]
            [respo-border.style.layout :as layout]))

(def vertical-style {:height "8px"})

(def horizontal-style {:width "8px"})

(defn render []
  (fn [state mutate!]
    (div
      {}
      (interpose-spaces
        (div
          {:style (merge layout/column layout/area)}
          (comp-text "content-1" layout/cell)
          (comp-text "content-2" layout/cell)
          (comp-text "content-3" layout/cell))
        vertical-style)
      (interpose-spaces
        (div
          {:style (merge layout/area layout/row)}
          (comp-text "content-1" layout/cell)
          (comp-text "content-2" layout/cell)
          (comp-text "content-3" layout/cell))
        horizontal-style))))

(def comp-spaces-demo (create-comp :spaces-demo render))
