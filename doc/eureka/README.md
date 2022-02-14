# eureka
[示例代码](../../example/eureka/)
## eureka在单独，两个，多个的时候如何部署
###  一个eureka单独部署
1. application.yml
```
...
eureka:
  client:
#    单节点，不需要自己注册自己
    register-with-eureka: false
#    单节点，不需要从其他的eureka拉取服务注册信息
    fetch-registry: false
...
```

2. 启动
mvn spring-boot:run

3. 访问url 
[http://127.0.0.1:8080](http://127.0.0.1:8080)

### 两个eureka部署
> 由于eureka的特殊性，当作为集群的时候，不可以用ip配置，这里引入一个网站，nip.io,具体的不多解释，是个范域名解析
1. eureka1 application.yml
```
server:
  port: 12021
  servlet:
    encoding:
      charset: utf-8
      force-response: true
spring:
  application:
    name: eurekaServer
eureka:
  instance:
    hostname: 127.0.0.1.nip.io
  client:
    service-url:
      defaultZone: http://127-0-0-1.nip.io:12022/eureka/
```
2. eureka2 application.yml
```
server:
  port: 12022
  servlet:
    encoding:
      charset: utf-8
      force-response: true
spring:
  application:
    name: eurekaServer
eureka:
  instance:
    hostname: 127-0-0-1.nip.io
  client:
    service-url:
      defaultZone: http://127.0.0.1.nip.io:12021/eureka/
```
3. 启动1
mvn spring-boot:run  
发现没有任何注册信息
4. 启动2
mvn spring-boot:run  
发现有自己服务的信息
5. 运行流程
```flow
st=>start: 运行eureka
op1=>operation: 将自己注册到目标eureka
op2=>operation: 从目标eureka拉取注册信息，并与自己的信息合并
end=>end: 结束当前流程

st->op1->op2->end

```
6. 描述
所以当我们将eureka的两个节点互相注册的时候，就会出现上述情况，当eureka1启动时，eureka2并未启动，1无法将自己的信息注册到2上，也无法从2拉取到信息，当eureka2启动时，将自己的2信息注册到1上，并将1的信息拉取，合并到自己的服务中

### 多个eureka部署

代码自拉
