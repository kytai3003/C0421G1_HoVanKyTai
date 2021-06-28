package _16_Java_IO_textfile.exercise.file.csv_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String csvFile = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\_16_Java_IO_textfile\\exercise\\file.csv_reader\\countries.csv";
        String line;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] country = line.split(",");
                System.out.println("Country [No = " + country[0] + " , code= " + country[1] + " , name=" + country[2] + "]");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
