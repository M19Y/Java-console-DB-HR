package belajar.mvc.jdbc.view;

import belajar.mvc.jdbc.controllers.CountryController;
import belajar.mvc.jdbc.daos.RegionDAO;
import belajar.mvc.jdbc.models.Country;
import belajar.mvc.jdbc.models.Region;
import belajar.mvc.jdbc.tools.Utils;

import java.util.Objects;
import java.util.Scanner;

public class CountryView {

  private final CountryController controller;
  private final Scanner scanner;

  public CountryView(CountryController controller) {
    this.controller = controller;
    this.scanner = new Scanner(System.in);
  }

  public void showCountries(){
    controller.getAllCountry();
  }

  public void insertCountry(){
    title("Insert Country");

    System.out.print("Country id: ");
    String id = scanner.nextLine();

    System.out.print("Country name: ");
    String name = scanner.nextLine();

    System.out.print("Region id: ");
    String region = scanner.nextLine();

    Integer regionId = Utils.checkInt(region, "Input region id harus berupa angka!");

    if (Objects.nonNull(regionId)) {
      Country country = new Country(id, name);
      controller.create(country, regionId);
    }

  }

  public void findById(){
    title("Search Country");

    System.out.print("Country id: ");
    String input = scanner.nextLine();

    controller.findById(input);
  }

  public void searchByName(){
    title("Search Country");

    System.out.print("Country name: ");
    String name = scanner.nextLine();

    controller.searchByName(name);

  }

  public void remove(){
    title("Remove Country");

    System.out.print("Country id: ");
    String id = scanner.nextLine();

    controller.delete(id);
  }

  public void update(){
    title("Update Country");

    System.out.print("Country id: ");
    String id = scanner.nextLine();

    System.out.print("New country name: ");
    String name = scanner.nextLine();

    System.out.print("New region id: ");
    String region = scanner.nextLine();

    Integer regionId = Utils.checkInt(region, "Input region id harus berupa angka!");

    if (Objects.nonNull(regionId)) {
      controller.update(id, name, regionId);
    }

  }
  public static void title(String title){
    System.out.println("\n\t\t\t\t\t\t==== " + title + " ====\n");
  }

  public static void header(String title){
    title(title);
    System.out.println("--------------------------------------------------------------------");
    System.out.println("| ID |\tNAME                       |\tREGION                     |");
    System.out.println("--------------------------------------------------------------------");
  }

  public static void content(Country country){
    System.out.printf("| %2s ", country.getId());
    System.out.printf("|\t%-25s  ", country.getName());
    System.out.printf("|\t%-25s  |", country.getRegion().getName());
    System.out.print("\n");
  }

  public static void footer(){
    System.out.println("--------------------------------------------------------------------");
  }


}
