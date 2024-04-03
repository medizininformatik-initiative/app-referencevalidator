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
package de.gematik.refv.cli.pluginloader;

import de.gematik.refv.cli.PluginLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PluginLoaderTests {

    private static final String PLUGIN_PATH = "src/test/resources/pluginloader-integration-test/plugins";

    @Test
    void testLoadPlugins() throws IOException {
        PluginLoader pluginLoader = new PluginLoader();

        var plugins = pluginLoader.loadPlugins(PLUGIN_PATH);

        assertFalse(plugins.isEmpty());
        assertTrue(plugins.containsKey("minimal"));
        assertEquals(1, plugins.keySet().size(),"More plugins were loaded than expected");
    }
}
