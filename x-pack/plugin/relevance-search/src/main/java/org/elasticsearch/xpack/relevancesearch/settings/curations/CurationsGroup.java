/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.relevancesearch.settings.curations;

import org.elasticsearch.xpack.relevancesearch.query.RelevanceMatchQueryBuilder;
import org.elasticsearch.xpack.relevancesearch.settings.Settings;

import java.util.List;
import java.util.Optional;

public class CurationsGroup implements Settings {

    private final List<CurationSettings> curationSettings;

    public CurationsGroup(List<CurationSettings> curationSettings) {
        this.curationSettings = curationSettings;
    }

    public List<CurationSettings> getCurationSettings() {
        return curationSettings;
    }

    public Optional<CurationSettings> findMatching(RelevanceMatchQueryBuilder relevanceMatchQueryBuilder) {
        return getCurationSettings().stream().filter(settings -> settings.match(relevanceMatchQueryBuilder)).findFirst();
    }

}
