import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

import java.io.FileWriter;

public class Main {

    private static final String FILENAME= "src/File.json";
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(String.valueOf(Main.class));
    static String name=null;
    static String surname=null;


    public static void main(String[] args) throws IOException {

        // Запуск меню
        menu();

        int flag=0;
        int v=0;   // switch menu
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        HashSet<Contact> book = new HashSet<Contact>();

        do {
            v=Integer.parseInt(reader.readLine());
            switch (v) {
            /*Заполнить телефонный справочник*/
                case 1: {
                    LOG.trace("Выбран пункт \"Заполнить телефонный справочник\"");
                    MobilePhone.Operator operator = null;
                    HomePhone.City city=null;

                    System.out.println("Введите Имя:");
                    name=reader.readLine();
                    System.out.println("Введите Фамилию:");
                    surname=reader.readLine();
                    Contact contact = new Contact(name, surname);

                    System.out.println("Выберите мобильного оператора: (1-Mts, 2-Velcom, 3-Life)");
                    String oper=reader.readLine();
                    switch (oper){
                        case "1": {operator = MobilePhone.Operator.Mts;}break;
                        case "2": {operator = MobilePhone.Operator.Velcom;}break;
                        case "3": {operator=MobilePhone.Operator.Life;}break;

                    }
                    System.out.println("Введите номер мобильного телефона:");
                    String number=reader.readLine();

                    contact.setMobilePhone(operator,number);

                    System.out.println("Выберите город: (1-Минск, 2-Москва, 3-Питер)");
                    String gorod=reader.readLine();
                    switch (gorod) {
                        case "1": {city=HomePhone.City.Minsk;}break;
                        case "2": {city= HomePhone.City.Moskva;}break;
                        case "3": {city= HomePhone.City.Piter;}break;
                    }
                    System.out.println("Введите номер городского телефона:");
                    number=reader.readLine();
                    contact.setHomePhone(city,number);
                    book.add(contact);

                    menu();
                }
                break;

            /*Вывести справочник на экран*/
                case 2: {
                    printSet(book);
                }
                break;

            /*Сохранить справочник в файл*/
                case 3: {
                    save(book);
                    menu();
                }
                break;

            /*Загрузить справочник из файла*/
                case 4: {
                    load(book);
                    menu();
                }
                break;

            /*Выход*/
                case 5:
                    flag=1;
                    break;
                default: {
                    System.out.println("Такого пункта меню нет!");
                }
                break;
            }
        } while (flag == 0);

    }

    public static void save(HashSet<Contact> set) {

        List<String> listContacts=new ArrayList<String>();
        for (Contact contact : set) {
            listContacts.add(contact.getFullInfo());
        }

        JSONObject obj = new JSONObject();
        obj.put("user", listContacts);
        System.out.println(obj.toString());

        try {
        FileWriter file = new FileWriter(FILENAME);
        file.write(obj.toJSONString());
        file.flush();
        file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Данные успешно сохранены в "+FILENAME+'\n');
        LOG.trace("Метод save");
    }

    public static void load(HashSet<Contact> set){
        JSONParser parser = new JSONParser();

        try{
            JSONObject obj = (JSONObject) parser.parse(new FileReader(FILENAME));

//            String user = (String) obj.get("user");
//            System.out.println(user);

            JSONObject jsonObj = (JSONObject) obj;
            System.out.println(jsonObj.get("user"));

        }catch (IOException|ParseException ex){
            LOG.error("Все плохо!", ex);
            LOG.trace("Отработало исключение", ex);
        }

        System.out.println("Данные успешно загружены из "+FILENAME);
        LOG.trace("Метод load");
    }

    public static void menu() {
        System.out.println("************************************");
        System.out.println("1 - Заполнить телефонный справочник");
        System.out.println("2 - Вывести справочник на экран");
        System.out.println("3 - Сохранить справочник в файл");
        System.out.println("4 - Загрузить справочник из файла");
        System.out.println("5 - Выход");
        System.out.println("************************************");
        System.out.println("");
        System.out.println("Выберите пункт меню:");
           }

    public static void printSet(HashSet<Contact> set) {
        for (Contact contact : set) {
            System.out.println(contact.getFullInfo());
        }
        LOG.trace("Метод printSet");
    }
}