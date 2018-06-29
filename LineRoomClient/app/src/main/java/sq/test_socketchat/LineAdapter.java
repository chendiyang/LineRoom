package sq.test_socketchat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chendsir on 18-6-29.
 */

public class LineAdapter extends ArrayAdapter<LineRoom>{
    private int resourceId;
    public LineAdapter(@NonNull Context context,int textViewResourceId, List<LineRoom> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LineRoom lineRoom = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView lineImage= (ImageView) view.findViewById(R.id.line_image);
        TextView lineName = (TextView) view.findViewById(R.id.lineroom_name);
        lineImage.setImageResource(lineRoom.getImageId());
        lineName.setText(lineRoom.getName());

        return view;
    }
}
