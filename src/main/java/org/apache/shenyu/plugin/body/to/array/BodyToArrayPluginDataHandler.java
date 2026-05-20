package org.apache.shenyu.plugin.body.to.array;

import org.apache.shenyu.common.dto.PluginData;
import org.apache.shenyu.common.utils.GsonUtils;
import org.apache.shenyu.plugin.base.handler.PluginDataHandler;

public class BodyToArrayPluginDataHandler implements PluginDataHandler {

    @Override
    public void handlerPlugin(final PluginData pluginData) {
        String json = pluginData.getConfig();
        BodyToArrayPluginData data = GsonUtils.getInstance().fromJson(json, BodyToArrayPluginData.class);
    }

    @Override
    public void removePlugin(final PluginData pluginData) {
    }
}
