package com.ynet.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @author hansz
 * @version 2018年2月10日 下午9:56:31
 * @Description 解析分割redis集群节点地址信息
 */
@Configuration // 这个标签类似于applicationContext.xml，将RedisClusterConfig变成一个配置文件
public class RedisClusterConfig {
	
	@Value("${spring.redis.cluster.nodes}") // 注入集群节点信息
	private String clusterNodes;

	@Bean
	public JedisCluster getJedisCluster() {
		// 分割集群节点
		String[] cNodes = clusterNodes.split(",");
		// 创建set集合
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		// 循环集群节点对象
		for (String node : cNodes) {
			String[] hostAndPort = node.split(":");
			nodes.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
		}
		// 创建redis集群
		JedisCluster jedisCluster = new JedisCluster(nodes);
		return jedisCluster;
	}

}
