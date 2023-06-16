/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.P1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import main.CongViec;

/**
 *
 * @author hangnt
 */
public class DocGhiFileByte {

    public String ghiFile(String path, List<CongViec> lists) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                // Ghi tung doi tuong vao file
                for (CongViec t : lists) {
                    oos.writeObject(t);
                }
            } catch (Exception e) {
                return "Ghi file that bai";
            }
        } catch (IOException e) {
            return "Ghi file that bai";
        }
        return "Ghi file thanh cong";
    }

    public List<CongViec> docFile(String path) {
        List<CongViec> lists = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File khong ton tai!!!!!");
            return null;
        }
        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                lists.add((CongViec) ois.readObject());
            }
        } catch (Exception e) {
            System.out.println("Đọc file thất bại");
            return null;
        }
        return lists;
    }
}
