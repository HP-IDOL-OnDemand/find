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
public class SimilarDocumentsServiceImpl implements SimilarDocumentsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    public List<Document> findSimilar(final String reference, final int maxResults, final String summary, final String indexes) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("reference", reference);
        parameters.put("max_results", maxResults);
        parameters.put("summary", summary);
        parameters.put("indexes", indexes);
        parameters.put("apikey", apiKeyService.getApiKey());

        return restTemplate.getForObject("https://api.idolondemand.com/1/api/sync/findsimilar/v1?apikey={apikey}&max_results={max_results}&index_reference={reference}&summary={summary}&index={indexes}", Documents.class, parameters).getDocuments();
    }
}
