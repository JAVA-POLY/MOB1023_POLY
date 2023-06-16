/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.P2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.CongViec;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class DocFileAdvance {

    public String ghiFileCSV(String path, List<CongViec> lists) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                writer.write("Tên công việc,Thể loại,Trạng thái,Thời gian hoàn thành");
                writer.newLine();
                for (CongViec congViec : lists) {
                    writer.write(congViec.getTenCongViec() + ","
                            + congViec.getTenTheLoai() + ","
                            + congViec.getTrangThai().name()
                            + "," + congViec.getThoiGianHoanThanh());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            return "Ghi file thất bại";
        }
        return "Ghi file thành công";
    }

    public List<CongViec> docFileCSV(String path) {
        List<CongViec> danhSachCongViec = new ArrayList<>();
        File file = new File(path);
        // Kiem tra su ton tai cua file
        if (!file.exists()) {
            System.out.println("File khong ton tai!!!!!");
            return null;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            // Bỏ qua dòng tiêu đề nếu có
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String tenCongViec = fields[0].trim();
                String tenTheLoai = fields[1].trim();
                String trangThai = fields[2].trim();
                String thoiGianHoanThanh = fields[3].trim();

                CongViec congViec = new CongViec(tenCongViec, tenTheLoai,
                        TrangThai.valueOf(trangThai), Long.valueOf(thoiGianHoanThanh));
                danhSachCongViec.add(congViec);
            }
        } catch (IOException e) {
            System.out.println("Đọc file thất bại");
            return null;
        }

        return danhSachCongViec;
    }
}
