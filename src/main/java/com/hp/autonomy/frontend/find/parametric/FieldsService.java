package com.hp.autonomy.frontend.find.parametric;

/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

import java.util.List;

public interface FieldsService {

    Fields retrieveIndexFields(String index, boolean group_fields_by_type, List<String> fieldtype, int max_values);
}
