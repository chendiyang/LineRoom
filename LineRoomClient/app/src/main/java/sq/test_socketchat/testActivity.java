package sq.test_socketchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class testActivity extends AppCompatActivity {

    private List<LineRoom> lineRoomList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        initLineRoom();
        LineAdapter adapter = new LineAdapter(testActivity.this,R.layout.line_room_item,lineRoomList);
        ListView listView = (ListView) findViewById(R.id.linelist_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LineRoom lineRoom= lineRoomList.get(i);
                Intent intent = new Intent(testActivity.this,MainActivity.class);
                Toast.makeText(testActivity.this,lineRoom.getName(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private void initLineRoom() {
        for(int i=0; i<1;i++) {
            LineRoom lineRoom = new LineRoom("26号网络聊天室",R.mipmap.headleft);
            lineRoomList.add(lineRoom);
        }
    }
}
