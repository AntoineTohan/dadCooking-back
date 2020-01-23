AVOIR UN MAC/LINUX OU W10 PRO Installation JDK Java 8 Stable (Maven intégré dans IntelliJ : non.) : https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Installation Intellij Idea https://www.jetbrains.com/idea/download/

Installation de Maven (même si déjà inclus dans IntelliJ) :https://maven.apache.org/download.cgi

Configuration Intellij Idea (ORM => HIBERNATE(via maven), Log(log4j via maven),JUnit via maven Extensions, Linter, etc…)🐳

Installation Docker: https://www.docker.com/ ( pour installation d’un mysql en local pour le dev ) 🙏

Installation Git : https://gitforfedora.org/

 - Configuration compte git (pour avoir les droit sur le repo)
 - Git clone le projet (git clone https://github.com/AntoineTohan/DadCooking-)
 - Git add remote upstream (les repos remotes)
 - Git pull sur le projet
 - Apprendre par 💖 GitFlow

Installation container mysql et configuration ports/volumes

```docker pull mysql```

Create mysql container

```docker run -p 3306:3306 --name dadcooking-db -e MYSQL_ROOT_PASSWORD=password -d mysql:5.7```

Connect to the console

```docker exec -it dadcooking-db mysql -uroot -ppassword```


If first time u launch project : Create DATABASE

```CREATE DATABASE dadcooking;```
```USE dadcooking;```

And launch the spring boot project

