(ns api-testing-clojure.get-api-test
  (:require [api-testing-clojure.base :as base]
            [clojure.test :refer :all]
            [clj-http.client :as http]
            [clojure.data.json :as json]))

(def posts-endpoint "/posts")

(def users-endpoint "/users")

(deftest get-posts-test
  (let [response (:body
                  (http/get (str base/json-placeholder-base-url posts-endpoint)
                            {:content-type "application/json"
                             :accept :json}))
        formatted-response (json/read-str response)]
    (testing "There are 100 posts"
      (is (= 100 (count formatted-response))))
    (testing "The title of second post is correct"
      (is (= "qui est esse" (-> (fn [x] (= (get x "id") 2))
                                (filter formatted-response)
                                first
                                (get "title")))))))

(deftest get-posts-test
  (let [response (:body
                  (http/get (str base/json-placeholder-base-url users-endpoint)
                            {:content-type "application/json"
                             :accept :json}))
        formatted-response (json/read-str response)]
    (testing "There are 10 users"
      (is (= 10 (count formatted-response))))))


