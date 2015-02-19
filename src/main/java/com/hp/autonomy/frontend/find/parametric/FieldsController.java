package com.hp.autonomy.frontend.find.parametric;

/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/parametric/retrieve-index-fields")
public class FieldsController {

    @Autowired
    private FieldsService fieldsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Fields list(
            @RequestParam("index") final String index,
            @RequestParam("group_fields_by_type") final boolean group_fields_by_type,
            @RequestParam("fieldtype[]") final List<String> fieldtype,
            @RequestParam("max_values") final int max_values
    ) {
        return fieldsService.retrieveIndexFields(index, group_fields_by_type, fieldtype, max_values);
    }
}
