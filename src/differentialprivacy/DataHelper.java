package differentialprivacy;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
    private List<Integer> array;
    private int maxValue, size;
    /**
     * constructor
     * @param maxValue
     * @param size 
     */
    public DataHelper(int maxValue, int size)
    {
        this.maxValue = maxValue;
        this.size = size;
        this.array = new ArrayList<>();
    }
    /**
     * genere un tableau d'entiers de taille 'size' avec 'maxValue' designant
     * la valeur maximale que peut prendre chaque element du tableau
     * @param maxValue
     * @param size 
     */
    public  List<Integer> generate()
    {
        for(int i = 0; i<this.size; i++)
            this.array.add(ThreadLocalRandom.current().nextInt(this.maxValue+1));
        System.out.println(Arrays.toString(this.array.toArray(new Integer[this.array.size()]))+"\n");
        return array;
    }
    
    /**
     * Aggregat
     * retourne le nombre de valeurs du tableau superieures à m/2
     * m designant la valeur maximale que peut prendre chaque element du tableau
     * @return 
     */
    public  int COUNT(){
        int count = 0;
        for(Integer value : this.array)
            if(value > this.maxValue/2)
                count++;
        return count;
    }
    
    /**
     * Aggregat
     * retourne la somme des valeurs du tableau superieures à m/2
     * m designant la valeur maximale que peut prendre chaque element du tableau
     * @return 
     */
    public int SUM(){
        int count = 0;
        for(Integer value : this.array)
            if(value > this.maxValue/2)
                count+=value;
        return count;
    }
}
