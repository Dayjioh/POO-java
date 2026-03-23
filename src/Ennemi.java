public class Ennemi extends Personnage implements Fighter {

    // Constructeur : appelle d'abord le constructeur parent via super()
    public Ennemi(String name, int hp, int attack) {
        super(name, hp, attack);
    }

    // POLYMORPHISME : redéfinition de attaquer() spécifique au Héros
    // Dégâts = attaque de base + bonus aléatoire entre 1 et 3
    @Override
    public int attaquer() {
        return getAttack() + (int) (Math.random() * 3) + 1;
    }

}