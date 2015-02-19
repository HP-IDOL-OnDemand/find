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
@RequestMapping("/api/search/find-similar")
public class SimilarDocumentsController {

    @Autowired
    private SimilarDocumentsService similarDocumentsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Document> query(
        @RequestParam("reference") final String reference,
        @RequestParam("max_results") final int maxResults,
        @RequestParam("summary") final String summary,
        @RequestParam("index") final String index
    ) {
        return similarDocumentsService.findSimilar(reference, maxResults, summary, index);
    }

}
