package ec.edu.espol.util;

import java.util.Arrays;

/**
 *
 * @author Francisco Mayancela
 */
public class Array {
    private int array[];

    public Array(int dim) {
        this.array = new int[dim];
    }

    public Array() {
        this.array = new int[10];
    }
    
    public int getSize ()
    {
        return this.array.length;
    }
    
    public void concat (Array newArray) 
    {
        int [] aux = this.array;
        this.array = new int[aux.length + newArray.getArray().length];
        int x = 0;
        for (int i = 0; i < aux.length; i++) {
            this.array[i] = aux[i];
            x ++;
        }
        
        for (int i = 0; i < newArray.getSize(); i++) {
            this.array[x++] = newArray.getArray()[i];
        }
    }
        
    public int get(int index) 
    {
        int elem = -1;
        try{
            for (int i = 0; i < this.getSize(); i++) {
                if(this.array[i] == this.array[index]){
                    elem = this.array[i];
                    break;
                }
            }
        }
        catch(Exception e){}        
        return elem;
    }
    
    public void set (int index, int n)
    {
       try{
            if(index >= 0 && index < this.getSize()) {
                System.out.println("Se cambio el número " + this.array[index] + " por " + n + " en el índice " + index);
                this.array[index] = n;
            }
       } catch(Exception e){}
    }
    
    public Array slicing (int start, int end)
    {
        try{
            if((start >= 0 && start < end) && end < this.getSize())
            {
                Array a = new Array(end - start);
                for (int i = 0; i < a.getSize(); i++) {
                    a.getArray()[i] = this.array[start + i];
                }
                return a;          
            }         
        }catch(Exception e){} 
        
        return null;
    }
    
    public int sum ()
    {
        int total = 0;
        for (int i = 0; i < this.getSize(); i++) {
            total += this.array[i];
        }
        return total;
    }
    
    public int max ()
    {
        int maximum = 0;
        for (int i = 0; i < this.getSize(); i++) {
            if(this.array[i] > maximum){
                maximum = this.array[i];
            }
        }
        return maximum;
    }
    
    public int min ()
    {
        return Arrays.stream(this.array)
            .min()               
            .orElse(0); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Array other = (Array) obj;
        if (!Arrays.equals(this.array, other.array)) {
            return false;
        }
        return true;
    }
 
    public int[] getArray() {
        return array;
    }
    
    @Override
    public String toString() {
        return "Array{" + "array=" + Arrays.toString(array) + '}';
    }

}
