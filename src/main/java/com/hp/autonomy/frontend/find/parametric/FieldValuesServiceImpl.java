/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.find.parametric;

import com.hp.autonomy.frontend.find.ApiKeyService;
import com.hp.autonomy.frontend.find.parametric.FieldValuesService;
import com.hp.autonomy.frontend.find.parametric.FieldValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FieldValuesServiceImpl implements FieldValuesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    public FieldValues getParametricValues(String index, String text, String fieldname, int max_values, String sort, String fieldtext) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("max_values", max_values);
        parameters.put("text", text);
        parameters.put("index", index);
        parameters.put("fieldname", fieldname);
        parameters.put("sort", sort);
        parameters.put("fieldtext", fieldtext);
        parameters.put("apikey", apiKeyService.getApiKey());

        return restTemplate.getForObject("https://api.idolondemand.com/1/api/sync/getparametricvalues/v1?apikey={apikey}&indexes={index}&sort={sort}&max_values={max_values}&field_name={fieldname}&text={text}&field_text={fieldtext}", FieldValues.class, parameters);

    }

}
