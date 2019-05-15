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
public class HiloProductoEscalar extends Thread{
    int [][]matriz;
    int escalar;

    public HiloProductoEscalar(int[][] matriz, int escalar) {
        this.matriz = new int[2][2];
        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz[i].length;j++){
                this.matriz[i][j]=matriz[i][j];
            }
        }
        this.escalar = escalar;
    }
    @Override
    public void run(){
        HiloProductoColumna []columnas = new HiloProductoColumna[matriz.length];
        for(int i=0;i<columnas.length;i++){
            columnas[i]=new HiloProductoColumna(matriz,escalar,i);
            columnas[i].start();
        }
    }
}
