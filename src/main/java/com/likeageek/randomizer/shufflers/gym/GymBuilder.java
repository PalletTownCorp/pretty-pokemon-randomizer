package com.likeageek.randomizer.shufflers.gym;

public final class GymBuilder {
    private Gym gym;

    private GymBuilder() {
        gym = new Gym();
    }

    public static GymBuilder gym() {
        return new GymBuilder();
    }

    public GymBuilder name(Gyms name) {
        gym.setName(name);
        return this;
    }

    public Gym build() {
        return gym;
    }
}
