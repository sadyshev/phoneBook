public class Contact {

   private String name;
   private String surname;
   private MobilePhone mobilePhone;
   private HomePhone homePhone;


    public Contact(String name, String surname) {

        this.name=name;
        this.surname=surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMobilePhone(MobilePhone.Operator operator, String number) {
        this.mobilePhone = new MobilePhone(operator,number);
    }

    public void setHomePhone(HomePhone.City city, String number) {
        this.homePhone = new HomePhone(city,number);
    }

    public String getHomePhone() {
        return homePhone.getPhone();
    }

    public String getMobilePhone() {
        return mobilePhone.getPhone();
    }

    public String getFullInfo() {
        StringBuffer sb = new StringBuffer(surname);
        sb.append(" ");
        sb.append(name);
        sb.append(", Mobile: ");
        sb.append(mobilePhone.getPhone());
        sb.append(", Home: ");
        sb.append(homePhone.getPhone());

        return sb.toString();
    }
}
