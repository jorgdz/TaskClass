package ec.edu.espol.util;

import java.util.Arrays;

/**
 *
 * @author Francisco Mayancela
 */
public class Matriz {

    private int matriz [][];
    
    public Matriz(int filas, int colum) {
        this.matriz = new int [filas][colum];
    }

    public Matriz(int v) {
        this.matriz = new int [v][v];
    }
    
    public Matriz() {
        this.matriz = new int [10][10];
    }
    
    public int getFilas ()
    {
        return this.matriz.length;
    }
    
    public int getColumnas ()
    {
        return this.matriz[0].length;
    }
    
    public Matriz concat (Matriz mat, int opt) 
    { 
        Matriz matAux = null;
        
        // Concatenación horizontal (Filas)
        if(opt == 1)
        {
            if(mat.getColumnas() == this.getColumnas())
            {
                matAux = new Matriz((this.getFilas() + mat.getFilas()), this.getColumnas());
                int x = 0;
                for (int i = 0; i < this.getFilas(); i++) {
                    for (int j = 0; j < matAux.getColumnas(); j++) {
                        matAux.getMatriz()[i][j] = this.getMatriz()[i][j];
                    }    
                    x++; 
                }

                for (int i = 0; i < mat.getFilas(); i++) {
                    for (int j = 0; j < this.getColumnas(); j++) {
                        matAux.getMatriz()[x+i][j] = mat.getMatriz()[i][j];
                    }
                }
            }
        }
        
        // Concatenación vertical (Columnas)
        if(opt == 0)
        {
            if(mat.getFilas() == this.getFilas())
            {
                matAux = new Matriz(this.getFilas(), (this.getColumnas() + mat.getColumnas()));
                for (int i = 0; i < matAux.getFilas(); i++) {
                    int y = 0;
                    for (int j = 0; j < this.getColumnas(); j++) {
                        matAux.getMatriz()[i][j] = this.getMatriz()[i][j];
                        y++;
                    }
                    for (int j = 0; j < mat.getColumnas(); j++) {
                        matAux.getMatriz()[i][y++] = mat.getMatriz()[i][j];
                    }
                }
            }
        }
       
        return matAux;
    }
    
    public int get (int indexFila, int indexCol)
    {
        int n = -1;
        try{
            for (int i = 0; i < this.getFilas(); i++) {
                for (int j = 0; j < this.getColumnas(); j++) {
                    if(this.matriz[i][j] == this.matriz[indexFila][indexCol])
                    {
                        n = this.matriz[i][j];
                        break;
                    }
                }
            }
        }catch(Exception e){}
        return n;
    }

    public void set (int fila, int col, int value)
    {
        try{
            if((fila >= 0 && fila < this.getFilas()) && (col >= 0 && col < this.getColumnas())) this.matriz[fila][col] = value;
        } catch(Exception e){}
    }
    
    public Matriz slicing (int startRow, int endRow, int startCol, int endCol)
    {
        try{
            if((startRow >= 0 && startRow < endRow) && (startCol >= 0 && startCol < endCol) && (endRow < this.getFilas() && endCol < this.getColumnas()))
            {
                Matriz mat = new Matriz((endRow - startRow), (endCol - startCol));
                for (int i = 0; i < mat.getFilas(); i++) {
                    for (int j = 0; j < mat.getColumnas(); j++) {
                        mat.getMatriz()[i][j] = this.matriz[startRow + i][startCol + j];
                    }
                }
                return mat;
            }         
        }catch(Exception e){} 
        
        return null;
    }
    
    public int sum () {
        int total = 0;
        for (int i = 0; i < this.getFilas(); i++) {
            for (int j = 0; j < this.getColumnas(); j++) {
                total += this.matriz[i][j];
            }
        }
        return total;
    }
    
    public int max () {
        int maximum = 0;
        for (int i = 0; i < this.getFilas(); i++) {
            for (int j = 0; j < this.getColumnas(); j++) {
                if(this.matriz[i][j] > maximum){
                    maximum = this.matriz[i][j];
                }
            }
        }
        return maximum;
    }
    
    public int min () {
        int minimum = this.matriz[1][1];
        for (int i = 0; i < this.getFilas(); i++) {
            for (int j = 0; j < this.getColumnas(); j++) {
                if(i != 1 && j != 1)
                {
                    if(this.matriz[i][j] < minimum){
                        minimum = this.matriz[i][j];
                    }
                }
            }
        }
        
        return minimum;
    }
    
    public int diagonal ()
    {
        int sum = 0;
        if(this.getFilas() == this.getColumnas())
        {
            for (int i = 0; i < this.getFilas(); i++) {
                for (int j = 0; j < this.getColumnas(); j++) {
                    if(i == j)
                    {
                        sum += this.matriz[i][j];
                    }
                }
            }
            return sum;
        }
        else{
            return -1;
        }   
    }
    
    public Matriz transpuesta ()
    {
        Matriz mat = null;
        if(this.getFilas() == this.getColumnas())
        {
            mat = new Matriz(this.getFilas(), this.getColumnas());
            for (int i = 0; i < this.getFilas(); i++) {
                for (int j = 0; j < this.getColumnas(); j++) {
                    mat.getMatriz()[i][j] = this.matriz[j][i];
                }
            }
        }
        return mat;
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
        final Matriz other = (Matriz) obj;
        if (!Arrays.deepEquals(this.matriz, other.matriz)) {
            return false;
        }
        return true;
    }
    
    public int[][] getMatriz() {
        return matriz;
    }

    @Override
    public String toString() {
        return "Matriz{" + "matriz=" + Arrays.deepToString(this.matriz) + '}';
    }
}
