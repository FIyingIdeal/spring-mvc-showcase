package org.springframework.samples.mvc.yc;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/7.
 */
@RestController
@RequestMapping(value = "/initBinder")
public class InitBinderController {

    /*@InitBinder
    public void userDataBinding(WebDataBinder binder) {
        //binder.addValidators();
        *//*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(sdf, true));*//*

        //Spring MVC 4.2+
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }*/

    @RequestMapping(value = "/dateFormat", method = RequestMethod.POST)
    public InitBinderBean initBinderBeanTest(@Valid InitBinderBean bean) {
        System.out.println(bean);
        return bean;
    }

    @RequestMapping(value = "/pathvariable/dateFormat/{date}")
    public String pathVariableDateFormatterTest(@PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        System.out.println(date);
        return "1";
    }
}
