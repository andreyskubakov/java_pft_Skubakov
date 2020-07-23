package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().initCreateContactPage();
    app.getContactHelper().createContact(new ContactData("AL", "PACHINO", "7777777777", "al_p@mail.ru", "test1"), true);

  }

}
