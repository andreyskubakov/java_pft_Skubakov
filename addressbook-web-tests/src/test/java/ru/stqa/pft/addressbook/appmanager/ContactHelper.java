package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  private ContactData contactData;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

//  public void returnToHomePage() { click(By.linkText("home")); }

  public void submitContactCreation() {
    //click(By.xpath("(//input[@name='submit'])[2]"));
    click(By.name("submit"));
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

    public void type(By locator, String text) {
    click(locator);
    if (text != null) {
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void initCreateContactPage() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) { wd.findElements(By.name("selected[]")).get(index).click(); }

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
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String firstname = element.getText();
      String lastname = element.getText();
      ContactData contact = new ContactData(firstname,lastname,null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
