package Config;

import static Config.Credentials.*;

public class TestData {
    //Registration page tests positive
    public static final String USER_TEST_PASSWORD = USER_PASSWORD;
    public static final String USER_TEST_NAME = USER_NAME;
    public static final String USER_EMAIL1 = "lena03042040@gmail.com"; // used for all negative tests
    public static final String USER_EMAIL2 = "LenAAA02032001@gmail.com";
    public static final String USER_EMAIL3 = "1lenA26032202@gmail.com";
    public static final String USER_EMAIL4 = "lena.21.031.26032200@gmail.com";
    public static final String USER_EMAIL5 = "lena26032200@gmail.com.com.j.com";
    public static final String USER_EMAIL6 = "len-a26032200@gmail.com";
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
    public static final String USER_PASSWORD23 = USER_EMAIL1;
    public static final String USER_RESPONSE23 = "слишком похож на email";
    public static final String USER_PASSWORD24 = "197354873";
    public static final String USER_RESPONSE24 = "только из цифр";
    public static final String USER_PASSWORD25 = "qwerty";
    public static final String USER_RESPONSE25 = "широко распространён";
}
