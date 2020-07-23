package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  private ContactData contactData;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

//  public void returnToHomePage() { click(By.linkText("home")); }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }



  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  //  public void type(By locator, String text) {
//    click(locator);
//    if (text != null) {
//      wd.findElement(locator).clear();
//      wd.findElement(locator).sendKeys(text);
//    }
//  }

  public void initCreateContactPage() {
    click(By.linkText("add new"));
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

  public void createContact(ContactData contact, boolean creation) {
    initCreateContactPage();
    fillContactForm(contact, true);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }
}
