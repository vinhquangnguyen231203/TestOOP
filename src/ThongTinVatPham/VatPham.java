package ThongTinVatPham;

public class VatPham {
    //Instance Fields
    protected int chiSoSucManh;
    protected float heSoSucManh;
    protected int soVang;

    // Methods
    public float tinhSucCongPha() {
        return chiSoSucManh * heSoSucManh;
    }

    public float tongSoVangQuyDoi() {
        return this.tinhSucCongPha() * soVang;
    }
    
    public void xuat() {
        System.out.println("----------------");
        System.out.println("-- Ten: " + checkVatPham());
        System.out.println("-- Chi so suc manh: " + chiSoSucManh);
        System.out.println(" -- He so suc manh: " + heSoSucManh);
        System.out.println("-- Suc cong pha: " + tinhSucCongPha());
        System.out.println("-- So vang (quy doi/1 suc cong pha): " + tongSoVangQuyDoi());
    }
    private String checkVatPham() {
        if(this instanceof ChiecBuaThan) {
            return "Chiec bua than";
        }
        else if(this instanceof BaoTaySamSet) {
            return "Bao tay sam set";
        }
        else if(this instanceof HonDaKichNo) {
            return "Hon da kich no";
        }
        else if(this instanceof CayRiuPhepThuat) {
            return "Cay riu phep thuat";
        }
        else if(this instanceof CayGayChienThan) {
            return "Cay gay chien than";
        }
        else{
            return "";
        }
    }
}
