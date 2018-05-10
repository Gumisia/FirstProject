import java.util.Map;
import java.util.TreeMap;

public class PriceList {

    private volatile static PriceList instance;
    static Map<String, Double[]> map;


    PriceList(){
        map  = new TreeMap<>();
    }

    public static PriceList getInstance(){
        if(instance == null){
            synchronized (PriceList.class){
                if(instance == null){
                    instance = new PriceList();
                }
            }
        }
        return instance;
    }

    public void put(String s, Double i){
        Double[] tab = {i};
        map.put(s,tab);
    }
    public void put(String s, double cena, double ilosc, double cena_2){
        Double[] tab = {cena, ilosc,cena_2};
        map.put(s,tab);

    }

    static public Double get(String s){
        if(map.get(s) == null){
            return -1.0;
        }


//        if(s.equals("róża")){
//            if(ShoppingCart.getFlower(s).getQuantity() > map.get(s)[1])
//                return map.get(s)[2];
//        }


        return  map.get(s)[0];
    }

    static public Double getSecondPrice(String s, ShoppingCart cart){
        if(cart.getFlower(s).getQuantity() > map.get(s)[1])
        return map.get(s)[2];

        return 0.0;
    }



}
