/**
 * Created by john.underwood on 2/11/2015.
 */
/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.find.parametric;

import java.util.List;

public interface FieldValuesService {

    FieldValues getParametricValues(String index, String text, String fieldname, int max_values, String sort, String fieldtext);
}
