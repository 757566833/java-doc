# init
1. spring.io下载
2. 删除没用的单独留一个pom.xml

# 添加子模块
```
...

    <modules>
		<module>account-service</module>
		<module>eureka-service</module>
		<module>examination-service</module>
		<module>file-service</module>
		<module>gate-service</module>
	</modules>
...
```

# 添加是jar还是pom的标识
```
...
<packaging>pom</packaging>
...
```