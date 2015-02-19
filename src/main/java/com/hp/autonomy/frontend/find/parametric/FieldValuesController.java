/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.find.parametric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/parametric/get-parametric-values")
public class FieldValuesController {

    @Autowired
    private FieldValuesService fieldValuesService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public FieldValues list(
            @RequestParam("index") final String index,
            @RequestParam("text") final String text,
            @RequestParam("fieldname") final String fieldname,
            @RequestParam("max_values") final int max_values,
            @RequestParam("sort") final String sort,
            //naive field text parameter constructor. Expects 'String' of type <Operation>{<Value>}:<field,field,..>
            @RequestParam(value = "fieldtext", required = false) final String fieldtext
    ) {
        return fieldValuesService.getParametricValues(index, text, fieldname, max_values, sort, fieldtext);
    }
}
