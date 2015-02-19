/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.find.search;

import com.hp.autonomy.frontend.find.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentsServiceImpl implements DocumentsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    public List<Document> queryTextIndex(final String text, final int maxResults, final String summary, final String indexes, final String fieldtext, final String print, final String print_fields) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("text", text);
        parameters.put("max_results", maxResults);
        parameters.put("summary", summary);
        parameters.put("indexes", indexes);
        parameters.put("fieldtext", fieldtext);
        parameters.put("print", print);
        parameters.put("print_fields", print_fields);
        parameters.put("apikey", apiKeyService.getApiKey());

        return restTemplate.getForObject("https://api.idolondemand.com/1/api/sync/querytextindex/v1?apikey={apikey}&max_results={max_results}&text={text}&summary={summary}&indexes={indexes}&field_text={fieldtext}&print={print}&print_fields={print_fields}", Documents.class, parameters).getDocuments();
    }
}
