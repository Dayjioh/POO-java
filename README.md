# RPG Console Java

## 🎮 Comment jouer
1. Lancer `Main.java`
2. Choisir une action à chaque tour :
   - `1` — Attaquer
   - `2` — Utiliser son pouvoir (limité à 3 charges)
   - `3` — Sauvegarder la partie
3. Battre les 3 ennemis : Goblin → Orc → Dragon
4. La partie se charge automatiquement depuis `save.txt` au lancement

---

## 📚 Concepts vus

### POO
- **Classe abstraite** — `Personnage` définit le contrat commun
- **Héritage** — `Heros` et `Ennemi` étendent `Personnage`
- **Encapsulation** — attributs `private` accessibles via getters/setters
- **Polymorphisme** — `attaquer()` redéfini différemment dans chaque sous-classe
- **Interface** — `Fighter` implémentée par `Heros` et `Ennemi`

### Java
- `Enum` — `Action` : ATTACK, POWER, SAVE, INVALIDE
- `ArrayList` — liste dynamique d'ennemis
- `try/catch` — protection contre les saisies invalides
- `try-with-resources` — `FileWriter` et `BufferedReader`
- `FileWriter` — écriture dans `save.txt`
- `BufferedReader` + `FileReader` — lecture de `save.txt`
- `Integer.parseInt()` — conversion `String` → `int`
- `split()` + `equals()` — parsing et comparaison de `String`
- `Math.random()` — dégâts aléatoires
- `Scanner` — saisie utilisateur

---

## 🚀 Améliorations prévues

### Boutique
- [ ] Système de gold gagné après chaque combat
- [ ] Acheter une nouvelle arme (augmente l'attaque)
- [ ] Acheter de la nourriture (restaure des HP)

### Sauvegarde
- [ ] Effacer une sauvegarde existante
- [ ] Recommencer une partie depuis le début
- [ ] Afficher les infos de la sauvegarde au chargement
- [ ] Sauvegarder les HP de l'ennemi en cours

### Gameplay
- [ ] Pouvoir fuir un combat
- [ ] Plusieurs pouvoirs différents par héros
- [ ] Système de niveaux et XP après chaque victoire
- [ ] Boss final avec mécaniques spéciales

### Structure
- [ ] Design Pattern Factory pour créer les ennemis
- [ ] Plusieurs héros jouables au choix