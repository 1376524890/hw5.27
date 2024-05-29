import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class hw12_15 {
    public static void main(String[] args) {
        String fileName = "Exercise12_15.txt";
        File file = new File(fileName);

        try {
            if (file.exists()) {
                Files.delete(Paths.get(fileName));
                createFileWithRandomNumbers(file);
            }else {
                createFileWithRandomNumbers(file);
            }

            int[] numbers = readNumbersFromFile(file);
            Arrays.sort(numbers);

            System.out.println("升序排列的数据：");
            for (int number : numbers) {
                System.out.print(number + " ");
            }
        } catch (IOException e) {
            System.out.println("发生IO异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createFileWithRandomNumbers(File file) throws IOException {
        Random random = new Random();
        FileWriter writer = new FileWriter(file);

        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(1000);
            writer.write(randomNumber + " ");
        }

        writer.close();
        System.out.println("已创建文件并写入了100个随机整数：" + file.getName());
    }

    private static int[] readNumbersFromFile(File file) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
        String[] numberStrings = content.trim().split("\\s+");
        int[] numbers = new int[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        return numbers;
    }
}
