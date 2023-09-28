# centos7.6 安装nvidia驱动
1. bios禁用secure boot，也就是设置为disable  
如果没有禁用secure boot,会导致NVIDIA驱动安装失败，或者不正常。 
我的主板是华硕的 https://jingyan.baidu.com/article/4dc408487a3d16c8d946f1af.html

2. 禁用nouveau驱动  
vim /etc/modprobe.d/blacklist.conf  
如果没有就创建一个我估计这玩意是和nginx一样，读取.conf的文件不在乎名字是什么 待测试

3. 备份并重建
```
mv /boot/initramfs-$(uname -r).img /boot/initramfs-$(uname -r).img.bak
dracut /boot/initramfs-$(uname -r).img $(uname -r)
```
4. 如果是有gui的 运行一下
```
systemctl set-default multi-user.target
```
5. 重启
```
reboot
```

6. 查看 没东西就是对了
```
lsmod | grep nouveau
```
7. 安装
```
./NVIDIA_2080TI_x86_x64.....sh -no-opengl-files
```

8. 有一处比较坑
```
yum update 之后，会更新内核 更新的内核会默认优先启动， 优先启动的内核 有未知的问题 我不知道改怎么解决 直接把新内核删了

还是 用yum -y upgrade 比较好
```