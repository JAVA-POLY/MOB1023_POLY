/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.P1;

import java.util.ArrayList;
import java.util.List;
import main.CongViec;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class MainByte {

    public static void main(String[] args) {
        List<CongViec> listInput = new ArrayList<>();
        listInput.add(new CongViec("Ăn và lăn", "Chơi", TrangThai.DANG_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Dọn dẹp", "Chơi", TrangThai.CHUA_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Nấu cơm", "Chơi", TrangThai.DANG_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Rửa bát", "Chơi", TrangThai.DA_THUC_HIEN, 10000L));
        listInput.add(new CongViec("Dọn nhà", "Chơi", TrangThai.DANG_THUC_HIEN, 10000L));
        // ghi file 
        DocGhiFileByte docGhiFileByte = new DocGhiFileByte();
        System.out.println(docGhiFileByte.ghiFile("s23.txt", listInput));
        // doc file 
        List<CongViec> listOutput = docGhiFileByte.docFile("s23.txt");
        listOutput.forEach(s -> s.inThongTin());
    }
}
