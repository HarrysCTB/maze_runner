package other;

public enum Macro {
    ARGS("Erreur : Veuillez fournir 4 arguments.\n" + //
                "\nUtilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] " + //
                        "[simple/graph/optimized]"),
    GEN("Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5.\n" + //
    "\nUtilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] " + //
            "[simple/graph/optimized]"),
    LAB("Erreur : Veuillez fournir un type de labyrinthe et une méthode de génération valides.\n" + //
                "\nUtilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] " + //
                        "[simple/graph/optimized]"),
    NUMB("Erreur inattendue lors de la génération du labyrinthe. Veuillez réessayer.\nUtilisation : java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] " + //
                    "[simple/graph/optimized]");

    private final String message;

    Macro(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
