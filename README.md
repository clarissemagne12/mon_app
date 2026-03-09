# 1.les acteurs:

   
.utilisateur et l'administrateur
# fonctionnalites:
3. creer un compte
4. se connecter
5. creer une tache
6. modifier une tache
7. supprimer une tache
8. marquer une tache comme terminee
9. voir les taches

# contrainte tecniques:
api rest
authentification securisee
base de donnees relationnelle
docker pour conteneuriser
CI/CD POUR pour automatiser les tests
# modelisation:
utilisateurs(id,namenemailnpassword)
tache(id, title,description,status,user_id)
# strucutre Rest de l'api
post /api/taches creer une tache
get /statut/{statut}  // Récupérer les tâches par statut
get /user/{userId}   Récupérer les tâches par utilisateur
delete /{id} supprimer une tache
put /{id} mettre a jour une tache
get /{id} recuperer une tache


post /api/utilisateurs creer une utilisateur
get /email/{email}  // Récupérer les utilisateur par email
get /user/{userId}   Récupérer les tâches par utilisateur
delete /{id} supprimer une utilisateur
put /{id} mettre a jour une utilisateur
get /{id} recuperer une utilisateur
# code reponse
2OO //succes
201 //creation
400 //erreur requete
401 // non autoriser
404 //ressource non trouvée
500 // erreur serveur
# proposition d'architecture
structure 
conntrollers 
    tacheController
    utilisateursController
entities
    utilisateurs
    tache
services
    utilisateursService
    tacheService
tachei
utilisateursi
# justification
 princie solid
separation des responsabilites
clean code
