(ns api-testing-clojure.delete-api-test
  (:require [api-testing-clojure.base :as base]
            [clj-http.client :as http]
            [clojure.test :refer :all]))

(defn delete-post-endpoint [id]
  (format "/posts/%s" id))

(defn call-delete-post-endpoint [endpoint]
  (http/put (str base/json-placeholder-base-url
                 endpoint)))

(deftest delete-post-test
  (let [http-call (call-delete-post-endpoint (delete-post-endpoint 1))]
    (testing "HTTP Status is 200"
      (is (= 200 (:status http-call))))))
