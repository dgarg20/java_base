# Useful Git Commands

## cloning the remote repository
```bash
git clone <repo_link>
```

## Initalize the remote repository
```bash
git init
```

## show all local branches
```bash
git branch
```

## git fetch all branches
```bash
git fetch --all
```

## Create a new branch
```bash
git branch -b <branch name>
#creating new branch and moving to new branch
git checkout -b <branch name>
#short version
gco -b <branch_name>
```

## remove all uncommited changes from the branch
```bash
git checkout .
#OR
gco .
```

## pull upstream changes for the current branch
```bash
ggpull
#OR
git pull <upstream> <branch_name>
# example
git pull origin master
```



## cloning the remote repository
```bash
git remote show origin
```

## cloning the remote repository
```bash
git remote add upstream <URL>
```

## cloning the remote repository

```bash
git commit
```

## cloning the remote repository
```bash
git commit -am"message goes here"
```

## cloning the remote repository
```bash
git stash
```

## cloning the remote repository
```bash
git stash pop 
```

## cloning the remote repository
```bash
git stash drop
git stash drop <stash_id>
git stash clear
```

## cloning the remote repository
```bash
git stash list
```

## cloning the remote repository
```bash
git stash show  
```


## cloning the remote repository
```bash
git reset 
```

## cloning the remote repository
```bash
git reset hard <commit-id> 
```

## cloning the remote repository
```bash
git reset head 
```

## cloning the remote repository
```bash
git reset 
```


## cloning the remote repository
```bash
git rebase 
```


## cloning the remote repository
```bash
git rebase -i 
```

## cloning the remote repository
```bash
gcp <commit -id>
git cherry-pick <commit-id> 
```

## cloning the remote repository
```bash
# below only pushes current branch
git push
# OR Push some other branch
git push <> <branch>
```

## cloning the remote repository
```bash
git merge <branch> 
```

## git pull other branch changes in current branch 
It will pull from upstream and also try to merge the changes to the current branch
```bash
git pull <upstream> <branch name>
```


## See commit logs in the branches 
It will pull from upstream and also try to merge the changes to the current branch
```bash
# To show the commit logs of current branch
git log
# To check the commit logs of other branch
git log <branch name>
```

## Removing staged changes i.e un staging the changes

## Removing dile changes except some file

## storing git credentials
```bash
git config credential.helper store
```

