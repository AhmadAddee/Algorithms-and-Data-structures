package com.example.algo_0.labb2;

import com.example.algo_0.f4.CircleArrayQueue_2023;

import java.util.Timer;

public class upp_4<E>{
    private CircleArrayQueue_2023<String> land;
    private CircleArrayQueue_2023<String> takeOff;

    Timer timer;
    public upp_4(){
        land = new CircleArrayQueue_2023<String>(10);
        takeOff = new CircleArrayQueue_2023<String>(10);
        runWay();
    }

    private void runWay(){
        land.offer("landing 1");
        takeOff.offer("Take off 1");
    }

    public static void main(String [] args){
        upp_4<String> upp4 = new upp_4<>();
    }

//    if(rand<0.05) plan vill landa
//if(time ==5) plan vill landa
//if(time == 10) starta


}
