/*
 * Copyright (c) 2018 Santanu Sinha <santanu.sinha@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.appform.dropwizard.discovery.bundle.id.constraints.impl;

import io.appform.dropwizard.discovery.bundle.id.Id;
import lombok.var;

/**
 *
 */
public class JavaHashCodeBasedKeyPartitioner implements KeyPartitioner {

    private final int maxPartitions;

    public JavaHashCodeBasedKeyPartitioner(int maxPartitions) {
        this.maxPartitions = maxPartitions;
    }

    @Override
    public int partition(Id id) {
        var hashCode = id.getId().hashCode();
        hashCode *= hashCode < 0 ? -1 : 1;
        return hashCode % maxPartitions;
    }
}
