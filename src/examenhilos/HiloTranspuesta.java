/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhilos;

/**
 *
 * @author nacho
 */
public class HiloTranspuesta extends Thread{ //Hereda de Thread
    public HiloTranspuesta(){ //Constructor vacío

        System.out.println(this.getName()+": Hilo generado");
    }
    public HiloTranspuesta(float [][]mat,float [][]tr,int fila, int col){ //Constructor_2
        this.Mat = mat;
        this.Tran = tr;
        this.fila = fila;
        this.col = col;
    }
    @Override
    public void run(){ //siempre definir como void y no recibe parámetros
            this.Tran[fila][col] = this.Mat[col][fila];
            System.out.println(this.getName()+": "+ "A["+fila+"]"+"["+col+"] = "+Tran[fila][col]);
    }
    float [][]Mat;
    float [][]Tran;
    int fila,col;
}