(ns othe.core-test
  (:require [clojure.test :refer :all]
            [othe.model :refer :all]))

(deftest first-player-test
  (testing "should"
    (is (= :b (first-player [0.5])))))
