# Système de Gestion des Locations et des Biens Immobiliers

Un projet pour gérer les biens immobiliers (maisons, appartements…) et les locations associées.  

---

## 📑 Table des matières
1. [🧱 Technologies utilisées](#-technologies-utilisées)  
2. [📂 Structure du projet](#-structure-du-projet)  
3. [🚀 Fonctionnalités principales](#-fonctionnalités-principales)  
4. [⚙️ Installation & exécution](#️-installation--exécution-développement-local)  
5. [🧪 Tests](#-tests)  
6. [video demonstrative](#-video--demonstrative)  
 

---

## 🧱 Technologies utilisées
- Java 17  
- Spring Boot  
- Spring Data JPA / Hibernate  
- MySQL   
- Thymeleaf  
- Maven  

---

## 📂 Structure du projet

Control/

│── src/

│   ├── main/

│   │   ├── java/com/example/demo2/   # Code source Java (Controllers, Entities, Repositories, Services)

│   │   ├── resources/

│   │   │   ├── templates/            # Vues Thymeleaf (HTML)

│   │   │   ├── static/               # CSS / JS / Images

│   │   │   └── application.properties

│   └── test/                         # Tests unitaires et d’intégration

│
├── pom.xml                           # Configuration Maven

└── README.md



---

## 🚀 Fonctionnalités principales
- CRUD pour les biens immobiliers  
- CRUD pour les locations  
- Gestion de la relation Bien ↔ Location  
- Pages Thymeleaf pour l’UI  

---

## ⚙️ Installation & exécution (développement local)
1. Cloner le projet :  
   ```bash
   git clone https://github.com/Basmaelkak/Control.git
   cd Control
   
Configurer la BDD dans application.properties

Lancer:
mvn spring-boot:run

Accéder à http://localhost:8081

🧪 Tests:
mvn test

---

## Video demonstrative

https://github.com/user-attachments/assets/b09f0be1-98f7-4f21-9afe-ac98443813f6

