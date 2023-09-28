https://github.com/acmesh-official/acme.sh/wiki/%E8%AF%B4%E6%98%8E

https://github.com/acmesh-official/acme.sh/wiki/dnsapi 

1. 安装 
```
curl  https://get.acme.sh | sh -s email=757566833@qq.com
wget -O -  https://get.acme.sh | sh -s email=757566833@qq.com

上一个如果拉不下来 参考这个https://github.com/acmesh-official/acme.sh/wiki/How-to-install

curl https://raw.githubusercontent.com/acmesh-official/acme.sh/master/acme.sh | sh -s -- --install-online -m  757566833@qq.com

```

acme.sh --issue --dns dns_ali -d *.fzcode.com

service nginx force-reload


harbor的文档可以参考自发证书
https://goharbor.io/docs/2.4.0/install-config/configure-https/