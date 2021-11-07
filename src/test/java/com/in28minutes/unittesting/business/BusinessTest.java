//package com.in28minutes.unittesting.business;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class BusinessTest {
//     @Test
//    void calcSum_empty() {
//        BusinessImpl business=new BusinessImpl();
//        business.setSomeDataService(new SomeEmptyDataServiceImpl());
//        int actualResult=business.calcSumData();
//        int expectedResult=0;
//        assertEquals(actualResult,expectedResult);
//    }
//    @Test
//    void calcSumDataService_empty() {
//        BusinessImpl business=new BusinessImpl();
//        business.setSomeDataService(new SomeDataServiceImple());
//
//        int actualResult=business.calcSumData();
//        int expectedResult=6;
//        assertEquals(actualResult,expectedResult);
//    }
//}
