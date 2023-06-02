k6 -e port=8081 run k6/test.js -u 1000 -d 60s &
k6 -e port=8082 run k6/test.js -u 1000 -d 60s &
k6 -e port=8083 run k6/test.js -u 1000 -d 60s &
k6 -e port=8084 run k6/test.js -u 1000 -d 60s &
k6 -e port=8085 run k6/test.js -u 1000 -d 60s &
