package Heap;

import java.util.Arrays;

interface Heap{
    void AdjustDown(int root,int len);
    public void initHeap(int[] array);
    void AdjustUp(int child,int len);
    void pushHeap(int item);
    int popHeap();
    int getHeapTop();
    void HeapSort();
    void show();
}
public class HeapTest implements Heap{
    private int[] elem;
    private int usedSize;
    private static final int DEFAULTSIZE=10;  //默认大小
    public HeapTest(){
        this.elem=new int[10];
        this.usedSize=0;
    }
    @Override
    public void AdjustDown(int root, int len) {  //向上调整
        int parent=root;
        int child=2*parent+1;  //左孩子
        //方法一：引入temp
//     int temp=elem[parent];  //将其放到temp中
//     for(int i=child;i<len;i=2*i+1){
//         if(i<len&&elem[i]<elem[i+1]){  //判断是否有右孩子(有右孩子)
//             i++;
//         }
//         if(elem[i]>temp){
//             elem[parent]=elem[i];
//             parent=i;
//         }else if(elem[i]<temp){
//             break;
//             elem[parent]=temp;
//         }
//     }
     //直接交换，不使用temp
     while(child<len){
         //判断是否有右孩子  找到最大值下标
             if(child+1<len&&this.elem[child]<this.elem[child+1]){
                 child++;
             }
             if(elem[child]>elem[parent]){
                 int temp=elem[child];
                 elem[child]=elem[parent];
                elem[parent]=temp;
                parent=child;
                child=2*parent+1;
             }
             else{
                 break;
             }
         }
     }


    @Override
    public void initHeap(int[] array) {  //初始化成大根堆
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;   //先放入数据
        }
        for (int i = (elem.length - 1 - 1) / 2; i >= 0; i--) {
            AdjustDown(i,this.usedSize);
        }
    }

    @Override
    public void AdjustUp(int child, int len) {  //child等于根节点才能结束
    int parent=(child-1)/2;
    while(child>0){
        if(elem[child]>elem[parent]){
            int temp=elem[child];
            elem[child]=elem[parent];
            elem[parent]=temp;
            child=parent;
            parent=(child-1)/2;
        }else{
            break;
        }
    }
    }
 private boolean isFull(){
        return this.usedSize==this.elem.length;
 }
    @Override
    public void pushHeap(int item) {
  if(isFull()){
      this.elem= Arrays.copyOf(this.elem,2*this.elem.length);
  }
  this.elem[this.usedSize]=item;
  this.usedSize++;
  AdjustUp(this.usedSize-1,this.usedSize);  //调整的下标，调整的长度
    }

    @Override
    public int popHeap() {
        if(this.usedSize==0){
            throw  new NullPointerException("堆为空");
        }
        int temp=elem[0];
        elem[0]=elem[this.usedSize-1];
        elem[this.usedSize-1]=temp;
        usedSize--;
        AdjustDown(0,usedSize);
        return 0;
    }

    @Override
    public int getHeapTop() {
        if(this.usedSize==0){
            throw  new NullPointerException("堆为空");
        }
        return this.elem[0];
    }

    @Override
    public void HeapSort() {
    int end=this.usedSize-1;
    while(end>0){
        int temp=this.elem[0];
        this.elem[0]=this.elem[end];
        this.elem[end]=temp;
        AdjustDown(0,end);
      end--;
    }

    }

    @Override
    public void show() {
    for(int i=0;i<this.usedSize;i++){
    System.out.print(elem[i]);
}
    }
}
