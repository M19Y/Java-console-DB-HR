package belajar.mvc.jdbc.daos;

import belajar.mvc.jdbc.models.Country;
import belajar.mvc.jdbc.models.Location;
import belajar.mvc.jdbc.tools.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements DAO<Location, Integer>{

  @Override
  public List<Location> getAll() {
    List<Location> locations = new ArrayList<>();

    try (Connection connection = DBConnection.getConnection()){

      Statement statement = connection.createStatement();
      final String SQL = "SELECT l.id, l.street_address, l.postal_code, l.city, l.state_province, c.id, c.name " +
              "FROM location as l " +
              "JOIN country as c " +
              "ON (c.id = l.country)";

      ResultSet resultSet = statement.executeQuery(SQL);

      while (resultSet.next()) {
        Location location = new Location(
                resultSet.getInt("l.id"),
                resultSet.getString("l.street_address"),
                resultSet.getString("l.postal_code"),
                resultSet.getString("l.city"),
                resultSet.getString("l.state_province"),
                new Country(resultSet.getString("c.id"),
                        resultSet.getString("c.name"))
        );

        locations.add(location);
      }

      resultSet.close();
      statement.close();

    }catch (SQLException e){
      System.err.println("Error :" + e.getMessage());
    }

    return locations;
  }

  @Override
  public Location findById(Integer id) {
    try (Connection connection = DBConnection.getConnection()){

      final String SQL = "SELECT l.id, l.street_address, l.postal_code, l.city, l.state_province, c.id, c.name " +
              "FROM location as l " +
              "JOIN country as c " +
              "ON (c.id = l.country) WHERE l.id = ?";

      PreparedStatement statement = connection.prepareStatement(SQL);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        return new Location(
                resultSet.getInt("l.id"),
                resultSet.getString("l.street_address"),
                resultSet.getString("l.postal_code"),
                resultSet.getString("l.city"),
                resultSet.getString("l.state_province"),
                new Country(resultSet.getString("c.id"),
                        resultSet.getString("c.name"))
        );
      }

      resultSet.close();
      statement.close();

    }catch (SQLException e){
      System.err.println("Error :" + e.getMessage());
    }

    return null;
  }

  @Override
  public List<Location> searchByName(String name) {
    List<Location> locations = new ArrayList<>();

    try (Connection connection = DBConnection.getConnection()){

      final String SQL = "SELECT l.id, l.street_address, l.postal_code, l.city, l.state_province, c.id, c.name " +
              "FROM location as l " +
              "JOIN country as c " +
              "ON (c.id = l.country) WHERE l.name LIKE ?";

      PreparedStatement statement = connection.prepareStatement(SQL);
      statement.setString(1, "%" + name + "%");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Location location = new Location(
                resultSet.getInt("l.id"),
                resultSet.getString("l.street_address"),
                resultSet.getString("l.postal_code"),
                resultSet.getString("l.city"),
                resultSet.getString("l.state_province"),
                new Country(resultSet.getString("c.id"),
                        resultSet.getString("c.name"))
        );

        locations.add(location);
      }

      resultSet.close();
      statement.close();

    }catch (SQLException e){
      System.err.println("Error :" + e.getMessage());
    }

    return locations;
  }

  @Override
  public boolean searchName(String name) {
    try (Connection connection = DBConnection.getConnection()){

      final String SQL = "SELECT l.id, l.street_address, l.postal_code, l.city, l.state_province, c.id, c.name " +
              "FROM location as l " +
              "JOIN country as c " +
              "ON (c.id = l.country) WHERE l.street_address = ?";

      PreparedStatement statement = connection.prepareStatement(SQL);
      statement.setString(1, name);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) return true;

      resultSet.close();
      statement.close();

    }catch (SQLException e){
      System.err.println("Error :" + e.getMessage());
    }

    return false;
  }

  @Override
  public void create(Location location) {
    try (Connection connection = DBConnection.getConnection()){

      String SQL = "INSERT INTO location (id, street_address, postal_code, city, state_province, country) VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement statement = connection.prepareStatement(SQL);

      statement.setInt(1, location.getId());
      statement.setString(2, location.getStreetAddress());
      statement.setString(3, location.getPostalCode());
      statement.setString(4, location.getCity());
      statement.setString(5, location.getStateProvince());
      statement.setString(6, location.getCountry().getId());

      statement.executeUpdate();
      statement.close();

    }catch (SQLException e){
      System.err.println("Error :" + e.getMessage());
    }
  }

  @Override
  public void delete(Integer id) {
    try (Connection connection = DBConnection.getConnection()){

      String SQL = "DELETE FROM location WHERE id = ? ";
      PreparedStatement statement = connection.prepareStatement(SQL);

      statement.setInt(1, id);
      statement.executeUpdate();
      statement.close();

    }catch (SQLException e){
      System.err.println("Error :" + e.getMessage());
    }
  }

  @Override
  public void update(Location location) {
    try (Connection connection = DBConnection.getConnection()){

      String SQL = "UPDATE country SET " +
              "street_address = ?, " +
              "postal_code = ?, " +
              "city = ?, " +
              "street_province = ?, " +
              "country = ? " +
              "WHERE id = ?";
      PreparedStatement statement = connection.prepareStatement(SQL);

      statement.setString(1, location.getStreetAddress());
      statement.setString(2, location.getPostalCode());
      statement.setString(3, location.getCity());
      statement.setString(4, location.getStateProvince());
      statement.setString(5, location.getCountry().getId());
      statement.setInt(6, location.getId());
      statement.executeUpdate();
      statement.close();

    }catch (SQLException e){
      System.err.println("Error :" + e.getMessage());
    }
  }
}
