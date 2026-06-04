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
package com.kruize.optimizer.service;

import com.kruize.optimizer.model.kruize.KruizeProfile;
import com.kruize.optimizer.model.kruize.KruizeStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for aggregating Kruize system status
 */
@ApplicationScoped
public class StatusService {

    private static final Logger LOG = Logger.getLogger(StatusService.class);

    @Inject
    DatasourceService datasourceService;

    @Inject
    ProfileService profileService;

    @Inject
    KruizeStateService kruizeStateService;

    /**
     * Convert KruizeProfile list to ProfileInfo list
     *
     * @param profiles list of KruizeProfile
     * @return list of ProfileInfo
     */
    private List<KruizeStatus.ProfileInfo> convertToProfileInfo(List<KruizeProfile> profiles) {
        return profiles.stream()
                .map(p -> new KruizeStatus.ProfileInfo(
                        p.getName(),
                        p.getProfileVersion()
                ))
                .collect(Collectors.toList());
    }

    /**
     * Check if Kruize service is healthy
     *
     * @return true if healthy, false otherwise
     */
    public boolean isKruizeHealthy() {
        return datasourceService.isKruizeAvailable();
    }
}
