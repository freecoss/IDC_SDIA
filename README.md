# Injection des Dépendances & Inversion de Contrôle (IoC)

Ce projet Java/Maven illustre les concepts fondamentaux de **l'Inversion de Contrôle (IoC)** et de **l'Injection des Dépendances (DI)**. Ce sont des principes clés pour créer des applications avec un **couplage faible**.

Il démontre la progression d'une architecture à fort couplage vers une architecture à faible couplage utilisant les fonctionnalités standard de Java puis l'implémentation du framework Spring.

## 📁 Structure du Projet

L'application est structurée selon une architecture en couches classique :
- **Couche DAO** (`net.enset.dao` / `net.enset.ext`) : Gère l'accès aux données. Elle contient une interface `IDao` et ses implémentations (`DaoImpl`, `DaoImplV2`).
- **Couche Métier** (`net.enset.metier`) : Contient la logique métier. Elle s'appuie sur la couche DAO uniquement à travers son interface `IDao`, respectant ainsi le principe de couplage faible. (Interface `IMetier` et classe `MetierImpl`).
- **Couche Présentation** (`net.enset.presentation`) : Contient plusieurs classes `main` pour tester les différentes façons d'instancier, lier et injecter les dépendances.

## 🚀 Approches Testées

Le package `net.enset.presentation` explore quatre méthodes pour relier les classes entre elles :

### 1. Instanciation Statique (`Presentation1.java`)
- Démonstration de l'instanciation directe avec le mot-clé `new`.
- **Inconvénient** : Couplage fort entre les classes de la présentation et les implémentations spécifiques (métier/DAO). Le changement d'une implémentation demande de modifier et recompiler le code.

### 2. Instanciation Dynamique via Réflection (`Presentation2.java`)
- Les noms des classes sont lus dynamiquement à partir d'un fichier externe (`config.txt`).
- L'instanciation est faite à l'aide de l'API de Réflection (`Class.forName(...)`, `newInstance()`).
- Permet un véritable **couplage faible** ; un changement d'implémentation nécessite seulement de modifier `config.txt` sans retoucher ni recompiler le code.

### 3. Injection avec Framework Spring (Version XML) (`PresSpringXml.java`)
- Configuration des *Beans* et de leurs dépendances via un fichier extérieur `config.xml`.
- Le contexte Spring (`ClassPathXmlApplicationContext`) se charge de créer, configurer et lier nos composants automatiquement.

### 4. Injection avec Framework Spring (Version Annotations) (`PresSpringAnnotation.java`)
- Implémentation moderne basée sur les annotations.
- Les classes sont annotées (`@Component`, `@Service`, ou `@Repository`...).
- Les dépendances sont injectées soit par le constructeur, soit avec l'annotation `@Autowired`.
- Le scan des packages remplace la configuration XML.

## 🛠️ Technologies Utilisées
- **Java** 21
- **Maven** pour la gestion de la structure et des dépendances (`pom.xml` communiquant avec les repositories distants)
- **Spring Framework** (Core, Context, Beans version 6.2.16)
