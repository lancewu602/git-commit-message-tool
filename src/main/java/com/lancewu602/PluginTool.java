package com.lancewu602;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.extensions.PluginId;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

/**
 * @author WuQinglong
 * @date 2023/11/27 9:31 AM
 */
public class PluginTool {

    public static final PluginId ID = PluginId.getId("com.xiaojukeji.ep.smartcoder-intellij");


    public static @NotNull String getVersion() {
        IdeaPluginDescriptor plugin = PluginManagerCore.getPlugin(ID);
        return plugin == null ? "unknown" : plugin.getVersion();
    }

    public static Path getPluginBasePath() {
        IdeaPluginDescriptor plugin = PluginManagerCore.getPlugin(ID);
        if (plugin != null) {
            return plugin.getPluginPath();
        }
        throw new AssertionError();
    }

}
