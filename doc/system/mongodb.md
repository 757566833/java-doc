1. docker-compose.yml
```
version: '3.1'

services:

  mongo:
    image: mongo:4.2.8
    restart: always
    ports:
     - 27017:27017
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: 123456789
    volumes:
      - ./data:/data
```

2. gui   
搜索  mongodb-compass

3. 添加用户
首先新建一个basedata表

进入容器
```
docker exec -it xxx /bin/bash
```
进入数据库
```
mongo
```

切换到admin
```
use admin
```

登陆
```
db.auth("root","123456789")
// 显示1的时候 是登陆成功
```

查看所有数据库
```
show dbs
```

切换数据库
```
use xxx
```

创建
```
db.createUser({user:"xxx",pwd:"123456789",roles:["readWrite"]})
```