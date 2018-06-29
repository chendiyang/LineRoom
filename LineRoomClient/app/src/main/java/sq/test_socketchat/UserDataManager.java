package sq.test_socketchat;

/**
 * Created by chendsir on 18-6-28.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class UserDataManager {
    //一些宏定义和声明
    private static final String TAG = "UserDataManager";
    private static final String DB_NAME = "user_data";
    private static final String TABLE_NAME = "users";
    public static final String ID = "id";
    public static final String USER_NAME = "user_name";
    public static final String USER_PWD = "user_pwd";
    //    public static final String SILENT = "silent";
//    public static final String VIBRATE = "vibrate";
    private static final int DB_VERSION = 2;
    private Context mContext = null;
    private MyDatabaseHelper dbHelper;



    //创建用户book表
    private static final String DB_CREATE = "create table users ("
            +"id integer primary key autoincrement,"
            +"user_name text,"
            +"user_pwd text)";



//
//            "CREATE TABLE " + TABLE_NAME + " ("
//            + ID + " integer primary key," + USER_NAME + " varchar,"
//            + USER_PWD + " varchar" + ");";

    private SQLiteDatabase mSQLiteDatabase = null;
    private MyDatabaseHelper mDatabaseHelper = null;

//    //DataBaseManagementHelper继承自SQLiteOpenHelper
//    private class DataBaseManagementHelper extends SQLiteOpenHelper {
//
//        public  DataBaseManagementHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version)
//        {
//            super(context, name, factory, version);
//            mContext=context;
//        }

//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            Log.i(TAG,"db.getVersion()="+db.getVersion());
//            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
//            db.execSQL(DB_CREATE);
//            Log.i(TAG, "db.execSQL(DB_CREATE)");
//            Log.e(TAG, DB_CREATE);
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            Log.i(TAG, "DataBaseManagementHelper onUpgrade");
//            onCreate(db);
//        }
//    }

    public UserDataManager(Context context) {
       // dbHelper = new MyDatabaseHelper(context,"users.db",null,1);
        mDatabaseHelper = new MyDatabaseHelper(context,"users.db",null,1);
        mContext = context;
        Log.i(TAG, "UserDataManager construction!");
    }
    //打开数据库
    public void openDataBase() throws SQLException {
        mDatabaseHelper = new MyDatabaseHelper(mContext,"users.db",null,1);
        mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
    }
    //关闭数据库
    public void closeDataBase() throws SQLException {
        mDatabaseHelper.close();
    }
    //添加新用户，即注册
    public long insertUserData(UserData userData) {
        String userName=userData.getUserName();
        String userPwd=userData.getUserPwd();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, userName);
        values.put(USER_PWD, userPwd);
        return mSQLiteDatabase.insert("users", null, values);
    }
    //更新用户信息，如修改密码
    public boolean updateUserData(UserData userData) {
        //int id = userData.getUserId();
        String userName = userData.getUserName();
        String userPwd = userData.getUserPwd();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, userName);
        values.put(USER_PWD, userPwd);
        return mSQLiteDatabase.update(TABLE_NAME, values,null, null) > 0;
        //return mSQLiteDatabase.update(TABLE_NAME, values, ID + "=" + id, null) > 0;
    }
    //
    public Cursor fetchUserData(int id) throws SQLException {
        Cursor mCursor = mSQLiteDatabase.query(false, TABLE_NAME, null, ID
                + "=" + id, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    //
    public Cursor fetchAllUserDatas() {
        return mSQLiteDatabase.query(TABLE_NAME, null, null, null, null, null,
                null);
    }
    //根据id删除用户
    public boolean deleteUserData(int id) {
        return mSQLiteDatabase.delete(TABLE_NAME, ID + "=" + id, null) > 0;
    }
    //根据用户名注销
    public boolean deleteUserDatabyname(String name) {
        return mSQLiteDatabase.delete(TABLE_NAME, USER_NAME + "=" + name, null) > 0;
    }
    //删除所有用户
    public boolean deleteAllUserDatas() {
        return mSQLiteDatabase.delete(TABLE_NAME, null, null) > 0;
    }

    //
    public String getStringByColumnName(String columnName, int id) {
        Cursor mCursor = fetchUserData(id);
        int columnIndex = mCursor.getColumnIndex(columnName);
        String columnValue = mCursor.getString(columnIndex);
        mCursor.close();
        return columnValue;
    }
    //
    public boolean updateUserDataById(String columnName, int id,
                                      String columnValue) {
        ContentValues values = new ContentValues();
        values.put(columnName, columnValue);
        return mSQLiteDatabase.update(TABLE_NAME, values, ID + "=" + id, null) > 0;
    }
    //根据用户名找用户，可以判断注册时用户名是否已经存在
    public int findUserByName(String userName){
        int result = 0;
        Cursor cursor = mSQLiteDatabase.query("users",null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("user_name"));
                if (userName.equals(name))
                {
                    Toast.makeText(mContext,"用户已存在",Toast.LENGTH_SHORT).show();
                    result=1;
                    return result;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        Log.i(TAG,"findUserByName");
        return result;
    }
    //根据用户名和密码找用户，用于登录
    public int findUserByNameAndPwd(String userName,String pwd){
        int result = 0;
        Cursor cursor = mSQLiteDatabase.query("users",null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("user_name"));
                String password = cursor.getString(cursor.getColumnIndex("user_pwd"));
                if (userName.equals(name)&&password.equals(pwd))
                {
                    Toast.makeText(mContext,"登录成功",Toast.LENGTH_SHORT).show();
                    result=1;
                    return result;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        Log.i(TAG,"findUserByNameAndPwd");
        return result;
    }


}
