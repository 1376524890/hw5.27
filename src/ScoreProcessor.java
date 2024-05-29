import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;

public class ScoreProcessor {
    public static void main(String[] args) {
        String url = "http://cs.armstrong.edu/liangdata/Scores.txt";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));

            String line;
            double sum = 0;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] scores = line.trim().split("\\s+");
                for (String score : scores) {
                    sum += Double.parseDouble(score);
                    count++;
                }
            }

            reader.close();

            if (count > 0) {
                double average = sum / count;
                System.out.println("总分数: " + sum);
                System.out.println("平均分数: " + average);
            } else {
                System.out.println("未找到分数数据。");
            }
        } catch (IOException e) {
            System.out.println("发生IO异常：" + e.getMessage());
            e.printStackTrace();
        }
    }
}

