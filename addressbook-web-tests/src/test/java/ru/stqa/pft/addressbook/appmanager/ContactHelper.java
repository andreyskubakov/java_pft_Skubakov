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
    List<WebElement> edit = wd.findElements(By.xpath("//img[@alt='Edit']"));
    edit.get(5).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean creation) {
    initCreateContactPage();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }
  public void modify(int index, ContactData contact) {
    selectContact(index);
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }
  public void delete(int index) {
    selectContact(index);
    deleteSelectedContacts();
    getAcceptAlert();
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

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));//By.xpath("//tr[@name='entry']")

    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
//      String mobile = cells.get(5).getText();
//      String email = cells.get(4).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }
}
