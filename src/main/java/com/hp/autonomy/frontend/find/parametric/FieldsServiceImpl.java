package com.hp.autonomy.frontend.find.parametric;

/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

import com.hp.autonomy.frontend.find.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FieldsServiceImpl implements FieldsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    public Fields retrieveIndexFields(String index, boolean group_fields_by_type, List<String> fieldtype, int max_values){
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("max_values", max_values);
        parameters.put("group_fields_by_type", group_fields_by_type);
        parameters.put("index", index);
        parameters.put("apikey", apiKeyService.getApiKey());

        final StringBuilder url = new StringBuilder("https://api.idolondemand.com/1/api/sync/retrieveindexfields/v1?apikey={apikey}&group_fields_by_type={group_fields_by_type}&index={index}&max_values={max_values}");

        for (final String aFieldtype : fieldtype) {
            try {
                url.append("&fieldtype=").append(URLEncoder.encode(aFieldtype, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError("UTF-8 not supported");
            }
        }

        return restTemplate.getForObject(url.toString(), Fields.class, parameters);
    }


}
