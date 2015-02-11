/*
 * Copyright (C) 2007-2014, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.model;

import com.gooddata.gdc.AbstractTaskStatus;
import com.gooddata.gdc.GdcError;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Collection;
import java.util.Collections;

/**
 * MAQL DDL asynchronous task status.
 * Deserialization only.
 */
class MaqlDdlTaskStatus extends AbstractTaskStatus {


    @JsonCreator
    private MaqlDdlTaskStatus(@JsonProperty("status") String status, @JsonProperty("poll") String pollUri,
                              @JsonProperty("messages") Collection<GdcError> messages) {
        super(status, pollUri, messages);
    }

    MaqlDdlTaskStatus(String status, String pollUri) {
        this(status, pollUri, Collections.<GdcError>emptyList());
    }

}
