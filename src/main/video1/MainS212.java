/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class MainS212 {
    
    public static void main(String[] args) {
        List<String> listCongVien = new ArrayList<>();
        listCongVien.add("Nau com1");
        listCongVien.add("Rua bat1");
        listCongVien.add("Quet nha");
        DocGhiFileString docGhiFile = new DocGhiFileString();
        // Luu cong viec xuong file
        System.out.println(docGhiFile.ghiFileString(listCongVien, "s212.txt"));
        // Doc cong vcoá iec tu file ra
        List<String> ketQuaDocFile = docGhiFile.docFileString("s212.txt");
        // in ket qua sau khi doc file
        ketQuaDocFile.forEach(s -> System.out.println(s));
    }
    
}
