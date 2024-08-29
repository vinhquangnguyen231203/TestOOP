import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import ThongTinVatPham.BaoTaySamSet;
import ThongTinVatPham.CayGayChienThan;
import ThongTinVatPham.CayRiuPhepThuat;
import ThongTinVatPham.ChiecBuaThan;
import ThongTinVatPham.HonDaKichNo;
import ThongTinVatPham.VatPham;

public class DanhSachVatPham {
    private List<VatPham> listVatPhams;

    //Constructor
    public DanhSachVatPham() {
        listVatPhams = new ArrayList<>();
    }

    // Methods
    Consumer<String> thongBaoLoi = new Consumer<String>() {

        @Override
        public void accept(String t) {
            System.out.println(t);
        }
        
    };
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("###################");
        System.out.println("Cau 1: ");
        
        int choose = 0;
        while (true) {
            System.out.println("1- Chiec bua than");
            System.out.println(" 2- Bao tay sam set");
            System.out.println(" 3- Hon da kich no");
            System.out.println("4-  Cay riu phep thuat");
            System.out.println(" 5- Cay gay chien than");
            System.out.println("6- Thoat");
            System.out.println("----------------");
            System.out.println("Moi ban chon vat pham: ");
            
            try{
                choose = sc.nextInt();
            }
            catch(InputMismatchException e) {
                thongBaoLoi.accept(e.getMessage());
                break;

            }
            

            if(choose == 1) {
                VatPham vatPham = new ChiecBuaThan();
                listVatPhams.add(vatPham);
            }
            else if(choose == 2) {
                VatPham vatPham = new BaoTaySamSet();
                listVatPhams.add(vatPham);
            }
            else if(choose == 3) {
                VatPham vatPham = new HonDaKichNo();
                listVatPhams.add(vatPham);
            }
            else if(choose == 4) {
                VatPham vatPham = new CayRiuPhepThuat();
                listVatPhams.add(vatPham);
            }
            else if(choose == 5) {
                VatPham vatPham = new CayGayChienThan();
                listVatPhams.add(vatPham);
            }
            else if(choose == 6) {
                if(checkDu5LoaiVP()) {
                    System.out.println("#################");
                    System.out.println("----- Day du vat pham de chien dau");
                    System.out.println("##################");
                    break;
                }
                else{
                    System.out.println("#################");
                    System.out.println("----- Chua du vat pham");
                    System.out.println("##################");
                    continue;
                }
            }
            else{
                continue;
            }
        }



    }

    private VatPham thongTinVPcoMaxSoVang() {
        for (VatPham vatPham : listVatPhams) {
            if(vatPham.tongSoVangQuyDoi() == maxSoVang()) {
                return vatPham;
            }
        }
        return null;

                      
    }
    private boolean checkDu5LoaiVP() {
        int chiecBuaThan = 0, baoTaySamSet = 0, honDaKichNo = 0, cayRiuPhepThuat = 0, cayGayChienThan = 0;
        for (VatPham vatPham : listVatPhams) {
            if(vatPham instanceof ChiecBuaThan) {
                chiecBuaThan++;
            }
            else if(vatPham instanceof BaoTaySamSet) {
                baoTaySamSet++;
            }
            else if(vatPham instanceof HonDaKichNo) {
                honDaKichNo++;
            }
            else if(vatPham instanceof CayRiuPhepThuat) {
                cayRiuPhepThuat++;
            }
            else if(vatPham instanceof CayGayChienThan) {
                cayGayChienThan ++;
            }
        }

        if(chiecBuaThan >= 1 && baoTaySamSet >= 1 && honDaKichNo >=1 && cayGayChienThan >= 1 && cayGayChienThan >= 1) {
            return true;
        }
        else {
            return false;
        }
    }
    private double maxSoVang() {
        return listVatPhams.stream()
                    .mapToDouble(VatPham::tongSoVangQuyDoi)
                    .max()
                    .getAsDouble();
    }
    

    // Methods
    public void xuat() {
        for (VatPham vatPham : listVatPhams) {
            vatPham.xuat();
        }

        System.out.println("----------------");
        System.out.println("Cau 3");
        System.out.println("Vat pham ton nhieu vang nhat: " );
        thongTinVPcoMaxSoVang().xuat();
    }

    //Cau 3

    
    public void nhap4() {
        float vang = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(" --------------------");
        System.out.println("Cau 4");
        System.out.println("Nhap so vang Spon thu thap dc: ");

        try{
            vang = sc.nextFloat();
        } catch(InputMismatchException e) {
            thongBaoLoi.accept(e.getMessage());
        }
        
        if(vang >= tongtatCaSoVang()) {
            System.out.println("Spon giai cuu thanh cong");
        }
        else {
            System.out.println("Spon giai cuu that bai");
        }
    
    }

    private double tongtatCaSoVang() {
        return listVatPhams.stream()
                       .mapToDouble(VatPham::tongSoVangQuyDoi)
                       .sum();
    }
}
