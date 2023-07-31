package com.ff4j.ff4j_with_webflux.beans;


public class FeaturesStore {

    public FeaturesStore(String type, String[] features, int numberOfFeatures, int numberOfGroups) {
        this.type = type;
        this.features = features;
        this.numberOfFeatures = numberOfFeatures;
        this.numberOfGroups = numberOfGroups;
    }
    public FeaturesStore() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public int getNumberOfFeatures() {
        return numberOfFeatures;
    }

    public void setNumberOfFeatures(int numberOfFeatures) {
        this.numberOfFeatures = numberOfFeatures;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    public void setNumberOfGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    private String type;
    private String[] features;
    private int numberOfFeatures;
    private int numberOfGroups;

}
