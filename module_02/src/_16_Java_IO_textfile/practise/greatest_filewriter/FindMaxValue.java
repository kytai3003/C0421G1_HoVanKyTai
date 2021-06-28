package _16_Java_IO_textfile.practise.greatest_filewriter;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\C2401G1_HoVanKyTai" +
                "\\module_02\\src\\_16_Java_IO_textfile\\practise\\greatest_filewriter\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\C2401G1_HoVanKyTai" +
                "\\module_02\\src\\_16_Java_IO_textfile\\practise\\greatest_filewriter\\result.txt", maxValue);
    }
}
