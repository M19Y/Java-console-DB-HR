package belajar.mvc.jdbc;

import belajar.mvc.jdbc.view.AppView;

public class Test {

  public static void main(String[] args) {
    AppView app = new AppView();
    app.mainMenu();

    /*LocationDAO dao = new LocationDAO();
    List<Location> locations = dao.getAll();

    for (Location location : locations) {
      System.out.println(
              String.join(", ",
              String.valueOf(location.getId()),
                      location.getPostalCode(),
                      location.getCity(),
                      location.getStateProvince(),
                      location.getStreetAddress(),
                      location.getCountry().getName()
              )
      );

    }*/


/*    LocationView app = new LocationView(
            new LocationController(
                    new LocationDAO(),
                    new CountryDAO()));
    app.showLocations();*/
  }

}
