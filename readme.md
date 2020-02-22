Avoir un Mac/Linux OU Windows 10 PRO pour le temrinal shell / bash


Installation JDK Java 8 Stable (Maven intégré dans IntelliJ : non.) : https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html


Installation Intellij Idea https://www.jetbrains.com/idea/download/


Installation de Maven (même si déjà inclus dans IntelliJ) :https://maven.apache.org/download.cgi


Configuration Intellij Idea (ORM => HIBERNATE(via maven), Log(log4j via maven),JUnit via maven Extensions, Linter, etc…)🐳


Installation Docker: https://www.docker.com/ ( pour installation d’un mysql en local pour le dev ) 🙏


Installation Git : https://gitforfedora.org/

Pour un nouveau développeur : 


 - Configuration compte git (pour avoir les droit sur le repo)
 - Git clone le projet (git clone https://github.com/AntoineTohan/future-tracking-java.git)
 - Git add remote upstream (les repos remotes)
 - Git pull sur le projet
 - Apprendre par 💖 GitFlow
 
 

Si vous avez un terminal linux lancer ces commandes  :

```cd future-tracking-java```

```chmod +x ./prepare_env.sh```

```./prepare_env.sh```

Ce script réalisera pour vous les actions suivantes : Pull l'image docker mysql, démarrer mysql avec les bonnes informtions de configurations, importer le dump de base de donnée qui sert de jeu de données tests.

OU

Sinon lancer les commandes une par une :

```
docker pull mysql:5.7
docker run -p 3306:3306 --name dadcooking-db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=dadcooking -d mysql:5.7
cat dadcooking_dump.sql | docker exec -i dadcooking-db mysql -u root --password=password dadcooking
```


Ensuite lancer le projet Java dans votre IDE.


Pour mettre en place facilement la CI du project nous avons créées un docker-compose file qui démarre Sonar et Jenkins avec la configuration nécéssaire pour que ceux-ci puissent communiquer ensemble.


## Commandes utile :


Démarrer tous les services avec le Docker-compose : ```docker-compose up -d```


Mettre en pause les containers avec : ```docker-compose stop```


Supprimer tous les services avec le Docker-compose : **Attention la suppression vous fera perdre toute votre configuration ```docker-compose down```**
