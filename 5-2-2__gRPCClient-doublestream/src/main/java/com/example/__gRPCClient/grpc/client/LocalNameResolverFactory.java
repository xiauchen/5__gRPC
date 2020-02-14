package com.example.__gRPCClient.grpc.client;

import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.NameResolver.Args;
import io.grpc.NameResolverProvider;
import io.micrometer.core.lang.Nullable;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class LocalNameResolverFactory {
    public static class LocalNameResolver extends NameResolver {
        private String hostName;
        private List<Integer> listHostPorts;
        public LocalNameResolver(String hostName, List<Integer> listHostPorts){
            this.hostName = hostName;
            this.listHostPorts = listHostPorts;
        }
        @Override
        public String getServiceAuthority() {
            return "none";
        }
        // 配置可用服务，RPC在调用的时候，轮询选择这里配置的可用的服务地址列表
        @Override
        public void start(Listener listener) {
            ArrayList<EquivalentAddressGroup> addressGroups = new ArrayList<>();
            // 获取rpc地址的配置列表
            List<SocketAddress> socketAddresses = new ArrayList<>();
            socketAddresses.add(new InetSocketAddress(hostName, listHostPorts.get(0)));
            List<SocketAddress> socketAddresses2 = new ArrayList<>();
            socketAddresses2.add(new InetSocketAddress(hostName, listHostPorts.get(1)));
            addressGroups.add(new EquivalentAddressGroup(socketAddresses));
            addressGroups.add(new EquivalentAddressGroup(socketAddresses2));
            listener.onAddresses(addressGroups, Attributes.EMPTY);
        }
        @Override
        public void shutdown() {

        }
    }
    public static class LocalNameResolverProvider extends NameResolverProvider {
        private String hostName;
        private List<Integer> listHostPorts;
        public LocalNameResolverProvider(String hostName, List<Integer> listHostPorts)
        {
            this.hostName = hostName;
            this.listHostPorts = listHostPorts;
        }
        // 服务是否可用
        @Override
        protected boolean isAvailable() {
            return true;
        }
        // 优先级默认5
        @Override
        protected int priority() {
            return 5;
        }
        // 服务发现类
        @Nullable
        @Override
        public NameResolver newNameResolver(URI targetUri, Args params) {
            return new LocalNameResolver(hostName,listHostPorts);
        }
        // 服务协议
        @Override
        public String getDefaultScheme() {
            return "localhost";
        }
    }
}
