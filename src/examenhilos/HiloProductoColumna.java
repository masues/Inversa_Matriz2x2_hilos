/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhilos;

/**
 *
 * @author Mario Alberto Suarez Espinoza
 */
public class HiloProductoColumna extends Thread{
    int[][] matriz;
    int escalar;
    int columna;

    public HiloProductoColumna(int[][] matriz, int escalar, int columna) {
        this.matriz = matriz;
        this.escalar = escalar;
        this.columna = columna;
    }
    @Override
    public void run(){
        for(int i=0;i<matriz.length;i++){
            matriz[columna][i]=matriz[columna][i]*escalar;
            System.out.println(getName()+"["+i+"]"+"["+columna+"] = "+matriz[i][columna]);
        }
    }
}
