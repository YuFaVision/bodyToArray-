package org.apache.shenyu.plugin.body.to.array;

import org.apache.shenyu.common.utils.GsonUtils;
import org.apache.shenyu.plugin.base.handler.PluginDataHandler;

public class BodyToArrayPluginDataHandler implements PluginDataHandler {

    @Override
    public String pluginNamed() {
        return "bodyToArray";
    }

    @Override
    public void handlerPlugin(final String json) {
        BodyToArrayPluginData data = GsonUtils.getInstance().fromJson(json, BodyToArrayPluginData.class);
        // 处理插件数据，可在此处缓存或初始化
    }

    @Override
    public void removePlugin() {
        // 清理插件数据
    }
}
