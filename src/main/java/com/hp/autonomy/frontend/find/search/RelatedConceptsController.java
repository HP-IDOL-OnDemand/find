/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.find.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/search/find-related-concepts")
public class RelatedConceptsController {

    @Autowired
    private RelatedConceptsService relatedConceptsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Entity> findRelatedConcepts(
            @RequestParam("text") final String text,
            @RequestParam(value = "index") final String index,
            //naive field text parameter constructor. Expects 'String' of type <Operation>{<Value>}:<field,field,..>
            @RequestParam(value = "fieldtext", required = false) final String fieldtext
    ) {
        return relatedConceptsService.findRelatedConcepts(text, index, fieldtext);
    }

}
