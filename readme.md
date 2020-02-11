Avoir un Mac/Linux OU Windows 10 PRO pour le temrinal shell / bash

Installation JDK Java 8 Stable (Maven intégré dans IntelliJ : non.) : https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Installation Intellij Idea https://www.jetbrains.com/idea/download/

Installation de Maven (même si déjà inclus dans IntelliJ) :https://maven.apache.org/download.cgi

Configuration Intellij Idea (ORM => HIBERNATE(via maven), Log(log4j via maven),JUnit via maven Extensions, Linter, etc…)🐳

Installation Docker: https://www.docker.com/ ( pour installation d’un mysql en local pour le dev ) 🙏

Installation Git : https://gitforfedora.org/

 - Configuration compte git (pour avoir les droit sur le repo)
 - Git clone le projet (git clone https://github.com/AntoineTohan/future-tracking-java.git)
 - Git add remote upstream (les repos remotes)
 - Git pull sur le projet
 - Apprendre par 💖 GitFlow

Si vous avez un terminal linux lancer ces commandes  :

```cd future-tracking-java```

```chmod +x ./prepare_env.sh```

```./prepare_env.sh```

OU

Sinon lancer ces deux commandes :

```docker pull mysql:5.7 && docker run -p 3306:3306 --name dadcooking-db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=dadcooking -d mysql:5.7```

Ensuite lancer le projet Java dans votre IDE.


Pour les devellopeurs et les deploiements de platfrome de dev pour mettre en place la CI il suffit du server Jenkins et Sonarqube. 

Pour les lancer facilement avec docker et qu'ils puissent communiquer nous avons mis en place un docker-compose file qui démarre les deux services.

Démarrer tous les services avec le Docker-compose : docker-compose up -d

Mettre en pause les containers avec : ```docker-compose stop```

Supprimer tous les services avec le Docker-compose : **Attention la suppression vous fera perdre toute votre configuration ```docker-compose down```**
