import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            File file1 = new File("src/resources/fructe.txt");
            Scanner scanner1 = new Scanner(file1);

            int totalMere = 0;
            int totalPrune = 0;
            int totalGutui = 0;

            while (scanner1.hasNextLine()) {
                String linie = scanner1.nextLine();

                // Despart linia în părți (nume și cifre)
                String[] parti = linie.split(" ");

                // Extragem fructul și valorile
                String fruct = parti[0];  // primul element este numele fructului
                int val1 = Integer.parseInt(parti[1]);
                int val2 = Integer.parseInt(parti[2]);
                int val3 = Integer.parseInt(parti[3]);

                int suma = val1 + val2 + val3;

                // Verificăm despre ce fruct este vorba și salvăm suma în variabila corespunzătoare
                if (fruct.equals("mere")) {
                    totalMere = suma;
                } else if (fruct.equals("prune")) {
                    totalPrune = suma;
                } else if (fruct.equals("gutui")) {
                    totalGutui = suma;
                }
            }

            System.out.println("Total mere: " + totalMere);
            System.out.println("Total prune: " + totalPrune);
            System.out.println("Total gutui: " + totalGutui);

            if (totalMere > totalPrune && totalMere > totalGutui) {
                System.out.println("Mere sunt cele mai multe.");
            } else if (totalPrune > totalMere && totalPrune > totalGutui) {
                System.out.println("Prune sunt cele mai multe.");
            } else if (totalGutui > totalMere && totalGutui > totalPrune) {
                System.out.println("Gutui sunt cele mai multe.");
            } else {
                System.out.println("Sunt fructe cu cantități egale.");
            }
            scanner1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit.");
        }

        System.out.println("------------------------------");
        List<String> list = new ArrayList <String>();
        File data_students = new File("src/resources/data.txt");

        try{
            Scanner scan= new Scanner(data_students);
            while(scan.hasNextLine()){
                list.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println("Studentii corespunzatori sunt:");
     list.stream()
             .filter(variable->variable.length()>4 )
             .map(variable->variable.toUpperCase())
             .forEach(variable->System.out.println(variable));
    }
}
