package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import object.Diem;
import object.LopHoc;
import object.MonHoc;
import object.SinhVien;
import server.StdManagerInterface;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            StdManagerInterface stdManagerInterface = (StdManagerInterface) registry.lookup("studentmanager");
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("MENU");
                System.out.println("1. Quan li sinh vien");
                System.out.println("2. Quan li lop hoc");
                System.out.println("3. Quan li mon hoc");
                System.out.println("4. Quan li diem");
                System.out.println("0. Thoat");
                System.out.println("Input your choice");
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("1. Hien thi tat ca sinh vien");
                        System.out.println("2. Tim kiem sinh vien");
                        System.out.println("3. Them sinh vien");
                        System.out.println("4. Cap nhat sinh vien");
                        System.out.println("5. Xoa sinh vien");
                        System.out.println("0. Quay lai");
                        int stdchoice = sc.nextInt();
                        switch (stdchoice) {
                            case 1:
                                System.out.println("Danh sach sinh vien: ");
                                System.out.printf("|%-6s|%-20s|%-8s|%-8s|\n", "MSVV", "Ten", "Nam sinh", "Ma lop");
                                for (SinhVien sv : stdManagerInterface.getAllSinhVien()) {
                                    System.out.printf("|%-6d|%-20s|%-8d|%-8s|\n", sv.getMssv(), sv.getTen(),
                                            sv.getNamSinh(), sv.getMaLop());

                                }
                                break;
                            case 2:
                                System.out.println("Nhap ma so sinh vien");
                                int ms = sc.nextInt();
                                SinhVien sv = stdManagerInterface.findSinhVien(ms);
                                if (sv != null) {
                                    System.out.printf("|%-6s|%-20s|%-8s|%-8s|\n", "MSVV", "Ten", "Nam sinh", "Ma lop");
                                    System.out.printf("|%-6d|%-20s|%-8d|%-8s|\n", sv.getMssv(), sv.getTen(),
                                            sv.getNamSinh(), sv.getMaLop());
                                } else {
                                    System.out.println("Khong tim thay sinh vien");
                                }
                                break;
                            case 3:
                                System.out.println("Nhap thong tin sinh vien moi");
                                System.out.println("Mssv:");
                                int msadd = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Ten:");
                                String tenadd = sc.nextLine();
                                System.out.println("Nam sinh");
                                int namadd = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Ma lop");
                                String mladd = sc.nextLine();
                                SinhVien newSinhVien = new SinhVien(msadd, tenadd, namadd, mladd);
                                stdManagerInterface.addSinhVien(newSinhVien);
                                break;
                            case 4: {
                                System.out.println("Nhap ma so sinh vien:");
                                int mssv = sc.nextInt();
                                SinhVien fsv = stdManagerInterface.findSinhVien(mssv);
                                sc.nextLine();
                                if (fsv != null) {
                                    System.out.println("Nhap thong tin sinh vien can cap nhat");
                                    System.out.println("Ten sinh vien:");
                                    String tennew = sc.nextLine();
                                    System.out.println("Nam sinh:");
                                    int namnew = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Ma lop:");
                                    String mlnew = sc.nextLine();
                                    SinhVien newsv = new SinhVien(mssv, tennew, namnew, mlnew);
                                    stdManagerInterface.updateSinhVien(newsv);
                                } else {
                                    System.out.println("Khong tim thay sinh vien");
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("Nhap ma so sinh vien can xoa");
                                int msdelete = sc.nextInt();
                                boolean deletesv = stdManagerInterface.deleteSinhVien(msdelete);
                                if (deletesv)
                                    System.out.println("Xoa thanh cong");
                                else
                                    System.out.println("Loi");
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                                break;
                        }
                        break;
                    }
                    case 2:{
                        System.out.println("1. Hien thi tat ca lop hoc");
                        System.out.println("2. Tim kiem lop hoc");
                        System.out.println("3. Them lop hoc");
                        System.out.println("4. Cap nhat lop hoc");
                        System.out.println("5. Xoa lop hoc");
                        System.out.println("0. Quay lai");
                        int lhchoice = sc.nextInt();
                        switch (lhchoice) {
                            case 1:
                                System.out.println("Danh sach lop hoc: ");
                                System.out.printf("|%-6s|%-20s|\n", "Ma Lop", "Ten Lop");
                                for (LopHoc lh : stdManagerInterface.getAllLopHoc()) {
                                    System.out.printf("|%-6s|%-20s|\n",lh.getMaLop(),lh.getTenLop());

                                }
                                break;
                            case 2:
                                System.out.println("Nhap ma lop");
                                String ml = sc.nextLine();
                                LopHoc lh = stdManagerInterface.findLop(ml);
                                if (lh != null) {
                                    System.out.printf("|%-6s|%-20s|\n", "Ma Lop", "Ten Lop");
                                    System.out.printf("|%-6s|%-20s|\n",lh.getMaLop(),lh.getTenLop());

                                } else {
                                    System.out.println("Khong tim thay lop hoc");
                                }
                                break;
                            case 3:
                                System.out.println("Nhap thong tin lop hoc moi");
                                System.out.println("Ma Lop:");
                                String fml = sc.nextLine();
                                System.out.println("Ten Lop:");
                                String ftl = sc.nextLine();
                                LopHoc flh = new LopHoc(fml, ftl);
                                stdManagerInterface.addLopHoc(flh);
                                break;
                            case 4:{
                                System.out.println("Nhap ma so lop hoc:");
                                String mlh = sc.nextLine();
                                LopHoc flhoc = stdManagerInterface.findLop(mlh);
                                sc.nextLine();
                                if (flhoc != null) {
                                    System.out.println("Nhap thong tin lop hoc can cap nhat");
                                    System.out.println("Ten lop hoc:");
                                    String tennew = sc.nextLine();
                                    LopHoc lhnew = new LopHoc(mlh, tennew);
                                    stdManagerInterface.updateLopHoc(lhnew);
                                } else {
                                    System.out.println("Khong tim thay lop hoc");
                                }
                                break;
                            }
                            case 5:{
                                System.out.println("Nhap ma so lop hoc can xoa");
                                String mlh = sc.nextLine();
                                boolean deletelh = stdManagerInterface.deleteLopHoc(mlh);
                                if(deletelh)
                                    System.out.println("Xoa thanh cong");
                                else
                                    System.out.println("Loi");
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                                break;
                        }
                        break;
                    }
                    case 3:{
                        System.out.println("1. Hien thi tat ca mon hoc");
                        System.out.println("2. Tim kiem mon hoc");
                        System.out.println("3. Them mon hoc");
                        System.out.println("4. Cap nhat mon hoc");
                        System.out.println("5. Xoa mon hoc");
                        System.out.println("0. Quay lai");
                        int lhchoice = sc.nextInt();
                        switch (lhchoice) {
                            case 1:
                                System.out.println("Danh sach mon hoc: ");
                                System.out.printf("|%-6s|%-20s|\n", "Ma Mon", "Ten mon hoc");
                                for (MonHoc mh : stdManagerInterface.getAllMonHoc()) {
                                    System.out.printf("|%-6d|%-20s|\n",mh.getMaMh(), mh.getTenMh());

                                }
                                break;
                            case 2:
                                System.out.println("Nhap ma mon hoc");
                                String mmh = sc.nextLine();
                                MonHoc mh = stdManagerInterface.findMonHoc(mmh);
                                if (mh != null) {
                                    System.out.printf("|%-6s|%-20s|\n", "Ma Mon", "Ten Mon Hoc");
                                    System.out.printf("|%-6s|%-20s|\n",mh.getMaMh(), mh.getTenMh());

                                } else {
                                    System.out.println("Khong tim thay mon hoc");
                                }
                                break;
                            case 3:
                                System.out.println("Nhap thong tin mon hoc moi");
                                System.out.println("Ma mon hoc:");
                                String mmhadd = sc.nextLine();
                                System.out.println("Ten mon hoc:");
                                String tmhadd = sc.nextLine();
                                MonHoc mhadd = new MonHoc(mmhadd,tmhadd);
                                stdManagerInterface.addMonHoc(mhadd);
                                break;
                            case 4:{
                                System.out.println("Nhap ma mon hoc:");
                                String fmmh = sc.nextLine();
                                MonHoc fmh = stdManagerInterface.findMonHoc(fmmh);
                                sc.nextLine();
                                if (fmh != null) {
                                    System.out.println("Nhap thong tin mon hoc can cap nhat");
                                    System.out.println("Ten mon hoc:");
                                    String tennew = sc.nextLine();
                                    MonHoc mhnew = new MonHoc(fmmh, tennew);
                                    stdManagerInterface.updateMonHoc(mhnew);
                                } else {
                                    System.out.println("Khong tim thay mon hoc");
                                }
                                break;
                            }
                            case 5:{
                                System.out.println("Nhap ma mon hoc can xoa");
                                String mmhdelete = sc.nextLine();
                                boolean deletemh = stdManagerInterface.deleteMonHoc(mmhdelete);
                                if(deletemh)
                                    System.out.println("Xoa thanh cong");
                                else
                                    System.out.println("Loi");
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                                break;
                        }
                        break;
                    }
                    case 4:{
                        System.out.println("1. Hien thi tat ca diem");
                        System.out.println("2. Xem diem sinh vien");
                        System.out.println("3. Them diem");
                        System.out.println("4. Cap nhat diem");
                        System.out.println("5. Xoa diem");
                        System.out.println("0. Quay lai");
                        int lhchoice = sc.nextInt();
                        switch (lhchoice) {
                            case 1:
                                System.out.println("Danh sach mon diem: ");
                                System.out.printf("|%-6s|%-8s|%-6s|\n", "Mssv", "MaMH","Diem");
                                for (Diem d : stdManagerInterface.getAllDiem()) {
                                    System.out.printf("|%-6d|%-8s|%-6.2f|\n",d.getMssv(),d.getMaMh(),d.getDiem());

                                }
                                break;
                            case 2:
                                System.out.println("Nhap ma sinh vien");
                                int mssv = sc.nextInt();
                                Diem fd = stdManagerInterface.findDiem(mssv);
                                if (fd != null) {
                                    System.out.printf("|%-6s|%-8s|%-6s|\n", "Mssv", "MaMH","Diem");
                                    System.out.printf("|%-6d|%-8s|%-6.2f|\n",fd.getMssv(),fd.getMaMh(),fd.getDiem());

                                } else {
                                    System.out.println("Khong tim thay diem");
                                }
                                break;
                            case 3:
                                System.out.println("Nhap thong tin ");
                                System.out.println("Mssv:");
                                int msadd = sc.nextInt();
                                sc.nextLine();
                                System.out.println("MaMH:");
                                String mmhadd = sc.nextLine();
                                System.out.println("Diem:");
                                float diemnew = sc.nextFloat();
                                Diem dnew = new Diem(msadd, mmhadd, diemnew);
                                stdManagerInterface.addDiem(dnew);
                                break;
                            case 4:{
                                System.out.println("Nhap ma sinh vien:");
                                int fms = sc.nextInt();
                                sc.nextLine();
                                Diem ud = stdManagerInterface.findDiem(fms);
                                sc.nextLine();
                                if (ud != null) {
                                    System.out.println("Nhap thong tin  can cap nhat");
                                    System.out.println("Ten mon hoc:");
                                    String uten = sc.nextLine();
                                    System.out.println("Nhap diem: ");
                                    float udiem = sc.nextFloat();
                                    Diem dinew = new Diem(fms, uten, udiem);
                                    stdManagerInterface.updateDiem(dinew);
                                } else {
                                    System.out.println("Khong tim thay diem");
                                }
                                break;
                            }
                            case 5:{
                                System.out.println("Nhap mssv");
                                int msdelete = sc.nextInt();
                                boolean deleted = stdManagerInterface.deleteDiem(msdelete);
                                if(deleted)
                                    System.out.println("Xoa thanh cong");
                                else
                                    System.out.println("Loi");
                                break;
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                                break;
                        }
                        break;
                    }
                    case 0:
                        System.out.println("Cam on ban da su dung chuong trinh!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
