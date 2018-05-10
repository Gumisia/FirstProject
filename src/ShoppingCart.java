import java.util.List;

public class ShoppingCart {

    String customerName;

    static List<Flower> flowers ;

    ShoppingCart(List<Flower> flowers, String customerName){
        this.customerName = customerName;
        ShoppingCart.flowers = flowers;
    }

     public Flower getFlower(String name){

        Flower flower;
        for(Flower f: flowers){
            if(f.name.equals(name)) {
                flower = f;
                return flower;
            }
        }
        return new Rose(6);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wózek właściciela " + customerName );
        if(flowers.size() == 0){
            sb.append(" -- pusto");
        }
        else{
            for(Flower f : flowers){
                sb.append('\n').append(f.getName()).append(", ").append("kolor: " + f.getColor()).append(", ").append("ilość " + f.getQuantity()).append(", cena " + PriceList.get(f.getName()));
            }
        }


        return sb.toString();
    }
}
