package org.example.exercice_1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * StatsManager est un service métier chargé de collecter des valeurs numériques
 * et de calculer des statistiques de base telles que le minimum, le maximum, la moyenne et le nombre.
 *
 * Cette classe encapsule la structure de données interne et garantit
 * la cohérence des calculs statistiques.
 *
 * Elle peut également exporter les statistiques calculées sous forme de texte ou dans un fichier pour le moment.
 */
public class StatsManager {
    private final List<Double> values;

    /**
     * Constructeur
     * Crée un ArrayList de type Double
     */
    public StatsManager() {
        this.values = new ArrayList<Double>();
    }

    /**
     * Ajoute une valeur numérique au gestionnaire.
     *
     * @param value valeur à ajouter
     */
    public void addValue(double value) {
        this.values.add(value);
    }


    /**
     * Retourne la valeur minimale enregistrée.
     *
     * @return la plus petite valeur de la liste
     * @throws IllegalStateException si aucune valeur n'est enregistrée
     */
    public double getMin() {
        ensureNotEmpty(); // Vérification
        double minValue = this.values.getFirst();

        for (int i = 1; i < getCount(); i++) {
            double actualValue = this.values.get(i); // Valeur actuelle

            if (actualValue < minValue) {
                minValue = actualValue;
            }
        }

        return minValue; // valeur renvoyée
    }


    /**
     * Retourne la valeur maximale enregistrée.
     *
     * @return la plus petite valeur de la liste
     * @throws IllegalStateException si aucune valeur n'est enregistrée
     */
    public double getMax() {
        ensureNotEmpty(); // Vérification
        double maxValue = this.values.getFirst();

        for (int i = 1; i < getCount(); i++) {
            double actualValue = this.values.get(i);

            if (actualValue > maxValue) {
                maxValue = actualValue;
            }
        }

        return maxValue;
    }


    /**
     * Calcule la moyenne de la liste
     *
     * @return la valeur moyenne à deux décimales près.
     */
    public double getAverage() {
        ensureNotEmpty(); // Vérification
        double sum = 0;
        for (double number : this.values) {
            sum += number;
        }

        return Math.round((sum / getCount()) * 100.0) / 100.0;
    }

    /**
     * Supprime toutes les valeurs enregistrées.
     */
    public void reset() {
        this.values.clear();
    }


    /**
     * Récupère la taille de la liste
     *
     * @return la taille de la liste
     */
    public int getCount() {
        return values.size();
    }


    /**
     * Vérifie que la liste n'est pas vide
     *
     * @throws IllegalStateException si aucune valeur n'est enregistrée
     */
    private void ensureNotEmpty() {
        if (values.isEmpty()) {
            throw new IllegalStateException("Aucune valeur enregistrée");
        }
    }

    /**
     * Exporte les statistiques sous forme de texte lisible.
     *
     * <pre>
     * Min = 42
     * Max = 42
     * Average = 42.0
     * Count = 1
     * </pre>
     *
     * @return une représentation textuelle des statistiques
     * @throws IllegalStateException si aucune valeur n'est présente
     */
    public String exportAsText() {
        if (values.isEmpty()) {
            throw new IllegalStateException("Impossible d'exporter des statistiques sur une liste vide");
        }

        // Note : pas obligé d'exécuter la méthode String.ofValue() comme on ajoute directement les valeurs numériques à une chaine de caractères
        return "Min = " + getMin()
                + "\nMax = " + getMax()
                + "\nAverage = " + getAverage()
                + "\nCount = " + getCount();
    }


//    /**
//     * Version 1 :
//     * Écrit les statistiques dans un fichier texte.
//     * Cette version est moins "sécurisée" puisque je dois fermer manuellement la lecture du fichier.
//     *
//     * @throws RuntimeException si une erreur d'écriture survient
//     */
//    public void exportAsFile() {
//        String fileName = "output.txt"; // nom du fichier
//        Path directory = Path.of("output");
//
//        try {
//            String textToWrite = this.exportAsText(); // Récupère le format du texte à écrire
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)); // ?
//            writer.write(textToWrite); // Écrit dans le fichier
//
//            writer.close(); // Ferme l'écriture du fichier
//
//        } catch (IOException e) {
//            throw new RuntimeException("Erreur lors de l'écriture du fichier : " + fileName, e);
//        }
//    }

    /**
     * Écrit les statistiques dans un fichier texte local.
     * Le fichier est écrasé s'il existe déjà.
     * Cette version est à privilégier comme on n'a pas besoin de fermer manuellement le fichier grâce à try-with-resources
     *
     * @throws RuntimeException si une erreur d'accès au fichier survient
     */
    public void exportAsFile() {
        String fileName = "output.txt";
        Path directory = Path.of("src/exercice_1/outputs");
        Path filePath = directory.resolve(fileName);

        try {
            // Crée le dossier s'il n'existe pas
            Files.createDirectories(directory);

            try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
                writer.write(exportAsText()); // Écrit dans le fichier
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'écriture du fichier : " + filePath, e);
        }
    }


    @Override
    public String toString() {
        return "StatsManager{ " +
                "values=" + this.values +
                ", min=" + this.getMin() +
                ", max=" + this.getMax() +
                ", average=" + this.getAverage() +
                ", count=" + this.getCount() +
                " }";
    }
}
