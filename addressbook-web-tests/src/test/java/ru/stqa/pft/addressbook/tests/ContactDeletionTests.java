package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().returnToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("AL", "PACHINO", "7777777777", "al_p@mail.ru", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().getAcceptAlert();
    app.getContactHelper().returnToHomePage();
  }
}


//  private boolean isElementPresent(By locator) {
//    try {
//      wd.findElement(locator);
//      return true;
//    } catch (NoSuchElementException ex) {
//      return false;
//    }
//  }