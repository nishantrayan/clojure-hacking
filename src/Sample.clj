(ns seconds-week-conversion)
(def x 10)
(def equality (if (= x 10)
    "x equal to 10"
    "x not equal to 10"))
(defn seconds-to-weeks
    "converts from seconds to  number of weeks"
    [seconds]
    (let [minutes (/ seconds 60)
        hours (/ minutes 60)
        days (/ hours 24)
        weeks (/ days 7)]
        weeks))
(println (seconds-to-weeks (* 60 60 24 7 2)))

(ns sqrt)
    (defn abs
        "finds the absolute value of a number"
        [x]
        (if (< x 0)
            (* -1 x)
                x))
    (defn avg
        "finds the average between 2 numbers"
        [x y]
        (/ (+ x y) 2))

    (defn good-enough?
        "Checks if the guess for a square root is good enough"
        [number guess-square-root]
        (< (abs (- (* guess-square-root guess-square-root) number)) 0.001))
    (defn sqrt
        "finds the square root of a number using loop symbol"
        [x]
        (loop [guess 1.0]
            (if (good-enough? x guess)
                    guess
                        (recur (avg guess (/ x guess))))))
    (println (str "square root of 12 is " (sqrt 12)))

;add up numbers
(defn add-numbers
    "adds the sequence of number below a certain limit"
    ([limit] (add-numbers limit 0 0))
    ([limit current sum]
        (if (> current limit)
                sum
                    (recur limit (inc current) (+ sum current)))))
(println (str "Sum of numbers <= 3 is" (add-numbers 3)))
(println (str "sum of numbers <= 10 is" (add-numbers 10)))
(println (str "sum of numbers <= 10000 is " (add-numbers 10000)))

;argument switcher
(defn arg-switch
    "calls a function with 2 arguments in all possible orders"
    [fun arg1 arg2]
    (list (fun arg1 arg2) (fun arg2 arg1)))
(println (str "Calling / with 2 arguments and switching them" (arg-switch / 2 3)))
(println (str "Calling str with 2 arguments and switching them" (arg-switch str " Hello " " nishant ")))
