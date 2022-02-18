# docker 安装和配置
在gitlab@14.6.1 第一次打开页面是不会设置root密码的，可以通过密码找回来解决这个问题

https://docs.gitlab.com/ee/security/reset_user_password.html#reset-the-root-password

1. docker ps  查看所有景象
2. docker exec -it <xxxx> sh
3. gitlab-rails console -e production 如果电脑配置低会很慢 直到出现
```
--------------
 Ruby:         ruby 2.7.5p203 (2021-11-24 revision f69aeb8314) [x86_64-linux]
 GitLab:       14.6.1 (661d663ab2b) FOSS
 GitLab Shell: 13.22.1
 PostgreSQL:   12.7
--------------
```
4. 设置密码
```
user = User.where(id: 1).first
user.password = 'your secret'
user.password_confirmation = 'your secret'
user.save!
exit
```

# 启动后注意事项
1. gitlab 8以后会自动启动ci，如果想关掉，那就在管理员页面
【Admin areas】——【Settings】——【CI/CD】取消Default to Auto DevOps pipeline for all projects的选择框，点击保存