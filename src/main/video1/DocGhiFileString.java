/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class DocGhiFileString {

    public String ghiFileString(List<String> lists, String path) {
        Path file = Path.of(path);
        try {
            if (Files.notExists(file)) {
                Files.createFile(file);
            }
            Files.write(file, lists, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            return "Ghi file thất bại";
        }
        return "Ghi file thành công";
    }

    public List<String> docFileString(String path) {
        File file = new File(path);
        // Kiem tra su ton tai cua file
        if (!file.exists()) {
            System.out.println("File khong ton tai!!!!!");
            return null;
        }
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Đọc file thất bại");
            e.printStackTrace(System.out);
        }
        return stringList;
    }
}
