package org.example.servletcalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RecordOperationInFile {
    private double num1;
    private double num2;
    private double result;
    private String operation;
    private String dtg;

    public void saveResult(double num1, double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
        LocalDateTime localDateTime = LocalDateTime.now();
        this.dtg = localDateTime.toString();
        recordInFile();

    }

    public void recordInFile() {

        String text = dtg + "  " + "num 1 = " + num1 + " " + "num 2 = " + num2 + " " + "type operation = " + operation + " " + "result = " + result + "\n";
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Игорь\\IdeaProjects\\ServletCalculator\\src\\container.txt", true);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
