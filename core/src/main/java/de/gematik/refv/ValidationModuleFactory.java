/*
 * Copyright (c) 2023 gematik GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the License);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.gematik.refv;

import ca.uhn.fhir.context.FhirContext;
import de.gematik.refv.commons.exceptions.ValidationModuleInitializationException;
import de.gematik.refv.commons.validation.BaseValidationModule;
import de.gematik.refv.commons.validation.GenericValidator;
import de.gematik.refv.plugins.validation.PluginValidationResourceProvider;
import de.gematik.refv.commons.validation.ValidationModule;
import de.gematik.refv.commons.validation.IntegratedValidationModule;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;


@NoArgsConstructor
@Slf4j
public class ValidationModuleFactory {

    public ValidationModule createValidationModuleFromPlugin(@NonNull Plugin plugin) throws ValidationModuleInitializationException {
        GenericValidator engine = new GenericValidator(FhirContext.forR4());
        ValidationModule result = new BaseValidationModule(
                new PluginValidationResourceProvider(plugin::getResource),
                engine
        );
        result.initialize();
        return result;
    }

    public ValidationModule createValidationModule(@NonNull SupportedValidationModule module) throws ValidationModuleInitializationException {
        GenericValidator engine = new GenericValidator(FhirContext.forR4());
        ValidationModule result = new IntegratedValidationModule(
                module.toString(),
                engine
        );
        result.initialize();
        return result;
    }
}