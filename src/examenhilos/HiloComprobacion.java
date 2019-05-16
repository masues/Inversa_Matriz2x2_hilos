/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhilos;

/**
 *
 * @author ASUS
 */
public class HiloComprobacion extends Thread{
    
    float M[][];
    float Minv[][];
    int r, c;
    float a = 0;
    
    public HiloComprobacion(float [][]M, float[][]Minv, int r, int c){
        this.M = M;
        this.Minv = Minv;
        this.r = r;
        this.c = c;
    }
    
    public void run(){
        
        for(int i=0; i<M.length; i++){
            a = a + (M[r][i]*Minv[i][c]);
        }
        System.out.println(getName()+": A["+r+"]["+c+"] = "+a);
    }
    
}
