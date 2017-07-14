package org.springframework.samples.mvc.yc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/5.
 */
@RestController
@RequestMapping(value = "/post")
public class GetPostParameter {

    @RequestMapping(value = "/getParameterMap")
    public String getPostParameterMap(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String[] valueArray = entry.getValue();
            String values = "";
            for (String item : valueArray) {
                values += item + ",";
            }
            System.out.println(entry.getKey() + " = " + values);
        }
        return "OK";
    }
}
