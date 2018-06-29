package sq.test_socketchat;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by chendsir on 18-6-28.
 */

public class Usermanage {
    private MyDatabaseHelper dbHelper;
    private Context mContext;

    public Usermanage() {
        dbHelper = new MyDatabaseHelper(mContext,"users",null,1);

    }
//    public int findUserByNameAndPwd(String userName,String pwd){
//        Cursor cursor = mSQLiteDatabase.query("users",null,null,null,null,null);
//
//        return result;
//    }

}
