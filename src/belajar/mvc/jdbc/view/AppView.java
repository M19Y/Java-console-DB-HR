package belajar.mvc.jdbc.view;

import belajar.mvc.jdbc.controllers.CountryController;
import belajar.mvc.jdbc.controllers.LocationController;
import belajar.mvc.jdbc.controllers.RegionController;
import belajar.mvc.jdbc.daos.CountryDAO;
import belajar.mvc.jdbc.daos.LocationDAO;
import belajar.mvc.jdbc.daos.RegionDAO;
import belajar.mvc.jdbc.tools.Utils;

import java.util.Scanner;

public class AppView {
  private final Scanner scanner;

  private final RegionView regionView;
  private final CountryView countryView;

  private final LocationView locationView;

  public AppView() {
    RegionDAO regionDAO = new RegionDAO();
    CountryDAO countryDAO = new CountryDAO();
    LocationDAO locationDAO = new LocationDAO();

    scanner = new Scanner(System.in);
    regionView = new RegionView(new RegionController(regionDAO));
    countryView = new CountryView(new CountryController(countryDAO, regionDAO));
    locationView = new LocationView(new LocationController(locationDAO, countryDAO));
  }

  public void mainMenu(){

    Scanner scanner = new Scanner(System.in);

    String[] listMenu = {
            "1. VIEW REGION",
            "2. VIEW COUNTRY",
            "3. VIEW LOCATION"
    };

    boolean isNext = true;

    while (isNext) {

      header("MAIN MENU");

      for (String menu : listMenu) {
        System.out.println(menu);
      }

      System.out.print("\nselect : ");
      String operator = scanner.next();

      switch (operator){
        case "1":
          regionView();
          break;
        case "2":
          countryView();
          break;
        case "3":
          locationView();
          break;
        default:
          System.out.println("Pilih input yang benar " + Utils.getMenuLength(listMenu));
      }
      isNext = Utils.getYesOrNo("Tampilkan main menu");
    }
  }

  private void locationView() {
    boolean isNext = true;

    String[] listMenu = {
            "1. SHOW LOCATION",
            "2. INSERT LOCATION",
            "3. FIND LOCATION BY ID",
            "4. REMOVE LOCATION",
            "5. UPDATE LOCATION",
    };


    while (isNext) {

      header("LOCATION MENU");

      for (String menu : listMenu) {
        System.out.println(menu);
      }

      System.out.print("\nselect : ");
      String operator = scanner.next();

      switch (operator){
        case "1":
          locationView.showLocations();
          break;
        case "2":
          locationView.insertLocation();
          break;
        case "3":
          locationView.findById();
          break;
        case "4":
          locationView.remove();
          break;
        case "5":
          locationView.update();
          break;
        default:
          System.out.println("Pilih input yang benar " + Utils.getMenuLength(listMenu));
      }

      isNext = Utils.getYesOrNo("Apakah anda ingin melanjutkan pada menu country");
    }

  }

  private void countryView() {
    boolean isNext = true;

    String[] listMenu = {
            "1. SHOW COUNTRY",
            "2. INSERT COUNTRY",
            "3. FIND COUNTRY BY ID",
            "4. SEARCH COUNTRY BY NAME",
            "5. REMOVE COUNTRY",
            "6. UPDATE COUNTRY",
    };


    while (isNext) {

      header("COUNTRY MENU");

      for (String menu : listMenu) {
        System.out.println(menu);
      }

      System.out.print("\nselect : ");
      String operator = scanner.next();

      switch (operator){
        case "1":
          countryView.showCountries();
          break;
        case "2":
          countryView.insertCountry();
          break;
        case "3":
          countryView.findById();
          break;
        case "4":
          countryView.searchByName();
          break;
        case "5":
          countryView.remove();
          break;
        case "6":
          countryView.update();
          break;
        default:
          System.out.println("Pilih input yang benar " + Utils.getMenuLength(listMenu));
      }

      isNext = Utils.getYesOrNo("Apakah anda ingin melanjutkan pada menu country");
    }

  }

  public void regionView(){


    boolean isNext = true;

    String[] listMenu = {
            "1. SHOW REGION",
            "2. INSERT REGION",
            "3. FIND REGION BY ID",
            "4. SEARCH REGION BY NAME",
            "5. REMOVE REGION",
            "6. UPDATE REGION",
    };


    while (isNext) {

      header("REGION MENU");

      for (String menu : listMenu) {
        System.out.println(menu);
      }

      System.out.print("\nselect : ");
      String operator = scanner.next();

      switch (operator){
        case "1":
          regionView.showRegions();
          break;
        case "2":
          regionView.insertRegion();
          break;
        case "3":
          regionView.findById();
          break;
        case "4":
          regionView.searchByName();
          break;
        case "5":
          regionView.remove();
          break;
        case "6":
          regionView.update();
          break;
        default:
          System.out.println("Pilih input yang benar " + Utils.getMenuLength(listMenu));
      }

      isNext = Utils.getYesOrNo("Apakah anda ingin melanjutkan pada menu region");
    }
  }

  public void header(String title){
    System.out.println("\n============================");
    System.out.printf("|\t\t%-17s  |", title);
    System.out.println("\n============================\n");
  }
}
