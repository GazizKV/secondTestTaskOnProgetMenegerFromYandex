import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class secondTaskSolution {
    public static Map<Integer, Asessor> listOfAsessors = new HashMap<>();

    public static Asessor getNewAsessor(String[] nextLine) {
        Asessor newAsessor = new Asessor(nextLine[0],
                Integer.parseInt(nextLine[1]),
                Integer.parseInt(nextLine[2]),
                Short.parseShort(nextLine[3]),
                Short.parseShort(nextLine[4]));
        return newAsessor;
    }

    public static Asessor getUpDateAsessor(String[] nextLine, Integer key) {
        Asessor upDateAsessor = listOfAsessors.get(key);
        if(upDateAsessor.cjud == 1) {
            upDateAsessor.allScore++;
            upDateAsessor.scorOfCorrectAns++;
        } else {
            upDateAsessor.scorOfInCorrectAns++;
        }
        if(upDateAsessor.jud == upDateAsessor.cjud) {
            upDateAsessor.allScore += 1;
            upDateAsessor.scorOfDifferences += 1;
        }
        if(upDateAsessor.cjud != 1) upDateAsessor.allScore--;
        if(upDateAsessor.jud != upDateAsessor.cjud) upDateAsessor.allScore--;
        return upDateAsessor;
    }

    public static void main(String[] args) {

        StringBuilder path = new StringBuilder((System.getProperty("user.dir") + "\\target\\classes" + "\\file.csv").replace("/", "\\"));
        File file =  new File(path.toString());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));)
        {
            String[] nextLine;
            while (bufferedReader.ready()) {
                nextLine = bufferedReader.readLine().split("\\s");
                if(nextLine[1].equals("uid")) continue;
                if(!listOfAsessors.containsKey(Integer.parseInt(nextLine[1]))) {
                    listOfAsessors.put(Integer.parseInt(nextLine[1]), getNewAsessor(nextLine));
                } else {
                    Integer key = Integer.parseInt(nextLine[1]);
                    Asessor upDateAsessor = getUpDateAsessor(nextLine, key);
                    listOfAsessors.put(key, upDateAsessor);
                }
            }
            System.out.println("Хуже всего справились с заданием следующие асессоры.");
            for (Map.Entry<Integer, Asessor> entry : listOfAsessors.entrySet()) {
                if(entry.getValue().allScore < 0) {
                    System.out.println(entry.getKey()
                            + " " + entry.getValue().login
                            + " " + "generalScor = " + entry.getValue().allScore
                    );
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
