/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.find.parametric;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(builder = FieldValues.Builder.class)
@Data
public class FieldValues {

    private final Map<String, Map<String, Integer>> fields;

    private FieldValues(final Map<String, Map<String, Integer>> fields) {
        this.fields = fields;
    }

    @JsonAnyGetter
    public Map<String, Map<String, Integer>> getFields() {
        return fields;
    }

    @JsonPOJOBuilder
    public static class Builder {

        private final Map<String, Map<String, Integer>> fields = new HashMap<>();

        @JsonAnySetter
        public void foo(final String fieldName, final Map<String, Integer> fieldValues) {
            fields.put(fieldName, fieldValues);
        }

        public FieldValues build() {
            return new FieldValues(fields);
        }
    }

}
