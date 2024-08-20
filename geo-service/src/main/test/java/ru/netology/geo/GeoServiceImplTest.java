package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImplTest {

    @Test
    void moscowIpTest(){
        String ip = "172.0.32.11";
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location resultLocation = geoService.byIp(ip);
        String resultCity = resultLocation.getCity();
        Country resultCountry = resultLocation.getCountry();
        String resultStreet = resultLocation.getStreet();

        Country expectedCounty = Country.RUSSIA;
        String expectedCity = "Moscow";
        String expectedStreet = "Lenina";

        assertEquals(expectedCity, resultCity);
        assertEquals(expectedCounty, resultCountry);
        assertEquals(expectedStreet, resultStreet);
    }

    @Test
    void nyIpTest() {
        String ip = "96.44.183.149";
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location resultLocation = geoService.byIp(ip);
        String resultCity = resultLocation.getCity();
        Country resultCountry = resultLocation.getCountry();
        String resultStreet = resultLocation.getStreet();

        Country expectedCounty = Country.USA;
        String expectedCity = "New York";
        String expectedStreet = "10th Avenue";

        assertEquals(expectedCity, resultCity);
        assertEquals(expectedCounty, resultCountry);
        assertEquals(expectedStreet, resultStreet);
    }

    @Test
    void localhostIpTest() {
        Server ip = "127.0.0.1";
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location resultLocation = geoService.byIp(ip);
        String resultCity = resultLocation.getCity();
        Country resultCountry = resultLocation.getCountry();

        assertNull(actualCity);
        assertNull(actualCountry);
    }
}
