package Config;

import static Config.Credentials.*;

public class TestData {
    //Registration page tests positive
    public static final String USER_TEST_PASSWORD = USER_PASSWORD;
    public static final String USER_TEST_NAME = USER_NAME;
    public static final String USER_EMAIL1 = "lena26032200@gmail.com";
    public static final String USER_EMAIL2 = "LenAAA26032202@gmail.com";
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
}
