package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class BusinessMockTest {

    @InjectMocks
    BusinessImpl business;

    @Mock
    SomeDataService someDataMockService;

    @Test
    void calcSum_empty() {
        when(someDataMockService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calcSumData());
    }

    @Test
    void calcSumDataService_empty() {

        when(someDataMockService.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, business.calcSumData());
        verify(someDataMockService,times(2)).retrieveAllData();
    }
}
