package org.caworks.ca1.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.caworks.ca1.model.db.entities.minimalist.AirQualityLive;
import org.caworks.ca1.model.db.entities.minimalist.LifeIndex;
import org.caworks.ca1.model.db.entities.minimalist.Weather;
import org.caworks.ca1.model.db.entities.minimalist.WeatherForecast;
import org.caworks.ca1.model.db.entities.minimalist.WeatherLive;
import org.caworks.library.util.GLog;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/28 0028.
 */

public class WeatherDatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String  DATABASE_NAME = "weather.db";
    private static final int DATABASE_VERSION = 1;

    private static volatile WeatherDatabaseHelper instance;

    public WeatherDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, AirQualityLive.class);
            TableUtils.createTable(connectionSource, WeatherForecast.class);
            TableUtils.createTable(connectionSource, LifeIndex.class);
            TableUtils.createTable(connectionSource, WeatherLive.class);
            TableUtils.createTable(connectionSource, Weather.class);

            String weatherTrigger = "CREATE TRIGGER trigger_delete AFTER DELETE " +
                    "ON Weather " +
                    "FOR EACH ROW" +
                    "BEGIN" +
                    "DELETE FROM AirQuality WHERE cityId = OLD.cityId; " +
                    "DELETE FROM WeatherLive WHERE cityId = OLD.cityId; " +
                    "DELETE FROM WeatherForecast WHERE cityId = OLD.cityId; " +
                    "DELETE FROM LifeIndex WHERE cityId = OLD.cityId; " +
                    "END;";
            database.execSQL(weatherTrigger);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public static WeatherDatabaseHelper getInstance(Context context) {

        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (WeatherDatabaseHelper.class) {
                if (instance == null) {
                    instance = new WeatherDatabaseHelper(context);
                }
            }
        }
        return instance;
    }

    public void close() {
        super.close();
        DaoManager.clearCache();
    }

    public <D extends Dao<T, ?>, T> D getWeatherDao(Class<T> clazz) {
        try {
            return getDao(clazz);
        } catch (SQLException e) {
            e.printStackTrace();
            GLog.e(e.getMessage());
        }
        return null;
    }

}
