
# Microservice de gestion des comptes bancaires
Dans le cadre de la mise en pratique des notions étudiées en **architecture microservices**, nous avons commencé par la réalisation d'un **microservice de gestion de comptes bancaires** avec **Spring Boot**.

L'objectif de ce projet est de mettre en pratique progressivement les différents concepts et technologies nécessaires à la conception d'un microservice, en commençant par la création d'une API REST, puis en ajoutant différentes fonctionnalités et couches à l'application.

Ce microservice permet de gérer des comptes bancaires à travers plusieurs types d'API :

- **REST API classique**
- **Spring Data REST**
- **GraphQL API**

![img.png](images/img.png)
# Étapes de réalisation

## 1. Création du projet Spring Boot

La première étape consiste à créer un projet **Spring Boot** avec les dépendances nécessaires au développement du microservice.

###  Dépendances utilisées

![img_1.png](images/img_1.png)


---

## 2. Création de l'entité JPA `Compte`

L'entité `BankAccount` représente un compte bancaire dans l'application.

Elle est associée à une table dans la base de données grâce à **JPA**.

###  Structure de l'entité

![img_2.png](images/img_2.png)

## 3. Création de l'interface `CompteRepository`

Pour accéder aux données de l'entité `BankAccount`, une interface `BankAccountRepository` est créée.

Elle hérite de `JpaRepository`, ce qui permet de bénéficier automatiquement des principales opérations **CRUD**.


![img_3.png](images/img_3.png)

## 4. Test de la couche DAO

La couche **DAO (Data Access Object)** est ensuite testée afin de vérifier que la communication entre l'application et la base de données fonctionne correctement.

![img_4.png](images/img_4.png)
![img.png](images/img5.png)

## 5. Création du Web Service RESTful

Après avoir mis en place l'entité `BankAccount` et le `BankAccountRepository`, l'étape suivante consiste à créer un **Web Service RESTful** permettant aux clients externes de gérer les comptes bancaires.

Pour cela, un contrôleur REST est créé à l'aide de l'annotation `@RestController`.

    ![img_5.png](img_5.png)
   ![img_6.png](images/img_6.png)

`
## 6. Test du microservice avec Postman

Après la création du Web Service REST, le microservice est testé à l'aide de **Postman** afin de vérifier le bon fonctionnement des différentes opérations CRUD.

###  Tests réalisés

Les différentes opérations testées sont :

| Méthode HTTP | Endpoint                 | Description |
|---|--------------------------|---|
| `GET` | `/api/bankAccounts`      | Récupérer tous les comptes |
| `GET` | `/api/bankAccounts/{id}` | Récupérer un compte par son identifiant |
| `POST` | `/api/bankAccounts`      | Créer un nouveau compte |
| `PUT` | `/api/bankAccounts/{id}` | Modifier un compte |
| `DELETE` | `/api/bankAccounts/{id}`      | Supprimer un compte |

###  Création d'un compte

![img_10.png](images/img_10.png)

### Récupération des comptes

![img_8.png](images/img_8.png)

###  Récupération d'un compte


![img_7.png](images/img_7.png)

###  Modification d'un compte

![img_3.png](images/img_12.png)
###  Suppression d'un compte

![img_4.png](images/img_9.png)