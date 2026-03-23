import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ArrayList : tableau dynamique, taille variable contrairement aux tableaux
        // classiques
        ArrayList<Ennemi> ennemis = new ArrayList<>();
        ennemis.add(new Ennemi("Goblin", 50, 7));
        ennemis.add(new Ennemi("Orc", 80, 10));
        ennemis.add(new Ennemi("Dragon", 200, 25));

        Scanner sc = new Scanner(System.in);

        Heros hero = new Heros("Arthur", 100, 15, "Revers", 20, 3);

        // for i : on démarre à l'index retourné par load() pour reprendre depuis la
        // sauvegarde
        // si pas de sauvegarde, load() retourne 0 et on commence depuis le début
        for (int i = load(hero, ennemis); i < ennemis.size(); i++) {

            System.out.println(hero.getName() + " vs " + ennemis.get(i).getName());

            // Boucle de combat : continue tant que les deux combattants sont en vie
            while (hero.getHp() > 0 && ennemis.get(i).getHp() > 0) {
                System.out.println("Que souhaitez vous faire ? ");
                System.out.println("1- Attaquer ");
                System.out.println("2- Pouvoir ");
                System.out.println("3- Sauvegarder ");

                int choix = -1;
                // try/catch : protège contre une saisie invalide (lettre au lieu d'un chiffre)
                // sc.nextLine() vide le buffer du Scanner pour éviter une boucle infinie
                try {
                    choix = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Veuillez saisir un chiffre ");
                    sc.nextLine();
                }

                // Conversion du int saisi en constante Enum
                // Si le chiffre ne correspond à aucune action, actionNumber reste INVALIDE
                Action actionNumber = Action.INVALIDE;
                for (Action action : Action.values()) {
                    if (action.getAction() == choix) {
                        actionNumber = action;
                    }
                }

                // Switch sur l'Enum : plus lisible et sécurisé qu'un switch sur int
                switch (actionNumber) {
                    case ATTACK:
                        attack(hero, ennemis.get(i));
                        break;
                    case POWER:
                        usePower(hero, ennemis.get(i));
                        break;
                    case SAVE:
                        save(hero, ennemis.get(i));
                        break;
                    case INVALIDE:
                        System.out.println("Action invalide !");
                        break;
                }
            }
        }

        // Résultat final après tous les combats
        if (hero.getHp() > 0) {
            System.out.println(hero.getName() + " a gagné !");
        } else {
            System.out.println(hero.getName() + " a perdu !");
        }

        sc.close();
    }

    // Attaque classique : le héros et l'ennemi s'échangent des dégâts
    private static void attack(Fighter attacker, Fighter target) {
        int attackerDamage = attacker.attaquer();
        int targetDamage = target.attaquer();
        System.out.println(attacker.getName() + " inflige " + attackerDamage + " dégâts à " + target.getName());
        target.takeDamage(attackerDamage);
        System.out.println(target.getName() + " riposte et inflige " + targetDamage + " dégâts");
        attacker.takeDamage(targetDamage);
        System.out.println("HP — " + attacker.getName() + " : " + attacker.getHp() + " | " + target.getName() + " : "
                + target.getHp());
    }

    // Pouvoir spécial : inflige plus de dégâts mais limité en utilisations
    // L'ennemi riposte même si le pouvoir est épuisé
    private static void usePower(Heros attacker, Fighter target) {
        int power = attacker.power();
        int powerCount = attacker.getPowerCount();
        int targetDamage = target.attaquer();
        if (powerCount > 0) {
            attacker.setPowerCount(attacker.getPowerCount() - 1);
            System.out.println(
                    attacker.getName() + " utilise " + attacker.getPowerName() + " et inflige " + power + " dégâts !");
            target.takeDamage(power);
            System.out.println(target.getName() + " riposte et inflige " + targetDamage + " dégâts");
            attacker.takeDamage(targetDamage);
            System.out.println("HP — " + attacker.getName() + " : " + attacker.getHp() + " | " + target.getName()
                    + " : " + target.getHp());
        } else {
            System.out.println("Out of charge !");
        }
    }

    // Sauvegarde l'état du jeu dans save.txt
    // Format : "HP — [hero] : [hp] Power : [charges] | [ennemi]"
    // try-with-resources : ferme automatiquement le fichier après écriture
    private static void save(Heros hero, Ennemi ennemi) {
        try (FileWriter save = new FileWriter("save.txt")) {
            save.write("HP — " + hero.getName() + " : " + hero.getHp() + " Power : " + hero.getPowerCount() + " | "
                    + ennemi.getName());
            System.out.println("Sauvegarde effectuée !");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Charge la sauvegarde et retourne l'index de l'ennemi à affronter
    // Lit save.txt, extrait le nom de l'ennemi après "| " et cherche son index dans
    // la liste
    // Retourne 0 si pas de sauvegarde ou fichier introuvable → repart depuis le
    // début
    private static int load(Heros hero, ArrayList<Ennemi> ennemis) {
        try (BufferedReader load = new BufferedReader(new FileReader("save.txt"))) {
            String line;
            while ((line = load.readLine()) != null) {
                for (int i = 0; i < ennemis.size(); i++) {
                    // split sur "| " pour isoler le nom de l'ennemi en fin de ligne
                    String[] parts = line.split("\\| ");
                    String ennemiName = parts[parts.length - 1];
                    String[] words = line.split(" ");
                    int hp = Integer.parseInt(words[4]);
                    int power = Integer.parseInt(words[7]);

                    // equals() et non == pour comparer des String en Java
                    if (ennemis.get(i).getName().equals(ennemiName)) {
                        hero.setHp(hp);
                        hero.setPowerCount(power);
                        return i;
                    }
                }
            }
        } catch (IOException e) {
            // Fichier absent = pas de sauvegarde, comportement normal au premier lancement
            System.out.println("Error reading file.");
        }
        return 0;
    }
}