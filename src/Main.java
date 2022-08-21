import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String input = readFile("input.txt");
        input = input.trim();

        String[] inputArr = input.split(" ");

        long a = Long.parseLong(inputArr[0]);
        long b = Long.parseLong(inputArr[1]);

        System.out.println((a + b));

        writeFile("output.txt", "" + (a + b) );
    }

    public static String readFile(String pathFile) {
        StringBuilder finishTextFromFile = new StringBuilder();
        String readableLine;
        try {
            FileReader file = new FileReader(pathFile);
            BufferedReader br = new BufferedReader(file);
            while ((readableLine = br.readLine()) != null) {
                finishTextFromFile.append(readableLine).append("\n");
            }
            br.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return finishTextFromFile.toString();
    }

    public static void writeFile(String path, String writeLine) {
        //        Записываем строку в файл

        try (
                FileWriter writer = new FileWriter(path, false)) {
            // запись всей строки
            new FileWriter(path, false).close();
            writer.write(writeLine);
            writer.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}