import java.util.ArrayList;
import java.util.List;

public class Box {


    String customerName;

    List<Flower> flowers ;


    public Box(Customer customer){
        flowers = new ArrayList<>();
        customerName = customer.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pudelko właściciela " + customerName );


        for(Flower f : flowers){
            sb.append('\n').append(f.getName()).append(", ").append("kolor: " + f.getColor()).append(", ").append("ilość " + f.getQuantity()).append(", cena " + PriceList.get(f.getName()));
        }
        return sb.toString();
    }
}
