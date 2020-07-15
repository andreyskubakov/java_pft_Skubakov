package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    clickContact(By.linkText("home"));
  }

  public void submitContactCreation() {
    clickContact(By.xpath("(//input[@name='submit'])[2]"));
  }

  private void clickContact(By locator) {
    wd.findElement(locator).click();
  }

  public void fillContactForm(ContactData contactData) {
    typeContact(By.name("firstname"), contactData.getFirstname());
    clickContact(By.name("middlename"));
    clickContact(By.name("theform"));
    typeContact(By.name("lastname"), contactData.getLastname());
    typeContact(By.name("mobile"), contactData.getMobile());
    typeContact(By.name("email"), contactData.getEmail());
  }

  private void typeContact(By firstname, String text) {
    clickContact(firstname);
    wd.findElement(firstname).clear();
    wd.findElement(firstname).sendKeys(text);
  }

  public void initCreateContactPage() {
    clickContact(By.linkText("add new"));
  }
}
