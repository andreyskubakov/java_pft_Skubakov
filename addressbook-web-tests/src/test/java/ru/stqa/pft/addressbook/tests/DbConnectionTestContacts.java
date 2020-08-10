package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.sql.*;

public class DbConnectionTestContacts {

  @Test
  public void testDbConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select id, firstname, lastname, email from addressbook");
      Contacts contacts = new Contacts();
      while (rs.next()) {
        contacts.add(new ContactData().withId(rs.getInt("id")).withFirstname(rs.getString("firstname"))
                .withLastname(rs.getString("lastname")).withEmail("email"));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(contacts);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
