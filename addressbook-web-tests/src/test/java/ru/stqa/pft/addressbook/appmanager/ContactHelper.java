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
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
  }

  public void type(By firstname, String text) {
    clickContact(firstname);
    wd.findElement(firstname).clear();
    wd.findElement(firstname).sendKeys(text);
  }

  public void initCreateContactPage() {
    clickContact(By.linkText("add new"));
  }

  public void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void deleteSelectedContacts() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  public void getAcceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    wd.findElement(By.xpath("(//img[@alt='Edit'])")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}
