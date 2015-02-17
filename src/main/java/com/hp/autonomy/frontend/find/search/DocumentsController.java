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
@RequestMapping("/api/search/query-text-index")
public class DocumentsController {

    @Autowired
    private DocumentsService documentsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Document> query(
        @RequestParam("text") final String text,
        @RequestParam("max_results") final int maxResults,
        @RequestParam("summary") final String summary,
        @RequestParam("index") final String index,
        //naive field text parameter constructor. Expects 'String' of type <Operation>{<Value>}:<field,field,..>
        @RequestParam(value = "fieldtext", required = false) final String fieldtext,
        @RequestParam(value = "print", required = false) final String print,
        @RequestParam(value = "print_fields", required = false) final String print_fields
    ) {
        return documentsService.queryTextIndex(text, maxResults, summary, index, fieldtext, print, print_fields);
    }

}
