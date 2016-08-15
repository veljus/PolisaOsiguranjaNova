package cirvirlab.polisaosiguranjanova;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ArrayList<String> data = new ArrayList<String>();
    private  String podaci[] = {"A","B","C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lw = (ListView)findViewById(R.id.listView);
        data.add("1");
        data.add("2");
        data.add("3");

         lw.setAdapter(new MyListAdapter(this, R.layout.mylayout,data));
        // lw.setAdapter(new MyListAdapter(this, R.layout.mylayout, podaci));

    }
    private class MyListAdapter extends ArrayAdapter<String> {
        private int layout;
        public MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewHolder = null;
            if(convertView == null){
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                convertView = layoutInflater.inflate(layout,parent,false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.imgLeftButton = (ImageButton)convertView.findViewById(R.id.imgLevo);
                viewHolder.title = (TextView)convertView.findViewById(R.id.txtTitle);
                viewHolder.subtitle=(TextView)convertView.findViewById(R.id.txtSubTitle);
                viewHolder.imgRightButton=(ImageButton)convertView.findViewById(R.id.imgDesno);
                viewHolder.imgLeftButton.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Toast.makeText(getContext(),"Image button was clicked for list item " + position, Toast.LENGTH_SHORT).show();

                        // FragmentManager fragmentManager = getFragmentManager();
                    }
                });
                convertView.setTag(viewHolder);
            }
            else {
                mainViewHolder=(ViewHolder)convertView.getTag();
                mainViewHolder.title.setText(getItem(position));
            }
            //return super.getView(position, convertView, parent);
            return convertView;
        }
    }
    public class ViewHolder{
        ImageButton imgLeftButton;
        TextView title;
        TextView subtitle;
        ImageButton imgRightButton;
    }
}