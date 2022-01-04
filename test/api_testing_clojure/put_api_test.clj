(ns api-testing-clojure.put-api-test
  (:require [api-testing-clojure.base :as base]
            [clj-http.client :as http]
            [clojure.test :refer :all]))

(defn update-resource-endpoint [id]
  (format "/posts/%s" id))

(defn post-payload [id]
  {:title "foo"
   :body "bar"
   :userId 1
   :id id})

(defn call-update-post-endpoint [body endpoint]
  (http/put (str base/json-placeholder-base-url
                  endpoint)
    {:form-params body
     :content-type :json
     :as :json}))

(deftest update-post-test
  (let [http-call (call-update-post-endpoint (post-payload 1)
                                             (update-resource-endpoint 1))
        response (:body http-call)]
    (testing "HTTP Status is 200"
      (is (= 200 (:status http-call))))
    (testing "Expected response matches the actual response body"
      (is (= 1 (:id response))))))
