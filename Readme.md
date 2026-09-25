
# Microservice de gestion des comptes bancaires
Dans le cadre de la mise en pratique des notions étudiées en **architecture microservices**, nous avons commencé par la réalisation d'un **microservice de gestion de comptes bancaires** avec **Spring Boot**.

L'objectif de ce projet est de mettre en pratique progressivement les différents concepts et technologies nécessaires à la conception d'un microservice, en commençant par la création d'une API REST, puis en ajoutant différentes fonctionnalités et couches à l'application.

Ce microservice permet de gérer des comptes bancaires à travers plusieurs types d'API :

- **REST API classique**
- **Spring Data REST**
- **GraphQL API**

![img.png](img.png)
# Étapes de réalisation

## 1. Création du projet Spring Boot

La première étape consiste à créer un projet **Spring Boot** avec les dépendances nécessaires au développement du microservice.

###  Dépendances utilisées

![img_1.png](img_1.png)


---

## 2. Création de l'entité JPA `Compte`

L'entité `BankAccount` représente un compte bancaire dans l'application.

Elle est associée à une table dans la base de données grâce à **JPA**.

###  Structure de l'entité

![img_2.png](img_2.png)

## 3. Création de l'interface `CompteRepository`

Pour accéder aux données de l'entité `BankAccount`, une interface `BankAccountRepository` est créée.

Elle hérite de `JpaRepository`, ce qui permet de bénéficier automatiquement des principales opérations **CRUD**.


![img_3.png](img_3.png)

## 4. Test de la couche DAO

La couche **DAO (Data Access Object)** est ensuite testée afin de vérifier que la communication entre l'application et la base de données fonctionne correctement.

![img_4.png](img_4.png)
