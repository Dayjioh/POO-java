// Héritage
// Héros hérite de Personnage :
// - récupére tous ses attributs et méthodes. 
// - Ajoute ses propres caractéristiques. 

public class Heros extends Personnage {

    // Attributs propres au Héros, inexistants dans Personnage
    private String powerName;
    private int powerDamage;

    // Constructeur : appelle d'abord le constructeur parent via super()
    // puis initialise les attributs spécifiques au Héros
    public Heros(String name, int hp, int attack, String powerName, int powerDamage) {
        super(name, hp, attack);
        this.powerName = powerName;
        this.powerDamage = powerDamage;
    }

    // Getters : seule façon d'accéder aux attributs private depuis l'extérieur
    public String getPowerName() {
        return powerName;
    }

    public int getPowerDamage() {
        return powerDamage;
    }

    // POLYMORPHISME : redéfinition de attaquer() spécifique au Héros
    // Dégâts = attaque de base + bonus aléatoire entre 1 et 5
    @Override
    public int attaquer() {
        return getAttack() + (int)(Math.random() * 5) + 1;
    }

}