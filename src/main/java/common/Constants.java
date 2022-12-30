package common;

import io.github.cozyloon.EzConfig;

public class Constants {
    public final static String DB_URL = EzConfig.getProperty("db.url");
    public final static String DB_USERNAME = EzConfig.getProperty("db.username");
    public final static String DB_PASSWORD = EzConfig.getProperty("db.password");
    public final static String MEDIA_PATH =System.getProperty("user.dir")+"\\src\\main\\resources\\data\\" ;

}
