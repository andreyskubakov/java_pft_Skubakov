package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("AL", "PACHINO", "7777777777", "al_p@mail.ru", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Don", "Kapone", null, "don_k@mail.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
