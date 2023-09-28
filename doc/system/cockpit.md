### 介绍
这是个用web管理linux的服务，这个服务是搞生态的，我在官方界面只看到了主体，我装这个主要是为了方便远程

1. 安装

https://cockpit-project.org/running.html#centos

1.1 https://github.com/cockpit-project/cockpit/wiki/Proxying-Cockpit-over-NGINX 

2. https
https://cockpit-project.org/guide/latest/https.html

3. 插件

https://cockpit-project.org/applications.html

4. 周边
以下是Cockpit的一些软件模块，可以根据自己的需要选择性的安装（来自网络）

Package Name	Purpose
cockpit-docker	Managing Docker Containers
cockpit-kubernetes	Visualizing and Configuring Kubernetes Cluster
cockpit-machines	Manage KVM Virtual Machines
cockpit-sosreport	Create diagnostic report with the sosreport tool
cockpit-selinux	Troubleshoot SELinux Issues
cockpit-kdump	Configure Kernel Crash Dumps
cockpit-subscriptions	Manage System subscription
cockpit-machines-ovirt	Manage oVirt Virtual Machines
cockpit-pcp	Reading PCP metrics and Loading PCP archives

这里我只用了 cockpit-machines cockpit-docker 而且亲测可用

4. 注意

网络那个最好不要动 NetworkManager 和network有冲突