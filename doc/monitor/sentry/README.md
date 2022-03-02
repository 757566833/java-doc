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