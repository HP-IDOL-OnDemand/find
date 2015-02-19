package com.hp.autonomy.frontend.find.parametric;

/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@JsonDeserialize(builder = Fields.Builder.class)
public class Fields {
    private final String index_name;
    private final List<String> all_fields;

    private Fields(final String index_name, final List<String> all_fields) {
        this.index_name = index_name;
        this.all_fields = all_fields;
    }

    @Setter
    @JsonPOJOBuilder(withPrefix = "set")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {

        private String index_name;
        private List<String> all_fields;

        public Fields build() {
            return new Fields(index_name, all_fields);
        }

    }
}
