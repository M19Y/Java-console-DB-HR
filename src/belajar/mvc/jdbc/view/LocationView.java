package belajar.mvc.jdbc.view;

import belajar.mvc.jdbc.controllers.LocationController;
import belajar.mvc.jdbc.models.Location;
import belajar.mvc.jdbc.tools.Utils;

import java.util.Objects;
import java.util.Scanner;

public class LocationView {

  private final LocationController controller;

  private final Scanner scanner;

  public LocationView(LocationController controller) {
    this.controller = controller;
    scanner = new Scanner(System.in);
  }


  public void showLocations(){
    controller.getAllLocation();
  }

  public void findById(){
    title("Search Location");

    System.out.print("Country id: ");
    String id = scanner.nextLine();

    Integer parseId = Utils.checkInt(id, "Input location id harus berupa angka!");

    if (Objects.nonNull(parseId)){
      controller.findById(parseId);
    }
  }
  public void remove(){
    title("Remove Location");

    System.out.print("Location id: ");
    String id = scanner.nextLine();


    Integer parseId = Utils.checkInt(id, "Input location id harus berupa angka!");

    if (Objects.nonNull(parseId)){
      controller.delete(parseId);
    }
  }
  public void insertLocation(){
    title("Insert Location");

    System.out.print("Location id: ");
    String id = scanner.nextLine();

    System.out.print("Location street address: ");
    String streetAddress = scanner.nextLine();

    System.out.print("Location postal code: ");
    String postalCode = scanner.nextLine();

    System.out.print("Location city: ");
    String city = scanner.nextLine();

    System.out.print("Location state province: ");
    String stateProvince = scanner.nextLine();

    System.out.print("Location country id: ");
    String countryId = scanner.nextLine();

    Integer parseId = Utils.checkInt(id, "Input location id harus berupa angka!");

    if (Objects.nonNull(parseId)){
      controller.create(new Location(parseId,
                      streetAddress,
                      postalCode,
                      city,
                      stateProvince), countryId);
    }

  }

  public void update(){
    title("Update Location");

    System.out.print("Location id: ");
    String id = scanner.nextLine();

    System.out.print("New location street address: ");
    String streetAddress = scanner.nextLine();

    System.out.print("New location postal code: ");
    String postalCode = scanner.nextLine();

    System.out.print("New location city: ");
    String city = scanner.nextLine();

    System.out.print("New location state province: ");
    String stateProvince = scanner.nextLine();

    System.out.print("New location country id: ");
    String countryId = scanner.nextLine();

    Integer parseId = Utils.checkInt(id, "Input location id harus berupa angka!");

    if (Objects.nonNull(parseId)){
      controller.update(new Location(parseId,
              streetAddress,
              postalCode,
              city,
              stateProvince), countryId);
    }
  }
  public static void title(String title){
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t==== " + title + " ====\n");
  }

  public static void header(String title){
    title(title);
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("|\tID  |\tCITY                       |\tPOSTAL CODE                |\tSTREET ADDRESS                            |\tSTATE PROVINCE             |\tCOUNTRY                    |");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
  }

  public static void footer(){
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
  }

  public static void content(Location location){
    System.out.printf("|  %2s ", location.getId());
    System.out.printf("|\t%-25s  ", location.getCity());
    System.out.printf("|\t%-25s  ", location.getPostalCode());
    System.out.printf("|\t%-40s  ", location.getStreetAddress());
    System.out.printf("|\t%-25s  ", location.getStateProvince());
    System.out.printf("|\t%-25s  |", location.getCountry().getName());
    System.out.print("\n");
  }
}
