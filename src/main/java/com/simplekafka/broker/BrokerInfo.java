package com.simplekafka.broker;

import java.util.Objects;

/**
 * Holds information about a broker in the SimpleKafka Cluster
 */
public class BrokerInfo {

    private final int id;
    private final String host;
    private final int port;

    public BrokerInfo(int id, String host, int port) {
        this.id = id;
        this.host = host;
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BrokerInfo that = (BrokerInfo) o;
        return id == that.id && port == that.port && Objects.equals(host, that.host);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "BrokerInfo{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
