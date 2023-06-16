package main.video3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import main.CongViec;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class QuanLyCongViecService {

    private final List<CongViec> listCongViec;

    public QuanLyCongViecService() {
        this.listCongViec = new ArrayList<>();
        listCongViec.add(new CongViec("Nau com", "Việc nhà", TrangThai.CHUA_THUC_HIEN, 100L));
        listCongViec.add(new CongViec("Rua bat", "Việc nhà", TrangThai.CHUA_THUC_HIEN, 100L));
        listCongViec.add(new CongViec("Quet nha", "Việc nhà", TrangThai.CHUA_THUC_HIEN, 100L));
        listCongViec.add(new CongViec("Lam bai tap", "Việc nhà", TrangThai.DANG_THUC_HIEN, 100L));
        listCongViec.add(new CongViec("Choi game", "Giải trí", TrangThai.DA_THUC_HIEN, 100L));
    }

    public List<CongViec> getAll() {
        return listCongViec;
    }

    public String themCV(CongViec congViec) {
        if (congViec != null) {
            listCongViec.add(congViec);
            return "Them thanh cong";
        }
        return "Them that bai";
    }

    public String suaCV(int index, CongViec congViec) {
        if (index != -1) {
            listCongViec.set(index, congViec);
            return "Sua thanh cong";
        }
        return "Sua that bai";
    }

    public String xoaCongViec(int index) {
        if (index != -1) {
            listCongViec.remove(index);
            return "Xoa thanh cong";
        }
        return "Xoa that bai";

    }

    public String ghiFile(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (CongViec congViec : listCongViec) {
                    oos.writeObject(congViec);
                }
            }
            return "Ghi file thành công!";
        } catch (IOException e) {
            return "Ghi file thất bại";
        }
    }

    public String docFile(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                System.out.println("Không tìm thấy file!");
            }
            try (FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    listCongViec.add((CongViec) ois.readObject());
                }
            }
            return "Đọc file thành công!";
        } catch (IOException | ClassNotFoundException e) {
            return "Đọc file thất bại";
        }
    }

}
