## Some docker basics

## What is docker
Docker is a tool that can package an application and its dependencies in a virtual container that can run on any host using the linux Kernal(real kernal or emulated, emulated kernel used in windows).

- It was created by datcloud a PAAS company and opensourced it as a containerarization technology. Its the most popular containerization technology. 
- It's has very lightweight images because of which it is easy to share.
- Supports resource isolation i.e Application and dependency that are in one container are independent from that of other container running on the same host. Therefore multiple docker container can run on same host. 

## Dockers Blocks - Architecture
Mainly consists of 4 parts
1. ### Docker Daemon
    It listens for docker API request and and manages docker objects. Its plays an important role in communicating with other daemons to manage docker services.

2. ### Docker client
    - It is the primary way that many docker user interacts with docker.
    - All of the docker command uses docker API's.
    - Docker client sends docker run command to dockerd and docker clients can communicate with more than one docker daemon. 

3. ### Docker Registry
    - These store docker images
    - Docker hub and docker cloud are public registries
    - When docker pull or docker run command are used they pull images from these registries

4. ### Docker Objects
    - Images
    - Container
    - Services

## Docker VS VM

## Advantages

## Installing/Uninstalling docker on Debian
### Installing Docker
1. Download the deb package from [here](https://download.docker.com/linux/debian/dists/jessie/pool/stable/amd64/)
2. Install using ```dpkg -i /path/to/deb/file.deb```
3. start docker daemon ```sudo service docker start```
4. verify by running any docker command like ```docker images```
5. Run docker commands with sudo permissions

### Uninstalling Docker
1. Find the docker package name by running ```dpkg -l | grep docker```
2. Purge the package using ```sudo apt-get purge docker-ce```
3. Remove the directory ```sudo rm -rf /var/lib/docker``` 

## Docker Container Lifecycle
![Docker Container Lifecycle](https://gist.github.com/dgarg20/9970f3732adcbecacd46d3474123c94b/raw/2cde137d1c955370364242fe46fec4a28f31eec0/Container-lifecycle.png)

## Please refer to below link for how to create docker file and create docker images out of docker file.
[Creating docker image]()

## Docker Container Useful Commands
### Restarting docker with new config

1. #### Stoping docker daemon
```bash
sudo service docker stop  
```

2. #### Removing all docker related images and files configuration
```bash
sudo rm -rf /var/lib/docker
```

3. #### Starting docker daemon
```bash
sudo service docker start
```

### Docker Images Commands
```bash
docker images # Display all docker images
docker rmi <image name> # Removes the image from docker
```

### Pull image from configured registry
```bash
docker pull <image-name>
#example
docker pull hello-world
```

### Docker container run command
```bash
docker run <image-name>
#example
docker run hello-world
```
#### Docker Run Tags
- Attach Volume or mount volume 
 ```-v <path system>:<pathdocker>```

- Port Mapping  ```<system-port>:<docker-port>```

- memory limit
 ``` --memory=6gb ``` OR ```-m 6gb```

- swap memory  ```--memory-swap=2gb``` It should be generally equal to memory limit

- attach to container STDIN and STOUT as soon as it starts  ``` -a```

- don't attach to container STDIN and STOUT as soon as it starts ```-d```

- run container with interactive mode  ```-i```

- providing the name to the docker container ```--name=<docker-name> ```

- limit no of CPU for a container ```--cpus=2```

- limiting resources Ulimit options ```--ulimit```

Note: - More run tags can be found [here](https://docs.docker.com/engine/reference/commandline/run/)

#### Example command
```docker
docker run -it -d -v /var/log: /var/docker/log -p 2500:3000 -m 4gb --memory-swap=4gb --cpus=2 --name=my-docker   
```

### Load docker image from a tar file
```bash
docker load < tarfile.tar
```

### Docker remove container
```bash
docker rm <container_id> <container_id>
```

### Saving Docker container to an image with current state
Use docker commit command to create an image out of current state of the running docker container
```bash
docker commit <container_id> <tag name>:<release_type>
```

### Docker tag is used to save a image with dirffert name and also tagging it with some version
```bash
docker tag <image_id> <new_tag>:<tag_release>
```

### Save committed images to tar file
```bash
docker save <container-id> > <image>.tar
```

### Starting an exited container
```bash
docker ps -a #will display the exited container Id
docker start <container_id>
```


### copying things from and to docker container
```docker
#copy from docker to docker host
docker cp <container_id>:/path/to/copy /system/absolute/file/path
#copy from host to docker container
docker cp /system/absolute/file/path <container_id>:/path/to/copy
```

### Deattach Docker
```bash
^p^q
```

## NOTE:- Never attach to docker using attach command always use exec command and always exit docker using ^p^q
### Why??
Because there are many times we type exit to come out from a vm and same we don't remember that we are inside a docker and if have attached to docker using attach command and then type exit it ends up leaving the docker in exited state i.e stoping the docker container


### Removing unwanted objects
Below commands will always ask for confirmation or will promt before doing. you can either use -f or --force to skip the promt.
```bash
docker container prune
docker image prune
docker image prune -a # will remove images for which no container is up or attached to
docker network prune
docker volume prune
# WARNING! below command will remove:
#        - all stopped containers
#        - all networks not used by at least one container
#        - all dangling images
#        - all build cache
docker system prune
```



## Connecting to private docker registry
1. Create file daemon.json under /etc/docker/daemon.json
```json
{
    "debug":true,
    "insecure-registries" : [ "10.1.1.30" ]
}
```

2. Restart the docker daemon using
```bash
sudo service docker restart
#       OR
systemctl restart docker.service
```