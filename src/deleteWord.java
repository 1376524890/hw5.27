import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class deleteWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("<字符串> <文件名>");
        String[] input = new String[2];
        for (int i = 0; i < 2; i++) {
            input[i] = scan.next();
        }

        String target = input[0];
        String inputFile = input[1];

        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFile)));

            content = content.replace(target, "");

            Files.write(Paths.get(inputFile), content.getBytes());

            System.out.println("操作成功");
        } catch (NoSuchFileException e) {
            System.out.println("错误：找不到输入文件 " + inputFile);
        } catch (IOException e) {
            System.out.println("错误：无法读取或写入文件");
            e.printStackTrace();
        }
    }
}

