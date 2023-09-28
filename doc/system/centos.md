```
// 图形界面
yum groupinstall "GNOME Desktop"

安装结束后 可以设置 默认启动方式 例如文本模式

systemctl set-default multi-user.target

如果要切图形界面，相应地：

systemctl set-default graphical.target
```

```
// vnc
yum install tigervnc-server
```

```
// 添加用户

useradd vncuser
passwd xxx
```

```
// 将文件中的<USER>替换为我们的用户名vncuser.
cp /lib/systemd/system/vncserver@.service /etc/systemd/system/vncserver@:1.service

```

```
// 切换用户 启动vnc
vncserver
// 提示密码哈确认
```

```
// 切换回root
systemctl daemon-reload
systemctl enable vncserver@:1.service
```

```
// mac上有免费的 和自带的
vnc://xxx.xxx.xxx.xxx:5901
```

```
修改密码
cd ~/.vnc vncpasswd
```




# 更改root的空间
