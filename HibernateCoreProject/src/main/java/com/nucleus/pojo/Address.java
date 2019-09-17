package com.nucleus.pojo;

import javax.persistence.Embeddable;

//@Embeddable//either we can use @Embedded on datamember or @Embeddable at class level.

public class Address {
private String city;
private String country;

public String getCity() {
	return city;
}
public String setCity(String city) {
	return this.city = city;
}
public String getCountry() {
	return country;
}
public String setCountry(String country) {
	return this.country = country;
}
@Override
public String toString() {
	return "Address [city=" + city + ", country=" + country + "]";
}

}
