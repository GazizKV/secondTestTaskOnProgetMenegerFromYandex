import java.io.*;
import java.util.ArrayList;

public class secondTaskSolution {
    public static ArrayList<Asessor> listOfAsessors = new ArrayList<Asessor>();

    public static Asessor getNewAsessor(String[] nextLine) {
        Asessor newAsessor = new Asessor(nextLine[0],
                Integer.parseInt(nextLine[1]),
                Integer.parseInt(nextLine[2]),
                Short.parseShort(nextLine[3]),
                Short.parseShort(nextLine[4]));
        return newAsessor;
    }

    public static void main(String[] args) {
        File file =  new File("C:\\Users\\valit\\secondTestTaskOnProgetMenegerFromYandex\\src\\main\\resources\\файл 2.csv");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String[] nextLine;
            while (bufferedReader.ready()) {
                nextLine = bufferedReader.readLine().split("\\s");
                if(nextLine[1].equals("uid")) continue;
                listOfAsessors.add(getNewAsessor(nextLine));
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(listOfAsessors.get(i).login);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
