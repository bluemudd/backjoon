class TV{
    int size;
    public TV(int size) {this.size=size;}
    protected int getSize(){return size;}
}

class ColorTV extends TV {
    int resolution;
    ColorTV(int size, int resolution) {
        super(size);
        this.resolution = resolution;
    }
//    public void printProperty() {
//        System.out.print(getSize()+"인치 "+resolution+"컬러");
//    }
}
class IPTV extends ColorTV{
    private String IP;
    IPTV(String IP, int size, int resolution){
        super(size, resolution);
        this.IP=IP;
    }
    void printProperty(){
        System.out.println("나의 IPTV는 "+IP+"주소의 "+super.size+"인치 "
                +super.resolution+"컬러");

    }
}
public class Main{
    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048); //"192.1.1.2" 주소에 32인치, 2048컬러
        iptv.printProperty();
    }
}