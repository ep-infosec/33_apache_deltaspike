/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.deltaspike.jsf.api.config.base;

import org.apache.deltaspike.core.api.config.ConfigResolver;
import org.apache.deltaspike.core.api.config.base.DeltaSpikeBaseConfig;
import org.apache.deltaspike.core.api.config.base.CoreBaseConfig;
import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;

public interface JsfBaseConfig extends DeltaSpikeBaseConfig
{
    interface ViewConfigCustomization
    {
        String CUSTOM_DEFAULT_BASE_PATH_BUILDER = ConfigResolver.resolve(View.DefaultBasePathBuilder.class.getName())
                .withCurrentProjectStage(true)
                .getValue();

        String CUSTOM_DEFAULT_FILE_NAME_BUILDER = ConfigResolver.resolve(View.DefaultFileNameBuilder.class.getName())
                .withCurrentProjectStage(true)
                .getValue();

        String CUSTOM_DEFAULT_EXTENSION_BUILDER = ConfigResolver.resolve(View.DefaultExtensionBuilder.class.getName())
                .withCurrentProjectStage(true)
                .getValue();

        String CUSTOM_DEFAULT_FOLDER_NAME_BUILDER = ConfigResolver
                .resolve(Folder.DefaultFolderNameBuilder.class.getName())
                .withCurrentProjectStage(true)
                .getValue();
    }

    interface ScopeCustomization
    {
        interface WindowRestriction
        {
            int ID_MAX_LENGTH_DEFAULT = 10;

            Integer MAX_COUNT =
                ConfigResolver.resolve(CoreBaseConfig.ScopeCustomization.WindowRestriction.MAX_COUNT_KEY)
                    .as(Integer.class)
                    .withCurrentProjectStage(true)
                    .withDefault(64)
                    .getValue();

            //10 is enough for the integer generated by DefaultClientWindow#generateNewWindowId - see DELTASPIKE-752
            Integer ID_MAX_LENGTH = ConfigResolver.resolve("deltaspike.window-id.max_length")
                    .as(Integer.class)
                    .withCurrentProjectStage(true)
                    .withDefault(ID_MAX_LENGTH_DEFAULT)
                    .getValue();
        }

        interface ViewDelegation
        {
            Boolean DELEGATE_TO_JSF = ConfigResolver.resolve("deltaspike.scope.view.delegate")
                    .as(Boolean.class)
                    .withCurrentProjectStage(true)
                    .withDefault(Boolean.TRUE)
                    .getValue();
        }
    }
}
