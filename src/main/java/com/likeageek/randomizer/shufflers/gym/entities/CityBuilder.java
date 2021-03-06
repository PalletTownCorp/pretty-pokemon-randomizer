package com.likeageek.randomizer.shufflers.gym.entities;

public final class CityBuilder {
    private City city;

    private CityBuilder() {
        city = new City();
    }

    public static CityBuilder city() {
        return new CityBuilder();
    }

    public CityBuilder name(Cities name) {
        city.setName(name);
        return this;
    }

    public CityBuilder gym(Gym gym) {
        city.setGym(gym);
        return this;
    }

    public City build() {
        return city;
    }
}
