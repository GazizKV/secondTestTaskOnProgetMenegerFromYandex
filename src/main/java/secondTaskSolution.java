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
            bufferedReader.close();

            /**
             * я решил что наихудшими будут те кто (сдал или не сдал) и оценили свою работу не правильно.
             * для этого я сделаю отдельный лист только с теми у кого не совпадают бинарные оценки
             * то есть jud and cjud
             */
            ArrayList<Asessor> listOfWorstAsessors = new ArrayList<>();
            for (Asessor asessor : listOfAsessors) {
                if(asessor.jud != asessor.cjud) listOfWorstAsessors.add(asessor);
            }
            /*
            * вывод login в консоль худших асессоров
            * */
            for (Asessor asessor : listOfWorstAsessors) System.out.println(asessor.login);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
