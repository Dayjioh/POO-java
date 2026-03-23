// Interface Fighter : contrat commun à tous les combattants
// Toute classe qui implements Fighter DOIT implémenter ces 4 méthodes
// Permet d'écrire des méthodes génériques (ex: attack(Fighter, Fighter))
// sans se soucier du type réel de l'objet (Heros, Ennemi, Boss...)
public interface Fighter {
    int attaquer();

    void takeDamage(int damage);

    String getName();

    int getHp();

}
