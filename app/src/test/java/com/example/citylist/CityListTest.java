package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    @Test
    public void testDelete() {
        CityList cityList = new CityList();
        City city1 = new City("Rajshahi", "kadirganj");
        City city2 = new City("Dhaka", "mirpur");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertFalse(cityList.getCities(0).contains(city1));  // citylist shouldn't contain city1

    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city1 = new City("Rajshahi", "kadirganj");
        City city2 = new City("Dhaka", "mirpur");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);  // as city1 doesn't exist it should throw exception
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));
    }

    @Test
    public void testSort(){
        CityList cityList = new CityList();
        City city1 = new City("A", "Y");
        City city2 = new City("B", "X");

        cityList.add(city1);
        cityList.add(city2);

        assertEquals(0, city1.compareTo(cityList.getCities(0).get(0)));  // check after sorting by city name
        assertEquals(0, city2.compareTo(cityList.getCities(1).get(0)));  // check after sorting by province name

    }

    @Test
    public void testCount() {
        CityList cityList = new CityList();
        City city1 = new City("Rajshahi", "kadirganj");
        City city2 = new City("Dhaka", "mirpur");

        cityList.add(city1);
        cityList.add(city2);

        assertEquals(2, cityList.count());  // count should return 2
        cityList.delete(city1);
        assertEquals(1, cityList.count()); // count should return 1
    }
}
