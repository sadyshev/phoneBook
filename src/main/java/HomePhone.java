public class HomePhone extends Phone {

    public City city;

    public enum City {
        Minsk,
        Moskva,
        Piter,
    }



    // getPhone возвращает полный номер телефона: город + номер
    @Override
    public String getPhone(){
        StringBuffer output = new StringBuffer();
        output.append(city+" "+number);
        return output.toString();
    }

    // конструктор HomePhone
    public HomePhone(City city, String number) {
        this.city=city;
        this.number=number;

    }

}
