# Some Gradle Basics
Gradle is a build and automation tool.

Gradle can automate the building, testing, publishing, deployment and more of software packages or other types of projects such as generated static websites, generated documentation or indeed anything else.

- Cross-platform, JVM based
- Implemented in Java

## Gradle Tasks

Attributes Available under gradle task task


```java
task printTask{
    descrption = ''
    group = ''
    
    doFirst{
        println 'Hello'
    }
    doLast{
        println 'World'
    }
}
```

```java
import java.DateTime.FormatStyle.*
task printDateTask{
    descrption = ''
    group = ''
    
    doLast{
        println { LocalDateTime.now()}
        println { LocalDateTime.now().format('MMM-dd-yyyy')}
        println { LocalDateTime.now().format(FormatStyle.MEDIUM)}
    }
}
```


```java

task execTask{
    descrption = ''
    group = ''
    
    doLast{
        println { LocalDateTime.now()}
        println { LocalDateTime.now().format('MMM-dd-yyyy')}
        println { LocalDateTime.now().format(FormatStyle.MEDIUM)}
    }
}
```



-m or --dry-run


All tasks have configuration block executed


### Gradle lifecycle
Three stages in processing a Gradle build:
1. Initialization
    - settings.gradle is processed, and any init scripts
    - also when gradle.properties file is read
2. Configuration
    - Gradle builds the directed acyclic graph and initializes all the tasks (all tasks are configured before any are executed)
3. Execution
    - run the tasks requested
    - This is when @TaskAction is executed, as well as any doFirst() and doLast() blocks


### Important available file properties
#### Important properties:

- projectDir (read-only) - the base directory of the project
- buildDir - the build output directory of the project
- rootDir (read-only) - the base directory of the root project (multi-project)
The buildDir is "$projectDir/build" by default.

In plugins, don't assume this. Use "$buildDir".

### Gradle dependsOn 
Configuration phase
Running phase

## Gradle Commands
```bash

# To see running daemons.
gradle --status to see running daemons.

# Generating a gradle wrapper:
gradle wrapper

# Print basic help information:
gradle help

# Print command line options:
gradle -?

# Print the available tasks in a project:
gradle tasks


# Build project and runs Tests
./gradlew clean build

# Run build and skip tests
./gradlew clean build -xTest


# Configure all taks and show list of available tasks
./gradlew tasks -all

# Runing a specifc task
./gradlew <task name>

# Can be used to dry run the task the task will actually not get executed
./gradlew -m <task name>
```

### Automatic imports for grovvy therefore imports for gradle as well
- java.lang
- java.util
- java.io
- java.net
- java.math
    - java.math.BigInteger
    - java.math.BigDecimal
- groovy.lang
- groovy.util
