(ns api-testing-clojure.core-test
  (:gen-class)
  (:require [clojure.test :refer :all]
            [api-testing-clojure.core :refer :all]
            [api-testing-clojure.delete-api-test]
            [api-testing-clojure.get-api-test]
            [api-testing-clojure.post-api-test]
            [api-testing-clojure.put-api-test]))

(defn -main [] (run-tests
                       'api-testing-clojure.get-api-test
                       'api-testing-clojure.post-api-test
                       'api-testing-clojure.put-api-test
                       'api-testing-clojure.delete-api-test))
