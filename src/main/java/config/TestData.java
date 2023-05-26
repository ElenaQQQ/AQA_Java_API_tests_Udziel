package config;

import com.github.javafaker.Faker;

public class TestData {


    //BASE DATA
    protected static Faker faker = new Faker();

    public static final String USER_TEST_NAME = "Name";

    //Registration page tests positive

    public static final String USER_EMAIL1 = faker.bothify("lena?????@gmail.com");
    public static final String USER_EMAIL2 = faker.bothify("????".toUpperCase() + "lena?????@gmail.com");
    public static final String USER_EMAIL3 = faker.bothify("#lenA26032202@gmail.com");
    public static final String USER_EMAIL4 = faker.bothify("lena.21.031.?????@gmail.com");
    public static final String USER_EMAIL5 = faker.bothify("lena?????@gmail.com.com.j.com");
    public static final String USER_EMAIL6 = faker.bothify("len-a?????@gmail.com");
    //Registration page tests negative
    public static final String USER_EMAIL7 = "";
    public static final String USER_RESPONSE7 = "не может быть пустым";
    public static final String USER_EMAIL8 = "b".repeat(257) + "@mail.ru";
    public static final String USER_RESPONSE8 = "не более 254 символов";
    public static final String USER_EMAIL9 = "lenamail.ru";
    public static final String USER_RESPONSE9 = "Введите правильный адрес";
    public static final String USER_EMAIL10 = "le..na@mail.ru";
    public static final String USER_RESPONSE10 = "Введите правильный адрес";
    public static final String USER_EMAIL11 = ".lena@mail.ru";
    public static final String USER_RESPONSE11 = "Введите правильный адрес";
    public static final String USER_EMAIL12 = "lena@.mail.ru";
    public static final String USER_RESPONSE12 = "Введите правильный адрес";

    //Registration page passwords tests positive
    public static final String USER_PASSWORD16 = "qazwsxedcohohohohoh";
    public static final String USER_PASSWORD17 = "QAZWSXEDCPFJHGF";
    public static final String USER_PASSWORD18 = "qazWSXedcRFVspnhge";
    public static final String USER_PASSWORD19 = "q1w2e3r4t5765432";
    public static final String USER_PASSWORD20 = "~!?@#$%^&*_-+()[]{}></|'.,:;";

    //Registration page passwords tests negative
    public static final String USER_PASSWORD21 = "kdutgfj";
    public static final String USER_RESPONSE21 = "слишком короткий";
    public static final String USER_PASSWORD22 = USER_TEST_NAME + "1";
    public static final String USER_RESPONSE22 = "слишком похож на username";
    public static final String USER_RESPONSE23 = "слишком похож на email";
    public static final String USER_PASSWORD24 = "197354873";
    public static final String USER_RESPONSE24 = "только из цифр";
    public static final String USER_PASSWORD25 = "qwerty";
    public static final String USER_RESPONSE25 = "широко распространён";

    //Registration page name tests positive
    public static final String USER_NAME26 = "Elena";
    public static final String USER_NAME27 = "Елена";
    public static final String USER_NAME28 = USER_NAME26 + "1";
    public static final String USER_NAME29 = USER_NAME26 + "@+.-_";
    public static final String USER_NAME30 = USER_EMAIL1;

    //Registration page name tests negative
    public static final String USER_NAME31 = "";
    public static final String USER_RESPONSE31 = "не может быть пустым";
    public static final String USER_NAME32 = "a".repeat(151);
    public static final String USER_RESPONSE32 = "не более 150 символов";
    public static final String USER_NAME33 = USER_NAME26 + "*/#";
    public static final String USER_RESPONSE33 = "может содержать только";

    //User page tests
    public static final String USER_PASSWORD34 = "qazwsxedcohohohohoh";
    public static final String USER_PASSWORD35 = "QAZWSXEDCPFJHGF";
    public static final String USER_PASSWORD36 = "qazWSXedcRFVspnhge";
    public static final String USER_PASSWORD37 = "q1w2e3r4t5765432";
    public static final String USER_PASSWORD38 = "~!?@#$%^&*_-+()[]{}></|'.,:;";

    public static final String USER_PASSWORD39 = "kdutgfj";
    public static final String USER_RESPONSE39 = "слишком короткий";
    public static final String USER_PASSWORD40 = USER_TEST_NAME + "1";
    public static final String USER_RESPONSE40 = "слишком похож на username";
    public static final String USER_RESPONSE41 = "слишком похож на email";
    public static final String USER_PASSWORD42 = "197354873";
    public static final String USER_RESPONSE42 = "только из цифр";
    public static final String USER_PASSWORD43 = "qwerty";
    public static final String USER_RESPONSE43 = "широко распространён";

    public static final String USER_NAME44 = "Elena"; //Is used as base for another
    public static final String USER_NAME45 = "Елена";
    public static final String USER_NAME46 = USER_NAME26 + "1";
    public static final String USER_NAME47 = USER_NAME26 + "@+.-_";

    public static final String USER_NAME49 = "";
    public static final String USER_RESPONSE49 = "не может быть пустым";
    public static final String USER_NAME50 = "a".repeat(151);
    public static final String USER_RESPONSE50 = "не более 150 символов";
    public static final String USER_NAME51 = USER_NAME26 + "*/#";
    public static final String USER_RESPONSE51 = "может содержать только";

    public static final String USER_RESPONSE53 = "правильное имя пользователя";

}
