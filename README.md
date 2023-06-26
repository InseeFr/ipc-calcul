# Module ipc-calcul
L’IPC est l’instrument de mesure de l’inflation. Il permet d’estimer, entre deux périodes données, la variation du niveau général des prix des biens et des services consommés par les ménages sur le territoire français. [Lien vers la définition de l'IPC](https://www.insee.fr/fr/metadonnees/source/serie/s1007).

Dans ce module on trouve les méthodes d'agrégation de l'IPC au niveau POSTE et supérieur de la Coicop (Classification des fonctions de consommation des ménages). [Lien vers la coicop](https://www.insee.fr/fr/metadonnees/definition/c1212).

Ce code est utilisé à partir de septembre 2023.

# Quick start
Il s'agit d'un module java 11 avec maven.

Pour récupérer le module
```
git clone https://github.com/InseeFr/ipc-calcul.git
```

Pour jouer les tests unitaires :
```
mvn test
```

Pour construire le module :
```
mvn clean package
```
