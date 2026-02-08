Parfait 👍
Voici **l’énoncé complet au format README.md**, prêt à être posé tel quel à la racine de ton projet.

Tu peux :

* le suivre comme sujet d’exercice
* le montrer à un recruteur
* t’en servir comme base de portfolio

---

````md
# 🧪 Gestionnaire de statistiques simple (Java)

## 🎯 Objectif

Développer un **gestionnaire de statistiques numériques** en Java, centré sur la logique métier.

Cet exercice vise à travailler :
- la manipulation des collections
- la logique métier
- la structuration du code
- la clarté des responsabilités

---

## ⏱️ Durée cible

⏳ **1h à 1h30**

---

## 🧩 Fonctionnalités attendues

### 1️⃣ Ajout de valeurs numériques

Le gestionnaire doit pouvoir recevoir plusieurs valeurs numériques (`double`).

```java
stats.addValue(10);
stats.addValue(20);
stats.addValue(30);
````

---

### 2️⃣ Calculs statistiques

Le gestionnaire doit être capable de fournir :

* le minimum
* le maximum
* la moyenne
* le nombre de valeurs

---

### 3️⃣ Export des statistiques

Les statistiques doivent pouvoir être exportées sous forme de texte formaté.

Exemple attendu :

```text
Count: 3
Min: 10
Max: 30
Average: 20.0
```

---

## 🧪 Jeux d’essai (obligatoires)

### 🔹 Cas 1 — valeurs simples

**Entrée**

```java
stats.addValue(10);
stats.addValue(20);
stats.addValue(30);
```

**Résultat attendu**

* Min = 10
* Max = 30
* Average = 20.0
* Count = 3

---

### 🔹 Cas 2 — valeurs décimales

**Entrée**

```java
stats.addValue(2.5);
stats.addValue(3.5);
```

**Résultat attendu**

* Min = 2.5
* Max = 3.5
* Average = 3.0
* Count = 2

---

### 🔹 Cas 3 — une seule valeur

**Entrée**

```java
stats.addValue(42);
```

**Résultat attendu**

* Min = 42
* Max = 42
* Average = 42.0
* Count = 1

---

### 🔹 Cas 4 — aucune valeur

**Entrée**

```java
StatsManager stats = new StatsManager();
```

**Comportement attendu**

Le comportement doit être **défini clairement par le développeur**, par exemple :

* lever une `IllegalStateException`
* retourner des `Optional`
* afficher un message explicite

⚠️ Le choix doit être **cohérent et assumé**.

---

## 📦 Contraintes techniques

* ❌ Pas d’interface graphique

* ❌ Pas de base de données

* ❌ Pas de framework externe

* ❌ Pas d’entrées utilisateur (`Scanner`, etc.)

* ✅ Java standard

* ✅ Utilisation d’une collection (`List<Double>` recommandée)

* ✅ Logique métier isolée

---

## 🏗️ Structure minimale attendue

```text
stats/
 ├─ StatsManager.java
 └─ Main.java (pour tests)
```

---

## 📌 API attendue

### Classe `StatsManager`

```java
public StatsManager();

public void addValue(double value);

public double getMin();
public double getMax();
public double getAverage();
public int getCount();

public String exportAsText();

public void reset(); // optionnel
```

---

## 🧠 Critères d’évaluation

* lisibilité du code
* nommage clair
* absence de duplication
* gestion des cas limites
* séparation des responsabilités

---

## 🚀 Extensions possibles (optionnelles)

* arrondir la moyenne
* export vers un fichier texte
* rendre la classe immuable
* ajouter des tests unitaires JUnit

---

## 📝 Remarque

La classe `StatsManager` ne doit contenir **aucune entrée/sortie console**.
Toute interaction utilisateur doit se faire via `Main`.

---
