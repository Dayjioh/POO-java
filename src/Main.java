import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Heros hero = new Heros("Arthur", 100, 15, "Revers", 20);
        Ennemi ennemi = new Ennemi("Orc", 35, 10);

        System.out.println(hero.getName() + " vs " + ennemi.getName());

        while (hero.getHp() > 0 && ennemi.getHp() > 0) {
            System.out.println("Que souhaitez vous faire ? ");
            System.out.println("1- Attaquer ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    System.out.println(hero.getName() + " attaque " + ennemi.getName());
                    ennemi.setHp(ennemi.getHp() - hero.getAttack());
                    System.out.println(ennemi.getName() + " riposte " + hero.getName());
                    hero.setHp(hero.getHp() - ennemi.getAttack());
                    System.out.println(hero.getName() + " : " + hero.getHp());
                    System.out.println(ennemi.getName() + " : " + ennemi.getHp());

                    break;

                default:
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

}