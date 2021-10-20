## Important Linux Commands


### echo command
```bash
echo "hello how are you"
```

printing the value of a variable
```bash
echo $a_value
```

writing to a file 
```bash
echo "hello how are you" > abc.txt
```

Appending at the end of the file
```bash
echo "hello how are you" >> abc.txt
```

### export command to set a bash variable command
```bash
export a_value=10
```

### printing current date time
```bash
datetime
```

### ls command
```bash
ls
```

### ls command
```bash
ls -lrth
```

### ls command
```bash
ls -ltr
```

### make a new directory movies
```bash
mkdir movies
```

change directory to movies
```bash
cd movies
```

Move to parent directory of current directory
```bash
cd ..
```

### ls command
```bash
cd ../movies
```

### ls command
```bash
tree
```

### ls command
```bash
lsof -i:3306
```

### ls command
```bash
ps
```

### ls command
```bash
ps aux | grep
```

### ls command
```bash
ps -ef | grep
```

### ls command
```bash
top
```

### ls command
```bash
df -h
```

### ls command
```bash
du -h
```

### ls command
```bash
du -h *
```

### ls command
```bash
apt-get update
```

### ls command
```bash
apt-get upgrade
```

### ls command
```bash
apt-get install 
```
### ls command
```bash
apt-get install --yes --allow-unauthenticated <package name> 
```

### List all the disk on system
```bash
lsblk
```

### Find current OS
```bash
lsb_release -c
```

OR

```bash
cat /etc/issue
```

```bash
cat /etc/os-release
```

```bash
hostnamectl
```


### ls command
```bash
cp  /home/deepanshu/abc.txt .
```

### ls command
```bash
cp  /home/deepanshu/abc.txt /home/deepanshu/personel
```

### ls command
```bash
scp deepanshu@10.12.1.2: /home/deepanshu/abc.txt . 
```

### ls command
```bash
grep hello abc.txt 
```

### ls command
```bash
grep hello -a 5 -b 10 abc.txt
```

### ls command
```bash
grep hello -c 5 abc.txt 
```

### ls command
```bash
tail -f app.log 
```

### ls command
```bash
tail -100f app.log 
```

### ls command
```bash
tail -100f app.log  | grep hello
```

```bash

```
