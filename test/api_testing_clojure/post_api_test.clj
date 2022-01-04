(ns api-testing-clojure.post-api-test
  (:require [api-testing-clojure.base :as base]
            [clj-http.client :as http]
            [clojure.test :refer :all]))

(def create-posts-endpoint "/posts")

(def post-payload
  {:title "foo"
   :body "bar"
   :userId 1})

(def expected-response-body
  {:id 101,
   :title "foo",
   :body "bar",
   :userId 1})

(defn call-posts-endpoint [body endpoint]
  (http/post (str base/json-placeholder-base-url
                  endpoint)
    {:form-params body
     :content-type :json
     :as :json}))

(deftest create-post-test
  (let [http-call (call-posts-endpoint post-payload create-posts-endpoint)
        response (:body http-call)]
    (testing "HTTP Status is 201"
      (is (= 201 (:status http-call))))
    (testing "Expected response matches the actual response body"
      (is (= expected-response-body response)))))
