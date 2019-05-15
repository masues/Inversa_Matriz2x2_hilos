/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario Alberto Suarez Espinoza
 */
public class HiloProductoEscalar extends Thread{
    float [][]matriz;
    float escalar;

    public HiloProductoEscalar(float[][] matriz, float escalar) {
        this.matriz = new float[2][2];
        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz[i].length;j++){
                this.matriz[i][j]=matriz[i][j];
            }
        }
        this.escalar = escalar;
    }
    @Override
    public void run(){
        System.out.println(this.getName()
                +": Generando hilos para el cálculo del producto escalar...");
        HiloProductoColumna []columnas = new HiloProductoColumna[matriz.length];
        for(int i=0;i<columnas.length;i++){
            columnas[i]=new HiloProductoColumna(matriz,escalar,i);
            columnas[i].start();
            try {
                columnas[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloProductoEscalar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
