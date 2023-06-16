/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.P2;

import java.util.ArrayList;
import java.util.List;
import main.CongViec;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class MainFileAdvance {

    public static void main(String[] args) {
        List<CongViec> listInput = new ArrayList<>();
        listInput.add(new CongViec("Ăn và lăn", "Chơi", TrangThai.DANG_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Dọn dẹp", "Chơi", TrangThai.CHUA_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Nấu cơm", "Chơi", TrangThai.DANG_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Rửa bát", "Chơi", TrangThai.DA_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Dọn nhà", "Chơi", TrangThai.DANG_THUC_HIEN, 10000L));
        // ghi file 
        DocFileAdvance docFileAdvance = new DocFileAdvance();
//        System.out.println(docFileAdvance.ghiFileCSV("s24.csv", listInput));
        // doc file 
        List<CongViec> listOutput = docFileAdvance.docFileCSV("s24.csv");
        listOutput.forEach(s -> s.inThongTin());
    }
}
