package org.example.exercice_1;

public class Main {

    static void main(String[] args) {
        // Instanciation de l'objet stats
        StatsManager stats = new StatsManager();

        // Ajouts des valeurs
        stats.addValue(10);
        stats.addValue(20);
        stats.addValue(30);

        // Vérification des valeurs
        System.out.println("Initialisation des données de l'ArrayList 'stats' : " + stats.getCount());

        System.out.println("\nCas n°1 : Valeurs entières");
        System.out.println("État de la liste : " + stats.toString());
        stats.reset();

        System.out.println("\nCas n°2 : Valeurs décimales");
        stats.addValue(2.91);
        stats.addValue(3.53);
        System.out.println("État de la liste : " + stats.toString());
        stats.reset();

        System.out.println("\nCas n°3 : Une seule valeur");
        stats.addValue(42);
        System.out.println("État de la liste : " + stats.toString());


        System.out.println(stats.exportAsText());
        stats.exportAsFile();

    }
}
