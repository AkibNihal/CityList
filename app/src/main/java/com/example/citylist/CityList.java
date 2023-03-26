package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     *
     * @param city This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @param sortby whether to sort by city or province
     * @return Return the sorted list of cities
     */
    public List<City> getCities(int sortby) {
        List<City> cityList = cities;
        if (sortby == 0) {
            Collections.sort(cityList);
            return cityList;
        } else {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * deletes city from the citylist
     * if no such city found then throws exception
     *
     * @param city to be deleted
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return total count of city
     */
    public int count() {
        return cities.size();
    }
}
