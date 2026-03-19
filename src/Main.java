import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Heros hero = new Heros("Arthur", 100, 15, "Revers", 20, 3);
        Ennemi ennemi = new Ennemi("Orc", 800, 10);

        System.out.println(hero.getName() + " vs " + ennemi.getName());

        while (hero.getHp() > 0 && ennemi.getHp() > 0) {
            System.out.println("Que souhaitez vous faire ? ");
            System.out.println("1- Attaquer ");
            System.out.println("2- Pouvoir ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
<<<<<<< HEAD
                    attaquer(hero, ennemi);
                    break;
                case 2:
                    utiliserPouvoir(hero, ennemi);
=======
                    attack(hero, ennemi);
                    break;
                case 2:
                    usePower(hero, ennemi);
>>>>>>> 73178a6 (method & limit power usage to 3 charges)
                    break;
                default:
                    System.out.println("Action invalide !");
                    break;
            }

        }
        if (hero.getHp() > 0) {
            System.out.println(hero.getName() + " a gagné !");
        } else {
            System.out.println(ennemi.getName() + " a gagné !");
        }

        sc.close();
    }

<<<<<<< HEAD
    private static void attaquer(Heros hero, Ennemi ennemi) {
=======
    private static void attack(Heros hero, Ennemi ennemi) {
>>>>>>> 73178a6 (method & limit power usage to 3 charges)
        int heroAttack = hero.attaquer();
        int ennemiAttack = ennemi.attaquer();
        System.out.println(hero.getName() + " inflige " + heroAttack + " dégâts à " + ennemi.getName());
        ennemi.setHp(ennemi.getHp() - heroAttack);
        System.out.println(ennemi.getName() + " riposte et inflige " + ennemiAttack + " dégâts");
        hero.setHp(hero.getHp() - ennemiAttack);
        System.out.println(
                "HP — " + hero.getName() + " : " + hero.getHp() + " | " + ennemi.getName() + " : " + ennemi.getHp());
    }

<<<<<<< HEAD
    private static void utiliserPouvoir(Heros hero, Ennemi ennemi) {
        int heroPower = hero.power();
        int ennemiAttack = ennemi.attaquer();
        System.out
                .println(hero.getName() + " utilise " + hero.getPowerName() + " et inflige " + heroPower + " dégâts !");
        ennemi.setHp(ennemi.getHp() - heroPower);
        System.out.println(ennemi.getName() + " riposte et inflige " + ennemiAttack + " dégâts");
        hero.setHp(hero.getHp() - ennemiAttack);
        System.out.println(
                "HP — " + hero.getName() + " : " + hero.getHp() + " | " + ennemi.getName() + " : " + ennemi.getHp());
=======
    private static void usePower(Heros hero, Ennemi ennemi) {

        int heroPower = hero.power();
        int heroPowerCount = hero.getPowerCount();
        int ennemiAttack = ennemi.attaquer();
        if (heroPowerCount > 0) {
            hero.setPowerCount(hero.getPowerCount() - 1);

            System.out
                    .println(hero.getName() + " utilise " + hero.getPowerName() + " et inflige " + heroPower
                            + " dégâts !");
            ennemi.setHp(ennemi.getHp() - heroPower);
            System.out.println(ennemi.getName() + " riposte et inflige " + ennemiAttack + " dégâts");
            hero.setHp(hero.getHp() - ennemiAttack);
            System.out.println(
                    "HP — " + hero.getName() + " : " + hero.getHp() + " | " + ennemi.getName() + " : "
                            + ennemi.getHp());
        } else {
            System.out.println("Out of charge !");
        }
>>>>>>> 73178a6 (method & limit power usage to 3 charges)
    }
}