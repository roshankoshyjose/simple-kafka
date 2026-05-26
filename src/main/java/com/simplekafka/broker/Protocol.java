package com.simplekafka.broker;

import java.nio.ByteBuffer;

/**
 * Defines the wire protocol
 */
public class Protocol {

    //Client request types
    public static final byte PRODUCE = 0x01;
    public static final byte FETCH = 0x02;
    public static final byte METADATA = 0x03;
    public static final byte CREATE_TOPIC = 0x04;

    //Broker response types
    public static final byte PRODUCE_RESPONSE = 0x11;
    public static final byte FETCH_RESPONSE = 0x12;
    public static final byte METADATA_RESPONSE = 0x13;
    public static final byte CREATE_TOPIC_RESPONSE = 0x14;
    public static final byte ERROR_RESPONSE = 0x1F;

    //Internal broker communication
    public static final byte REPLICATE = 0x21;
    public static final byte REPLICATION_ACK = 0x22;
    public static final byte TOPIC_NOTIFICATION = 0x23;

    /**
     * Encode a producer request
     */
    public static ByteBuffer encodeProduceRequest(String topic, int partition, byte[] message) {
        ByteBuffer buffer = ByteBuffer.allocate(11 + topic.length() + message.length);
        buffer.put(PRODUCE);
        buffer.putShort((short) topic.length());
        buffer.put(topic.getBytes());
        buffer.putInt(partition);
        buffer.putInt(message.length);
        buffer.put(message);
        buffer.flip();
        return buffer;
    }
}
