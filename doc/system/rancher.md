初始化
docker rm -f $(docker ps -qa)
  docker volume rm $(docker volume ls -q)
  for mount in $(mount | grep tmpfs | grep '/var/lib/kubelet' | awk '{ print $3 }') /var/lib/kubelet /var/lib/rancher; do umount $mount; done
  rm -rf /etc/ceph \
       /etc/cni \
       /etc/kubernetes \
       /opt/cni \
       /opt/rke \
       /run/secrets/kubernetes.io \
       /run/calico \
       /run/flannel \
       /var/lib/calico \
       /var/lib/etcd \
       /var/lib/cni \
       /var/lib/kubelet \
       /var/lib/rancher \
       /var/log/containers \
       /var/log/pods \
       /var/run/calico

https://gist.github.com/superseb/2cf186726807a012af59a027cb41270d
#!/bin/sh
docker rm -f $(docker ps -qa)
docker volume rm $(docker volume ls -q)
cleanupdirs="/var/lib/etcd /etc/kubernetes /etc/cni /opt/cni /var/lib/cni /var/run/calico /opt/rke"
for dir in $cleanupdirs; do
  echo "Removing $dir"
  rm -rf $dir
done
       

https://docs.rancher.cn/docs/rancher2/installation_new/requirements/installing-docker/_index

curl https://releases.rancher.com/install-docker/19.03.sh | sh

或许脚本有点问题 要手动启动和开机启动


装错了版本 安装和删除 
https://docs.docker.com/engine/install/centos/#install-using-the-repository