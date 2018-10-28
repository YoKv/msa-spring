# msa-spring
https://github.com/YoKv/goal/projects/10

工具箱：
* consul
* openfeign
* gateway

# build
```
mvn clean package docker:build
```
# run
```
docker-compose up -d
```

# 监控
## turbine hystrix dashboard
访问dashboard地址：
   > http://localhost:9090/hystrix

配置：
   > http://localhost:9090/turbine.stream

## admin
http://localhost:9100

## micrometer prometheus grafana
[模板](https://grafana.com/dashboards/6756)
[jvm模板](https://grafana.com/dashboards/4701)

