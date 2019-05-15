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
public class HiloGenAdjunta extends Thread{ //Hereda de Thread
    public HiloGenAdjunta(){ //Constructor vacío

        System.out.println(this.getName()+": Hilo generado");
    }
    public HiloGenAdjunta(float [][]mat, float adj[][]){ //Constructor_2
        this.Mat = mat;
        this.Adj = adj;
        
    }
    @Override
    public void run(){ //siempre definir como void y no recibe parámetros
        int cont=0;
        System.out.println(this.getName() +": Generando hilos para el cálculo de la adjunta...");
        HiloAdjunta []matHiloAdj = new HiloAdjunta[Mat.length*Mat.length];
        for (int fila = 0; fila < Mat.length ; fila++) {
           for (int col = 0; col < Mat.length; col++) {
               matHiloAdj[cont] = new HiloAdjunta(this.Mat,this.Adj,fila,col);
               matHiloAdj[cont].start();
               try{
                matHiloAdj[cont].join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
               cont++;
            }
        }
    }
    float [][]Mat;
    float [][]Adj;
    
}