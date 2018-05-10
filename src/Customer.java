import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    String name;
    double money;
    ShoppingCart myCart;

    List<Flower> flowers = new ArrayList<>();

    Customer(String name, double money){
        this.name = name;
        this.money = money;
    }

    public void get(Flower flower){
        flowers.add(flower);
    }

    public ShoppingCart getShoppingCart(){
        return  myCart = new ShoppingCart(flowers, name);
    }

    public void pay(boolean cash) throws NullPointerException{
        double prowizja = 1.0;

        if(!cash){
            prowizja= 1.01;
        }
        Iterator<Flower> itr = flowers.iterator();

        while (itr.hasNext()){
            Flower flower = itr.next();
            double cena;

            try{


                cena = PriceList.get(flower.name);
            }catch (NullPointerException e){
                System.out.println("brak ceny" + flower.name);
                cena = 0;
            }

            if( cena > 0 ){
                double kosztKwiatow  = flower.getQuantity() * cena * prowizja;

                if(money > kosztKwiatow){
                    money-= kosztKwiatow;
                }
            }
        }

        itr = flowers.iterator();
        while (itr.hasNext()){
            Flower flower = itr.next();
            double cena;

            try{
                cena = PriceList.get(flower.name);
            }catch (NullPointerException e){
                System.out.println("brak ceny" + flower.name);
                cena = 0;
            }
            if( cena < 0 ){
                flowers.remove(flower);
            }

        }
    }

    public double getCash(){
        return money;
    }

    public void pack(Box box){
        box.flowers.addAll(myCart.flowers);
        myCart.flowers.removeAll(flowers);
    }
}
