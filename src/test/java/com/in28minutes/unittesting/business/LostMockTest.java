package com.in28minutes.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class LostMockTest {
    //۱۳
    @Mock
    List<String> mock1 = mock(List.class);

    @Test
    public void basicSize() {

        when(mock1.size()).thenReturn(5);
        assertEquals(5, mock1.size());
    }

    @Test
    public void listSize() {
        when(mock1.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock1.size());
        assertEquals(10, mock1.size());
    }

    @Test
    public void listGet() {
        when(mock1.get(0)).thenReturn("Hi Guys");
        assertEquals("Hi Guys", mock1.get(0));
        assertEquals(null, mock1.get(1));
    }

    @Test
    public void listGetGenericParameter() {
        when(mock1.get(anyInt())).thenReturn("Hi Guys");
        assertEquals("Hi Guys", mock1.get(0));
        assertEquals("Hi Guys", mock1.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mock1.get(0);
        String value2 = mock1.get(1);
        //verify
        verify(mock1).get(0);
        verify(mock1, times(2)).get(anyInt());
        verify(mock1, atLeast(1)).get(anyInt());
        verify(mock1, atLeastOnce()).get(anyInt());
        verify(mock1, atMost(2)).get(anyInt());
        verify(mock1, never()).get(2);

    }

    @Test
    public void argumentCapturing() {
        mock1.add("Some String1");
        mock1.add("Some String2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        //to capture arguments that passed into add method
        verify(mock1, times(2)).add(captor.capture());
        //get 2 method input parameters
        List<String> allValues = captor.getAllValues();
        assertEquals("Some String1", allValues.get(0));
        assertEquals("Some String2", allValues.get(1));
    }
    @Test
    public void mocking(){
        ArrayList arrayList =mock(ArrayList.class);
        System.out.println(arrayList.get(0));//null
        System.out.println(arrayList.size());//0
        arrayList.add("test1");
        arrayList.add("test2");
        System.out.println(arrayList.size());//0
        when(arrayList.size()).thenReturn(5);
        System.out.println(arrayList.size());//5
    }
    @Test
    public void spying(){
        //As we can see, adding an element into the mocked list doesn't actually add anything,
        // it just calls the method with no other side-effects.
        //A spy, on the other hand, will behave differently; it will actually call the real implementation of
        // the add method and add the element to the underlying list:
        ArrayList arrayList =spy(ArrayList.class);
        arrayList.add("test0");
        System.out.println(arrayList.get(0));//test0
        System.out.println(arrayList.size());//1
        arrayList.add("test1");
        arrayList.add("test2");
        System.out.println(arrayList.size());//3
        when(arrayList.size()).thenReturn(5);
        System.out.println(arrayList.size());//5
        arrayList.add("test3");
        System.out.println(arrayList.size());//5
        arrayList.add("test3");
        System.out.println(arrayList.size());//5
        System.out.println(arrayList);
    }
}
