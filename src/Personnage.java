
// Classe
// ABSTRACTION + ENCAPSULATION
// Classe abstraite : définit le contrat commun à tous les personnages.
// Ne peut pas être instanciée directement (new Personnage() est interdit).
public abstract class Personnage {

    // attributs
    // ENCAPSULATION : private = inaccessible depuis l'extérieur
    // On ne peut lire ou modifier ces valeurs que via les getters/setters
    private String name;
    private int hp;
    private int attack;

    // Constructeur
    // Constructeur : appelé par les sous-classes via super()
    public Personnage(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    // Getter permet de récupérer les données d'un attribut private
    // ENCAPSULATION : getters = seule porte d'entrée en lecture vers les attributs
    // private
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    // Setter permet de modifier les données d'un attribut private
    // ENCAPSULATION : setters = seule porte d'entrée en écriture
    // La validation est centralisée ici, une seule fois pour toutes les
    // sous-classes
    public void setHp(int hp) {
        if (hp <= 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public void setAttack(int attack) {
        if (attack > 0) {
            this.attack = attack;
        }
    }

    // Méthode concrète : à le meme comportement peu importe ou on l'apelle
    public void takeDamage(int damage) {

        this.setHp(this.getHp() - damage);
    }

    // Methode abstraite
    // ABSTRACTION : méthode abstraite → les sous-classes DOIVENT la redéfinir
    // On sait QUE chaque personnage peut attaquer, pas COMMENT il le fait
    public abstract int attaquer();

}