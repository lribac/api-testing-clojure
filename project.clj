(defproject api-testing-clojure "0.1.0-SNAPSHOT"
  :description "API automation testing with clj-http library"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[cheshire "5.10.0"]
                 [clj-http "3.12.3"]
                 [eftest "0.5.9"]
                 [org.clojure/clojure "1.10.3"]
                 [org.clojure/data.json "2.4.0"]]
  :eftest {:multithread? true
           :thread-count 10
           :report eftest.report.pretty/report
           ;:report eftest.report.junit/report
           ;; You can optionally write the output to a file like so:
           #_#_:report-to-file "junit.xml"}
  :main api-testing-clojure.core-test
  :repl-options {:init-ns api-testing-clojure.core-test}
  :plugins [[lein-eftest "0.5.9"]]
  #_#_:profiles {:dev {:aliases
                   {"run-tests"
                    ["run" "-m" "api-testing-clojure.core-test"]}}})
