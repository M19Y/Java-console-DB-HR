package belajar.mvc.jdbc.models;

public class Location {

  private int id;

  private String streetAddress;
  private String postalCode;
  private String city;
  private String stateProvince;

  private Country country;

  public Location() {
  }

  public Location(int id, String streetAddress, String postalCode, String city, String stateProvince, Country country) {
    this.id = id;
    this.streetAddress = streetAddress;
    this.postalCode = postalCode;
    this.city = city;
    this.stateProvince = stateProvince;
    this.country = country;
  }

  public Location(int id, String streetAddress, String postalCode, String city, String stateProvince) {
    this.id = id;
    this.streetAddress = streetAddress;
    this.postalCode = postalCode;
    this.city = city;
    this.stateProvince = stateProvince;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public void setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }
}
