 **🏥 Système de Gestion Hospitalière - HOSPITAL-MANAGEMENT**


 **📋 Table des Matières**
- [Aperçu du Projet](#-aperçu-du-projet)
- [Fonctionnalités](#-fonctionnalités)
- [Architecture Technique](#-architecture-technique)
- [Installation](#-installation)
- [Utilisation](#-utilisation)
- [Structure du Projet](#-structure-du-projet)
- [Design Patterns](#-design-patterns)
- [Diagrammes UML](#-diagrammes-uml)
- [Tests](#-tests)
- [Documentation](#-documentation)
- [Contributeurs](#-contributeurs)
- [Licence](#-licence)

## **🎯 Aperçu du Projet**

**Hospital Management System** est une application Java complète de gestion hospitalière conçue pour automatiser et optimiser les processus médicaux. Ce système répond aux besoins des établissements de santé modernes en intégrant la gestion des patients, du personnel, des rendez-vous, des stocks et de la facturation.

### **Caractéristiques Principales**
- ✅ Gestion complète des patients et dossiers médicaux
- ✅ Système de rendez-vous intelligent avec agendas
- ✅ Module d'urgences avec triage prioritaire
- ✅ Gestion de pharmacie avec alertes automatiques
- ✅ Facturation complexe avec assurances
- ✅ Interface multithreadée et concurrente
- ✅ Persistance des données complète

### **Public Cible**
- Hôpitaux et cliniques
- Centres de santé
- Cabinets médicaux
- Établissements de recherche médicale

## **✨ Fonctionnalités**

### **🧑‍⚕️ Gestion du Personnel**
- Création et gestion des profils (Médecins, Infirmiers, Pharmaciens, Administrateurs)
- Gestion des horaires et shifts
- Suivi des disponibilités pour consultations
- Historique des activités par personnel

### **👥 Gestion des Patients**
- Dossiers patients complets (informations, antécédents, allergies)
- Historique médical chronologique
- Dossier d'urgence avec contacts
- Gestion des assurances et mutuelles

### **📅 Système de Rendez-vous**
- Prise de rendez-vous avec vérification des disponibilités
- Types : Consultation, Urgence, Chirurgie, Suivi
- Gestion des agendas (créneaux de 30 min)
- Confirmation/annulation/report automatisés
- Système de rappels (24h avant)

### **🏥 Urgences**
- File d'attente avec système de triage (5 niveaux de priorité)
- Affectation automatique des médecins de garde
- Enregistrement rapide des patients
- Suivi en temps réel

### **💊 Gestion Pharmacie**
- Inventaire complet avec dates d'expiration
- Prescription et délivrance de médicaments
- Alertes automatiques (stock faible, péremption)
- Traçabilité des médicaments contrôlés
- Commandes automatiques

### **💰 Facturation**
- Calcul automatique des factures
- Application des couvertures d'assurance
- Gestion des paiements partiels
- Génération de reçus détaillés
- Historique financier par patient

## **🛠 Architecture Technique**

### **Technologies Utilisées**
- **Langage** : Java 11+
- **Build Tool** : Maven
- **Interface** : JavaFX (version moderne)
- **Base de données** : SQLite avec JDBC
- **Rapports** : JasperReports pour PDF
- **Tests** : JUnit 5, Mockito
- **Documentation** : JavaDoc

### **Architecture Logicielle**
```
┌─────────────────────────────────────────┐
│           COUCHE PRÉSENTATION           │
│  JavaFX Controllers / FXML Views        │
└─────────────────────────────────────────┘
┌─────────────────────────────────────────┐
│           COUCHE SERVICE                │
│  Business Logic / Validation            │
└─────────────────────────────────────────┘
┌─────────────────────────────────────────┐
│           COUCHE PERSISTANCE            │
│  DAO Pattern / Repository               │
└─────────────────────────────────────────┘
┌─────────────────────────────────────────┐
│           COUCHE DONNÉES                │
│  SQLite Database / File Storage         │
└─────────────────────────────────────────┘
```

## **🚀 Installation**

### **Prérequis**
- Java JDK 11 ou supérieur
- Maven 3.6+
- SQLite
- 4GB RAM minimum
- 500MB d'espace disque



## **📖 Utilisation**

### **Profils Utilisateurs**

#### **Administrateur**
- Gestion des comptes utilisateurs
- Configuration du système
- Génération de rapports
- Supervision des activités

#### **Médecin**
- Consultation des dossiers patients
- Prise de rendez-vous
- Prescription de médicaments
- Saisie des diagnostics

#### **Infirmier**
- Suivi des patients hospitalisés
- Administration des traitements
- Gestion des chambres
- Alertes urgentes

#### **Pharmacien**
- Gestion des stocks
- Validation des prescriptions
- Commandes de médicaments
- Contrôle des dates d'expiration

### **Workflows Principaux**

#### **Prise de Rendez-vous**
1. Sélectionner un patient
2. Choisir un médecin et une spécialité
3. Vérifier les disponibilités
4. Confirmer le créneau
5. Envoyer la confirmation

#### **Gestion d'Urgence**
1. Enregistrement rapide du patient
2. Évaluation du niveau de triage
3. Affectation à une salle d'urgence
4. Notification des médecins disponibles
5. Suivi du traitement
   réaliser par Amina Oujaa|

