# centos下 r8125 2.5g的网卡驱动安装

> 基于centos 7.6 最小安装版本

## 运行autorun.sh 需要的环境
> 需要个u盘，断网情况下u盘应该是唯一解了吧
1. 提示 /lib/modules/3.10.0-514.el7.x86_64/build:  
  解决方案：  
  从ios里面拿到包 在packages下  
  复制拿到 kernel-devel 建议直接拿全家桶  
  安装

2. 安装kernel-devel时候需要依赖  
解决方案：   
从ios里面拿到包 在packages下  
复制拿到 perl 建议直接拿全家桶 
这步我没看懂依赖 直接批量安装了 rpm -ivh perl-* --nodeps --force

3. 再次运行.sh 提示需要gcc  
解决方案：   
从ios里面拿到包 在packages下  
复制拿到 gcc 

4. gcc 安装需要依赖  
解决方案：   
从ios里面拿到包 在packages下  
复制拿到 cpp glibc-devel libmpc mpfr 四个全家桶
安装依赖顺序
mpfr
libmpc
glibc-devel
cpp

5. 安装 glibc-devel依赖  
复制拿到  glibc-header （建立在已经安装好 libmpc mpfr 前提下）

6.  安装 glibc-header依赖  
复制拿到  kernel-header 如果第一步是全家桶 这步就没问题了


#  环境问题(更改驱动源码兼容)
1. /src/r8125.h:59:20  error: redefinition of 'ether_addr_copy' static inline void ether_addr_copy

```
// 解决方案 在r8125.h 这个文件的第五十八行
#if LINUX_VERSION_CODE < KERNEL_VERSION(3,14,0)

// 改为

#if LINUX_VERSION_CODE < KERNEL_VERSION(3,10,0)
```

2. r8125_n.c:10870:9 error :unknown field 'ndo_change_mtu' specified in initializer
```
// 解决方案
cat /usr/src/kernels/3.10.0-327.el7.x86_64/include/linux/netdevice.h | grep ndo_change_mtu
// 这个文件里面 ndo_change_mtu 定义的是什么名称  我这里是ndo_change_mtu_rh74
// 在r8125_n.c的10870行对应改掉就行了 这个官方承认是个bug

```

3. r8125_n.c:13519:28 error 'struct net_device' has no member named 'last_rx'
```
// 解决方案 这个是内核的版本问题 直接注释掉vi
```

## 再次运行.sh 可以上网了

4. 告别一次性
在 /etc/sysconfg/network-script下面新建文件ifcfg-xxx
```
DEVICE="xxx"
NAME="xxx"
BOOTPROTO="static"
ONBOOT="yes"
TYPE="ethernet"
NETMASK="xxx.xxx.xxx.xxx" // 一般是 255.255.255.0
IPADDR="xxx.xxx.xxx.xxx"
GATEWAY="xxx.xxx.xxx.xxx"
UUID="xxx"                //nmcli con 自己看
DNS1="114.114.114.114"
DNS2="8.8.8.8"
```
systemctl restart network.service
