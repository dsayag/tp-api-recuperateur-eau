# Tp API - Récupérateur d'eau

## Le projet contient
- un projet Spring boot
- un paramétrage pour utiliser une base de données MySQL
- des modèles
- des repositories
- un model ErrorValidation
- une classe RestApplicationExceptionHandler qui permet de mettre en place notre système de validation personnalisé
- les controllers qui permettant de tester chaques routes de nos API avec par exemple Postman

#### UserController
- Récupérer la liste des utilisateurs
- Récupérer un utilisateur suivant son id
- Récupérer un utilisateur suivant sont adresse mail et son mot de passe.
- Créer un utilisateur
- Mettre à jour un utilisateur
- Supprimer un utilisateur

#### Résidences
- Récupérer la liste des résidences d’un utilisateur
- Récupérer une résidence suivant son id
- Créer une résidence
- Mettre à jour une résidence
- Supprimer une résidence

#### Cuves
- Récupérer la liste des cuves d’une résidence
- Récupérer une cuve suivant son id
- Créer une cuve
- Mettre à jour une cuve
- Supprimer une cuve

#### Données
- Récupérer la liste des données d’une cuve (prévoir une méthode dans le repository Donnee).
- Récupérer une donnée suivant son id
- Créer une donnée
- Mettre à jour une donnée
- Supprimer une donnée

#### Temps
- Récupérer la liste des 5 derniers jours de temps d’une résidence
- Créer un temps (non fait)
