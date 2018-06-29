package sq.test_socketchat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by chendsir on 18-6-28.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "UserDataManager";
    private static final String DB_NAME = "user_data";
    private static final String TABLE_NAME = "users";
    public static final String ID = "_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_PWD = "user_pwd";
    //    public static final String SILENT = "silent";
//    public static final String VIBRATE = "vibrate";
    private static final int DB_VERSION = 2;
    private Context mContext = null;

    private static final String DB_CREATE = "create table users ("
            +"id integer primary key autoincrement,"
            +"user_name text,"
            +"user_pwd text)";

    public  MyDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name,factory,version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB_CREATE);
        Toast.makeText(mContext,"Create Succeeded",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
