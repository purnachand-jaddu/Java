package com.fabric.identity.repository.models.dtos;

import java.util.Map;

public class EventData {
    private String eventType;
    private String timestamp;
    private String specVersion;
    private Map<String, Object> data;

    public EventData() {
    }

    public static EventDataBuilder builder() {
        return new EventDataBuilder();
    }

    public static EventData of(String eventType, String subscriptionId) {
        EventData eventData = new EventData();
        eventData.setEventType(eventType);
        return eventData;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSpecVersion() {
        return specVersion;
    }

    public void setSpecVersion(String specVersion) {
        this.specVersion = specVersion;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static class EventDataBuilder {
        private EventData eventData = new EventData();

        public EventDataBuilder eventType(String eventType) {
            eventData.setEventType(eventType);
            return this;
        }

        public EventDataBuilder specVersion(String specVersion) {
            eventData.setSpecVersion(specVersion);
            return this;
        }

        public EventDataBuilder timestamp(String timestamp) {
            eventData.setTimestamp(timestamp);
            return this;
        }

        public EventData build() {
            return eventData;
        }
    }
}
