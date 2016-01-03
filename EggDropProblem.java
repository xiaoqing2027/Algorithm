/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.test;

/**
 *
 * @author miaodonghan
 */
public class EggDropProblem {
  public static int eggDrop(int k, int e){
    if(k == 1 || k == 0){
      return k;
    }
    
    if(e == 1){
      return k;
    }
    int minTimes = k;
    int n ;
    int temp = 0;
    for(n=1;n<=k;n++){
      
      temp = max(eggDrop(n-1,e-1),eggDrop(k-n,e));
      //System.out.println("mm"+temp+n);
      if(temp < minTimes){
        minTimes = temp;
      }
    }
    
    
    return minTimes+1;
  }
  
  public static int eggdrop2(int e, int k){
    
    //int eggFloor[i][j];
    
    return 0;
  }
  
  public static int max(int a, int b){
    if(a > b){
      return a;
    }else{
      return b;
      
    }
  }
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
   
    System.out.println(EggDropProblem.eggDrop(10, 2));
    
  }

 
  
}
