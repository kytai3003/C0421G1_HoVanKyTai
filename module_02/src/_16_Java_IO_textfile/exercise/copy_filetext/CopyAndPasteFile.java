package _16_Java_IO_textfile.exercise.copy_filetext;

import java.io.*;

public class CopyAndPasteFile {
    public static String copyFile(File file) throws IOException {
        FileReader fr =new FileReader(file);
        int i;
        String result = "";
        while ((i = fr.read()) != -1) {
            result += (char)i;
        }
        fr.close();
        return result;
    }

    public static void writeFile(File file, String line) {
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File readFile = new File("D:\\C2401G1_HoVanKyTai\\module_02\\src\\_16_Java_IO_textfile\\exercise\\copy_filetext\\copy.txt");
            File writeFile = new File("D:\\C2401G1_HoVanKyTai\\module_02\\src\\_16_Java_IO_textfile\\exercise\\copy_filetext\\paste.txt");
            String str = copyFile(readFile);
            writeFile(writeFile, str);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
