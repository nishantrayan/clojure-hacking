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

;function creating other function
(defn range-checker
    "returns a function which can be passed a number to check if it lies in a certain range"
    [min max]
    (fn [x]
        (and (> x min)
                (< x max))))
(defn fn-wrapper
    "prints a comment string along with the result of evaluating a function"
    [comment fn-val]
    (do (println (str comment ":" fn-val))
        fn-val))
(def lt100 (range-checker 0 100))
(fn-wrapper "10 is less than 100" (lt100 10))
(fn-wrapper "101 is not less than 100" (not (lt100 101)))

;pi multiplication using currying
(def times-pi (partial * 3.14))
(fn-wrapper "2 times pi is" (times-pi 2))
(fn-wrapper "3 times pi is" (times-pi 3))

;struct-map example
(defstruct person :first-name :last-name)
(def girl (struct-map person :first-name "maitreyee" :last-name "korgaonkar"))
(def boy (struct-map person :first-name "nishant" :last-name "rayan"))
(def get-first-name (accessor person :first-name))
(def get-last-name (accessor person :last-name))
(fn-wrapper "Boy's last name is" (boy :last-name))
(fn-wrapper "Boy's last name is" (get-last-name boy))
(fn-wrapper "Girl's first name is" (get-first-name girl))

;trying to use map functions
(assert (= 1 ({:x 1 :y 2} :x)))
(assert (= 3
            ((conj {:x 1 :y 2} {:z 3}) :z)))
(assert (= "nishant"
            ((assoc {:last-name "rayan"} :first-name "nishant") :first-name)))
(assert (nil? ({:last-name "rayan"} :first-name)))
(assert (nil?
            ((dissoc {:last-name "rayan" :first-name "nishant"} :first-name) :first-name)))
(let [my-name (merge-with str {:first-name "nishant" :name "nishant "} {:last-name "rayan" :name "rayan"})]
        (assert (= "nishant" (my-name :first-name)))
        (assert (= "rayan" (my-name :last-name)))
        (assert (= "nishant rayan" (my-name :name)))
        (assert (= #{:first-name :last-name :name} (set (keys my-name))))
        (assert (= #{"nishant" "nishant rayan" "rayan"} (set (vals my-name))))
        my-name)
(assert (contains? {:a 1 :b 2} :a))

;demo of first and rest functions
(defn just-loop-and-print
    "prints all the elements of a sequence"
    [s]
        (if (not (empty? s))
            (do (println (str "item:" (first s)))
             (recur (rest s)))))

(do
    (println "on vector")
        (just-loop-and-print [1 2 3])
    (println "on list")
        (just-loop-and-print '(4 5 6)))

