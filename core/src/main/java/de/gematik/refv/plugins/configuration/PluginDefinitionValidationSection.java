/*
Copyright (c) 2022-2024 gematik GmbH

Licensed under the Apache License, Version 2.0 (the License);
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an 'AS IS' BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.gematik.refv.plugins.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.gematik.refv.commons.configuration.ValidationMessageTransformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PluginDefinitionValidationSection {
    @NonNull
    private String fhirPackage = "";
    private List<String> dependencies = new LinkedList<>();
    private boolean errorOnUnknownProfile;
    private boolean anyExtensionsAllowed;
    private List<String> acceptedEncodings = new LinkedList<>();
    private List<ValidationMessageTransformation> validationMessageTransformations = new LinkedList<>();
    private List<String> ignoredCodeSystems = new LinkedList<>();
    private List<String> ignoredValueSets = new LinkedList<>();
}

