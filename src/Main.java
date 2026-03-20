import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // tableau dynamique add pour ajouter des valeurs et contient aussi d'autres
        // methodes.
        ArrayList<Ennemi> ennemis = new ArrayList<>();
        ennemis.add(new Ennemi("Orc", 80, 10));
        ennemis.add(new Ennemi("Goblin", 50, 7));
        ennemis.add(new Ennemi("Dragon", 200, 25));

        Scanner sc = new Scanner(System.in);

        Heros hero = new Heros("Arthur", 100, 15, "Revers", 20, 3);

        for (Ennemi ennemi : ennemis) {
            System.out.println(hero.getName() + " vs " + ennemi.getName());

            while (hero.getHp() > 0 && ennemi.getHp() > 0) {
                System.out.println("Que souhaitez vous faire ? ");
                System.out.println("1- Attaquer ");
                System.out.println("2- Pouvoir ");
                int choix = sc.nextInt();
                Action actionNumber = Action.INVALIDE;
                for (Action action : Action.values()) {
                    if (action.getAction() == choix) {
                        actionNumber = action;
                    }
                }
                switch (actionNumber) {
                    case ATTACK:
                        attack(hero, ennemi);
                        break;
                    case POWER:
                        usePower(hero, ennemi);
                        break;
                    case INVALIDE:
                        System.out.println("Action invalide !");
                        break;
                }

            }
        }
        if (hero.getHp() > 0) {
            System.out.println(hero.getName() + " a gagné !");
        } else {
            System.out.println(hero.getName() + " a perdu !");
        }

        sc.close();

    }

    private static void attack(Heros hero, Ennemi ennemi) {
        int heroAttack = hero.attaquer();
        int ennemiAttack = ennemi.attaquer();
        System.out.println(hero.getName() + " inflige " + heroAttack + " dégâts à " + ennemi.getName());
        ennemi.takeDamage(heroAttack);
        System.out.println(ennemi.getName() + " riposte et inflige " + ennemiAttack + " dégâts");
        hero.takeDamage(ennemiAttack);
        System.out.println(
                "HP — " + hero.getName() + " : " + hero.getHp() + " | " + ennemi.getName() + " : " + ennemi.getHp());
    }

    private static void usePower(Heros hero, Ennemi ennemi) {

        int heroPower = hero.power();
        int heroPowerCount = hero.getPowerCount();
        int ennemiAttack = ennemi.attaquer();
        if (heroPowerCount > 0) {
            hero.setPowerCount(hero.getPowerCount() - 1);

            System.out
                    .println(hero.getName() + " utilise " + hero.getPowerName() + " et inflige " + heroPower
                            + " dégâts !");
            ennemi.takeDamage(heroPower);
            System.out.println(ennemi.getName() + " riposte et inflige " + ennemiAttack + " dégâts");
            hero.takeDamage(ennemiAttack);
            System.out.println(
                    "HP — " + hero.getName() + " : " + hero.getHp() + " | " + ennemi.getName() + " : "
                            + ennemi.getHp());
        } else {
            System.out.println("Out of charge !");
        }
    }

}