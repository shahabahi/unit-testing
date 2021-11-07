package com.in28minutes.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {


    @Test
    public void learning() {
    String responseFromService="[" +
            "    {\"id\":10001,\"name\":\"Pencil\",\"quantity\":5}," +
            "    {\"id\":10002,\"name\":\"Pen\",\"quantity\":15}," +
            "    {\"id\":10003,\"name\":\"Eraser\",\"quantity\":10}," +
            "    ]";
        DocumentContext parse = JsonPath.parse(responseFromService);
        int length=parse.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids=parse.read("$..id");
        assertThat(ids).containsExactly(10001,10002,10003);
        System.out.println(ids.get(0));
        System.out.println(parse.read("$.[1]").toString());
        System.out.println(parse.read("$.[0:2]").toString());
        System.out.println(parse.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(parse.read("$.[?(@.quantity==5)]").toString());
    }

}
