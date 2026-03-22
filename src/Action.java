// Enum : type spécial > ensemble fixe de constantes nommées.
// Les valeurs sont définies à la compilation, on ne peut ni en ajouter ni en supprimer à l'exécution.
// Chaque constante est une instance unique du type Enum.

public enum Action {
    // Enum constante
    ATTACK(1), POWER(2), SAVE(3), INVALIDE(-1);

    // Field (variable) to store the description text
    private int action;

    // Constructor (runs once for each constant above)
    private Action(int action) {
        this.action = action;
    }

    // Getter method to read the description
    public int getAction() {
        return action;
    }
}
