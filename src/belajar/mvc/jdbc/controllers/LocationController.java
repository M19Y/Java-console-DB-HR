package belajar.mvc.jdbc.controllers;

import belajar.mvc.jdbc.daos.CountryDAO;
import belajar.mvc.jdbc.daos.LocationDAO;
import belajar.mvc.jdbc.models.Country;
import belajar.mvc.jdbc.models.Location;
import belajar.mvc.jdbc.view.LocationView;

import java.util.List;
import java.util.Objects;

public class LocationController {

  private final LocationDAO locationDAO;
  private final CountryDAO countryDAO;

  public LocationController(LocationDAO locationDAO, CountryDAO countryDAO) {
    this.locationDAO = locationDAO;
    this.countryDAO = countryDAO;
  }

  public void getAllLocation(){

    List<Location> locations = locationDAO.getAll();

    if (locations.size() > 0) {

      LocationView.header("LOCATION LIST");
      for (Location location : locations) {
        LocationView.content(location);
      }
      LocationView.footer();
    } else {
      System.err.println("Location belum di buat!");
    }
  }

  public void create(Location location, String countryId) {

    if (!Objects.nonNull(locationDAO.findById(location.getId()))) {
      Country country = countryDAO.findById(countryId);

      if(Objects.nonNull(country)){
        location.setCountry(country);
        locationDAO.create(location);
        System.out.println("Berhasil menambahkan location baru");
      }else{
        System.err.println("Country tidak di temukan!");
      }
    } else {
      System.err.println("ID location yang di input sudah ada di database!");
    }
  }

  public void findById(Integer id) {

    Location location = locationDAO.findById(id);

    if (Objects.nonNull(location)) {
      LocationView.header("Search Result");
      LocationView.content(location);
      LocationView.footer();
    } else {
      System.err.println("Location tidak ditemukan!");
    }

  }

  public void delete(Integer id) {

    if (Objects.nonNull(locationDAO.findById(id))) {
      locationDAO.delete(id);
      System.out.println("Berhasil menghapus location");
    } else {
      System.err.println("Location tidak ditemukan!");
    }

    // PLEASE ADD SOME LOGIC, IF LOCATION IS ALREADY USE IN OTHER TABLE !!!
  }

  public void update(Location location, String countryId) {

    if(Objects.nonNull(locationDAO.findById(location.getId()))){
      Country country = countryDAO.findById(countryId);
      if(Objects.nonNull(country)) {
        location.setCountry(country);
        locationDAO.update(new Location(location.getId(),
                location.getStreetAddress(),
                location.getPostalCode(),
                location.getCity(),
                location.getStateProvince()));
        System.out.println("Berhasil mengupdate country");
      }else {
        System.err.println("Country tidak di temukan!");
      }
    }else{
      System.err.println("Location tidak ditemukan!");
    }

  }
}
