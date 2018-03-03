public class Table {

    private int id;
    private double bill;

    public Table(int id){
        this.id = id;

    }

    public double getBill(){
        return this.bill;
    }

    public void setBill(double newbill){
        this.bill = newbill;
    }

    public void resetBill(){
        this.setBill(0.0);
    }

    public void printBill(){
        System.out.println(this.bill);
    }


}
