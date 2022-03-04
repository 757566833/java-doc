# 安装
在网站卡产自托管
https://develop.sentry.dev/self-hosted/

# 邮件设置
sentry 本身自带一个邮件设置，在用户第一次登陆的时候，但是这个是没实现的
设置后默认是
host    smtp:25  
要改成 例如 smtp.126.com 使用外部邮件服务
https://develop.sentry.dev/self-hosted/email/
上面写明 需要修改 config.yml 下的mail.*

1. 普通配置

```
mail.backend: 'smtp'  # Use dummy if you want to disable email entirely
mail.host: 'smtp.126.com'
mail.port: 25
mail.username: 'fzcode@126.com'
mail.password: '*********'
# mail.use-tls: false
# mail.use-ssl: false

# NOTE: The following 2 configs (mail.from and mail.list-namespace) are set
#       through SENTRY_MAIL_HOST in sentry.conf.py so remove those first if
#       you want your values in this file to be effective!


# The email address to send on behalf of
mail.from: 'fzcode@126.com'
```

2. 启动ssl

```
mail.backend: 'smtp'  # Use dummy if you want to disable email entirely
mail.host: 'smtp.126.com'
mail.port: 465
mail.username: 'fzcode@126.com'
mail.password: '************'
# mail.use-tls: false
mail.use-ssl: true
# NOTE: The following 2 configs (mail.from and mail.list-namespace) are set
#       through SENTRY_MAIL_HOST in sentry.conf.py so remove those first if
#       you want your values in this file to be effective!


# The email address to send on behalf of
mail.from: 'fzcode@126.com'
```
> 126  文档上明确写明支持ssl 但是没有关于tls 的描述

3. 启动tls
发送后会超时  目前看到一个解决办法
https://github.com/getsentry/self-hosted/issues/71#issuecomment-380057664

不知道是哪里的问题 或许是126不支持tls 这部分是我的盲区

# 客户端
## npm项目
1. 电脑这边如果安装在nextjs上面，需要安装@sentry/next,这里面有一个sentry/cli,里面的install脚本需要翻墙安装
```
// 解决方法
// 新建.yarnrc npm用.npmrc
// 内容如下
SENTRYCLI_CDNURL "https://cdn.npm.taobao.org/dist/sentry-cli"
sentrycli_cdnurl "https://cdn.npm.taobao.org/dist/sentry-cli"
```
> 这个链接怎么来的不清楚，网上找到的，随着npm.taobao.org的域名失效，可能会出现一些问题
2. 参数配置（nextjs相关）
全局变量要设置
```
SENTRY_URL=demo      //这个是url，不需要带path 例如https://www.baidu.com/
SENTRY_ORG=demo      // 这个org 在settings><user>>general 里面有一个organization slug 最简单的办法就是 进入setting 然后右上角搜索organization
SENTRY_PROJECT=      //项目名称
SENTRY_AUTH_TOKEN=a82d9abbc574404a932ee416032d781df26f53570eef4493bec928537375a016              // setting>account>api>auth>tokens 新建一个
```
