package com.ff4j.ff4j_with_webflux.beans;

public class MessageBean {

    private String uptime;

    @Override
    public String toString() {
        return "MessageBean{" +
                "uptime='" + uptime + '\'' +
                ", autocreate=" + autocreate +
                ", version='" + version + '\'' +
                ", featuresStore=" + featuresStore +
                '}';
    }

    public MessageBean(String s) {
        this.version=s;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public boolean isAutocreate() {
        return autocreate;
    }

    public void setAutocreate(boolean autocreate) {
        this.autocreate = autocreate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public FeaturesStore getFeaturesStore() {
        return featuresStore;
    }

    public MessageBean(String uptime, boolean autocreate, String version, FeaturesStore featuresStore) {
        this.uptime = uptime;
        this.autocreate = autocreate;
        this.version = version;
        this.featuresStore = featuresStore;
    }

    public MessageBean(){}

    public void setFeaturesStore(FeaturesStore featuresStore) {
        this.featuresStore = featuresStore;
    }

    private boolean autocreate;
    private String version;
    private FeaturesStore featuresStore;


}
