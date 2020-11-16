package cookies.customer;

import java.util.HashMap;
//还没完成 想要建立一个地址列表，根据用户输入地址，来判断，能不能配送
public class Address {
    private String address;
    private double[] position = {0,0};
    public Address(String address,double[] position){
        this.address=address;
        this.position=position;
    }
    //public HashMap<String,double[]>listOfAdress=new HashMap<>();

    public String getAddress() {
        return address;
    }

    public double[] getPosition() {
        return position;
    }
}
