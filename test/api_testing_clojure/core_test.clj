;; This whole namespace is not needed with lein test, you need it only in case you need to use aliases
(ns api-testing-clojure.core-test
  (:gen-class)
  (:require [clojure.test :refer :all]))

(defn -main [] (run-all-tests))
