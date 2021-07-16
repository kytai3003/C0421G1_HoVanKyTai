package module2_practise.common;

import module2_practise.model.Product;
import resort_management.models.Facility;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class ReadAndWriteCSV {
    public void writeFile(String path, ArrayList<Product> list) {
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public ArrayList<Product> readFile(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        ArrayList<Product> list = null;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList<Product>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return list;
    }
}
