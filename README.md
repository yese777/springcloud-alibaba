nacos:
sh bin/startup.sh -m standalone
http://127.0.0.1:8848/nacos

sentinel:
java -jar sentinel-dashboard-1.8.1.jar --server.port=8888
http://127.0.0.1:8888/


zipkin:
docker run -d -p 9411:9411 --name zipkin openzipkin/zipkin
http://127.0.0.1:9411/zipkin/