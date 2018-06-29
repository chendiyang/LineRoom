package sq.test_socketchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chendsir on 18-6-29.
 */

public class UserActivity extends AppCompatActivity {
    private TextView accessLine;

    private Button mReturnButton;
    private String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        mReturnButton = (Button)findViewById(R.id.returnback);
//        accessLine = (TextView) findViewById(R.id.accessline);
//        accessLine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserActivity.this,MainActivity.class);
//                string="欢迎进入"+accessLine.getText().toString()+"聊天室";
//                Toast.makeText(UserActivity.this, string,Toast.LENGTH_SHORT).show();
//            }
//        });
//        mReturnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3 = new Intent(UserActivity.this,LoginActivity.class) ;
//                startActivity(intent3);
//                finish();
//            }
//        });
    }

}
