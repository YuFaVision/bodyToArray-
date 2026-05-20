package org.apache.shenyu.plugin.body.to.array;

import org.apache.shenyu.common.enums.PluginEnum;
import org.apache.shenyu.common.utils.JsonUtils;
import org.apache.shenyu.plugin.api.ShenyuPlugin;
import org.apache.shenyu.plugin.api.ShenyuPluginChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class BodyToArrayPlugin implements ShenyuPlugin {

    @Override
    public Mono<Void> execute(ServerWebExchange exchange, ShenyuPluginChain chain) {
        return exchange.getRequest().getBody()
                .collectList()
                .flatMap(dataBuffers -> {
                    if (dataBuffers.isEmpty()) {
                        return chain.execute(exchange);
                    }
                    String body = dataBuffers.get(0).toString(java.nio.charset.StandardCharsets.UTF_8);
                    try {
                        Object parsed = JsonUtils.jsonToObject(body, Object.class);
                        List<Object> array = new ArrayList<>();
                        if (parsed instanceof List) {
                            array.addAll((List<?>) parsed);
                        } else {
                            array.add(parsed);
                        }
                        String newBody = JsonUtils.toJson(array);
                        ServerWebExchange mutatedExchange = exchange.mutate()
                                .request(exchange.getRequest().mutate()
                                        .header("Content-Type", "application/json")
                                        .build())
                                .build();
                        mutatedExchange.getAttributes().put("modifiedBody", newBody);
                        return chain.execute(mutatedExchange);
                    } catch (Exception e) {
                        return chain.execute(exchange);
                    }
                });
    }

    @Override
    public String named() {
        return "bodyToArray";
    }

    @Override
    public int getOrder() {
        return PluginEnum.REQUEST.getCode() - 1;
    }
}
