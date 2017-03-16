(ns bleeding.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(def w 600)
(def h 400)

(defn setup []
  (q/no-stroke)
  (q/frame-rate 30)
  (q/color-mode :hsb)
  {:color 0
   :angle 0})

(defn update-state [state]
  {:color (mod (+ (:color state) 0.1) 255)
   :angle (+ (:angle state) 0.1)})

(defn draw-state [state]
  (q/background 240)
  (q/fill (:color state) 255 255)
    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      (q/begin-shape)
      (q/vertex 70 (q/random 80 100))
      (q/vertex (q/random 170 200) 80)
      (q/vertex 40 (q/random 170 200))
      (q/vertex 0 60)
      (q/end-shape)))

(q/defsketch bleeding
  :host "bleeding"
  :size [w h]
  :setup setup
  :update update-state
  :draw draw-state
  :middleware [m/fun-mode])
