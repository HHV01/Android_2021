package vn.edu.tdmu.luuphuchung_073_cau2;

public class TacGia {
    private  int ID;
    private  String fullName;
    private  String Tel;
    private  String address;

    public TacGia() {
    }

    public TacGia(int ID, String fullName, String tel, String address) {
        this.ID = ID;
        this.fullName = fullName;
        Tel = tel;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return fullName + "-" + Tel + "-" + address;
    }
}
