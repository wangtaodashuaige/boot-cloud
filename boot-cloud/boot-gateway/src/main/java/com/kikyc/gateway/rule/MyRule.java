package com.kikyc.gateway.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 自定义负载均衡
 */
@Component
public class MyRule extends AbstractLoadBalancerRule {

	@Override
	public Server choose(Object key) {
		//获取服务个数 随机选择其中一个转发
		List<Server> list = this.getLoadBalancer().getReachableServers();
		int random = (int) (Math.random()*list.size());
		return list.get(random);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {

	}

}