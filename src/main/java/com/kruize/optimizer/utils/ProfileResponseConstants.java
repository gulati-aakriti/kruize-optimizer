/*******************************************************************************
 * Copyright (c) 2026 IBM Corporation and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.kruize.optimizer.utils;

/**
 * Constants for profile response error messages from Kruize API
 * Used for parsing and handling API responses
 */
public final class ProfileResponseConstants {

    private ProfileResponseConstants() {
        throw new UnsupportedOperationException("Utility class");
    }

    // Error messages returned by Kruize API (used for parsing responses)
    public static final String NO_METADATA_PROFILES_FOUND_ERROR = "No metadata profiles found!";
    public static final String NO_METRIC_PROFILES_FOUND_ERROR = "No metric profiles found!";
    public static final String NO_LAYERS_FOUND_ERROR = "No layers found!";
}
