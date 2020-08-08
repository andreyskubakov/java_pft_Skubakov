package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String mobile;
  private String email;
  private String group;
  private String home;
  private String work;

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withHomePhone(String home) {
    this.home = home;
    return this;

  }

  public ContactData withWorkPhone(String work) {
    this.work = work;
    return null;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() { return group; }

  public int getId() { return id; }

  public String getHomePhone() { return home; }

  public String getWorkPhone() { return work; }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(mobile, that.mobile) &&
            Objects.equals(email, that.email) &&
            Objects.equals(group, that.group);
//            Objects.equals(home, that.home) &&
//            Objects.equals(work, that.work);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, mobile, email, group);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            ", group='" + group + '\'' +
//            ", home='" + home + '\'' +
//            ", work='" + work + '\'' +
            '}';
  }

}
