/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.find.search;

import java.util.List;

public interface SimilarDocumentsService {

    List<Document> findSimilar(String reference, int maxResults, String summary, String indexes);

}
