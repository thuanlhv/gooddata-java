/*
 * Copyright (C) 2004-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.model;

import org.testng.annotations.Test;

import static com.gooddata.util.ResourceUtils.readObjectFromResource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaqlDdlLinksTest {

    @SuppressWarnings("deprecation")
    @Test
    public void testDeserialization() throws Exception {
        final MaqlDdlLinks maqlDdlLinks = readObjectFromResource("/model/maqlDdlLinks.json", MaqlDdlLinks.class);

        assertThat(maqlDdlLinks, is(notNullValue()));
        assertThat(maqlDdlLinks.getStatusLink(), is("/gdc/md/PROJECT_ID/tasks/123/status"));
        assertThat(maqlDdlLinks.getStatusUri(), is("/gdc/md/PROJECT_ID/tasks/123/status"));
    }
}