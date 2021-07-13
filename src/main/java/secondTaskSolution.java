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
        File file =  new File("C:\\Users\\valit\\secondTestTaskOnProgetMenegerFromYandex\\src\\main\\resources\\файл 2.csv");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
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
            bufferedReader.close();

            for (Map.Entry<Integer, Asessor> entry : listOfAsessors.entrySet()) {
                System.out.println(entry.getKey()
                        + " " + entry.getValue().login
                        + " " + entry.getValue().allScore
                        + " " + entry.getValue().scorOfCorrectAns
                        + " " + entry.getValue().scorOfInCorrectAns
                        + " " + entry.getValue().scorOfDifferences);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
