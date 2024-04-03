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
package de.gematik.refv.commons.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
public class DependencyList {
    private String validFrom;
    private String validTill;
    private List<String> packages;
    private List<ValidationMessageTransformation> validationMessageTransformations;
    public List<ValidationMessageTransformation> getValidationMessageTransformations() {
        return Objects.requireNonNullElseGet(validationMessageTransformations, LinkedList::new);
    }

    public boolean isValidFor(LocalDate resourceCreationDate) {
        var dateFrom = LocalDate.parse(getValidFrom());
        var dateTill = getValidTill() == null ? LocalDate.MAX : LocalDate.parse(getValidTill());
        return
                (getValidFrom() != null && (dateFrom.isBefore(resourceCreationDate) || dateFrom.isEqual(resourceCreationDate))) &&
                (getValidTill() == null || dateTill.isAfter(resourceCreationDate) || dateTill.isEqual(resourceCreationDate));
    }
}
