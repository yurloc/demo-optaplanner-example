/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.vrp.domain.timewindowed;

import com.example.vrp.domain.Depot;
import com.example.vrp.domain.location.Location;

public class TimeWindowedDepot extends Depot {

    // Times are multiplied by 1000 to avoid floating point arithmetic rounding errors
    private long readyTime;
    private long dueTime;

    public TimeWindowedDepot() {
    }

    public TimeWindowedDepot(long id, Location location, long readyTime, long dueTime) {
        super(id, location);
        this.readyTime = readyTime;
        this.dueTime = dueTime;
    }

    /**
     * @return a positive number, the time multiplied by 1000 to avoid floating point arithmetic rounding errors
     */
    public long getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(long readyTime) {
        this.readyTime = readyTime;
    }

    /**
     * @return a positive number, the time multiplied by 1000 to avoid floating point arithmetic rounding errors
     */
    public long getDueTime() {
        return dueTime;
    }

    public void setDueTime(long dueTime) {
        this.dueTime = dueTime;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
