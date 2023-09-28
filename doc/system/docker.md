## 换源
https://docs.docker.com/engine/reference/commandline/dockerd/#daemon-configuration-file



```
On Linux
The default location of the configuration file on Linux is /etc/docker/daemon.json. The --config-file flag can be used to specify a non-default location.

This is a full example of the allowed configuration options on Linux:
{
  "allow-nondistributable-artifacts": [],
  "api-cors-header": "",
  "authorization-plugins": [],
  "bip": "",
  "bridge": "",
  "cgroup-parent": "",
  "cluster-advertise": "",
  "cluster-store": "",
  "cluster-store-opts": {},
  "containerd": "/run/containerd/containerd.sock",
  "containerd-namespace": "docker",
  "containerd-plugin-namespace": "docker-plugins",
  "data-root": "",
  "debug": true,
  "default-address-pools": [
    {
      "base": "172.80.0.0/16",
      "size": 24
    },
    {
      "base": "172.90.0.0/16",
      "size": 24
    }
  ],
  "default-cgroupns-mode": "private",
  "default-gateway": "",
  "default-gateway-v6": "",
  "default-runtime": "runc",
  "default-shm-size": "64M",
  "default-ulimits": {
    "nofile": {
      "Hard": 64000,
      "Name": "nofile",
      "Soft": 64000
    }
  },
  "dns": [],
  "dns-opts": [],
  "dns-search": [],
  "exec-opts": [],
  "exec-root": "",
  "experimental": false,
  "features": {},
  "fixed-cidr": "",
  "fixed-cidr-v6": "",
  "group": "",
  "hosts": [],
  "icc": false,
  "init": false,
  "init-path": "/usr/libexec/docker-init",
  "insecure-registries": [],
  "ip": "0.0.0.0",
  "ip-forward": false,
  "ip-masq": false,
  "iptables": false,
  "ip6tables": false,
  "ipv6": false,
  "labels": [],
  "live-restore": true,
  "log-driver": "json-file",
  "log-level": "",
  "log-opts": {
    "env": "os,customer",
    "labels": "somelabel",
    "max-file": "5",
    "max-size": "10m"
  },
  "max-concurrent-downloads": 3,
  "max-concurrent-uploads": 5,
  "max-download-attempts": 5,
  "mtu": 0,
  "no-new-privileges": false,
  "node-generic-resources": [
    "NVIDIA-GPU=UUID1",
    "NVIDIA-GPU=UUID2"
  ],
  "oom-score-adjust": -500,
  "pidfile": "",
  "raw-logs": false,
  "registry-mirrors": [],
  "runtimes": {
    "cc-runtime": {
      "path": "/usr/bin/cc-runtime"
    },
    "custom": {
      "path": "/usr/local/bin/my-runc-replacement",
      "runtimeArgs": [
        "--debug"
      ]
    }
  },
  "seccomp-profile": "",
  "selinux-enabled": false,
  "shutdown-timeout": 15,
  "storage-driver": "",
  "storage-opts": [],
  "swarm-default-advertise-addr": "",
  "tls": true,
  "tlscacert": "",
  "tlscert": "",
  "tlskey": "",
  "tlsverify": true,
  "userland-proxy": false,
  "userland-proxy-path": "/usr/libexec/docker-proxy",
  "userns-remap": ""
}
```


```
// 删除所有
docker stop $(docker ps -aq)
docker system prune -f
docker volume rm $(docker volume ls -q)
docker image rm $(docker image ls -q)
```


2. centos in docker 
docker-compose 
```
version: '3.1'

services:

  centos1:
    image: centos:7.6.1810
    container_name: centos1
    restart: always
    dns: 8.8.8.8
    stdin_open: true
    tty: true
    privileged: true
    command: /usr/sbin/init 

#pipework br0 centos1 192.168.31.151/24@192.168.31.1
```
4. 安装pipework
```
git clone https://github.com/jpetazzo/pipework
 cd pipework

 cp pipework /usr/bin/
```

4. 关闭 NetworkManager
```
systemctl stop NetworkManager

systemctl disable NetworkManager
```
5. 查看docker 容器 ip
```
docker inspect centos1
```
6. 切换root
```
如果不切换
mkdir: 无法创建目录"/var/run/netns": 权限不够

```
7. a
```
pipework br0 name xxx.xxx.xxx.xxx/24@yyy.yyy.yyy.yyy
```