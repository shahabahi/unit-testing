package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.data.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class BusinessImpl {
    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calcSumData(){
        int sum=0;
        int[] data=someDataService.retrieveAllData();
        int[] data1=someDataService.retrieveAllData();

        return Arrays.stream(data).reduce(Integer::sum).orElse(0);

//        for (int val:data){
//            sum+=val;
//        }
//        return sum;
    }
}
