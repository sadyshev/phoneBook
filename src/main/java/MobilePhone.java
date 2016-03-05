public class MobilePhone extends Phone {

    public Operator operator;

    public enum Operator {
        Mts,
        Velcom,
        Life,
    }


    // getPhone возвращает полный номер телефона: оператор + номер
    @Override
    public String getPhone(){
        StringBuffer output = new StringBuffer();
        output.append(operator+" "+number);
        return output.toString();
    }

    // конструктор MobilePhone
    public MobilePhone(Operator operator, String number) {
        this.operator=operator;
        this.number=number;
    }



}
