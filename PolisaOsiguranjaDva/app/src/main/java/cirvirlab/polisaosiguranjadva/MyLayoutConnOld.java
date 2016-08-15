package cirvirlab.polisaosiguranjadva;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by velibor.pjevalica on 8/11/2016.
 */
public class MyLayoutConnOld extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] str_some_choice;
    private final Integer[] myLeftImageID;
    private final String[] str_some_sub_choice;
    private final Integer[] myRightImageID;



    public MyLayoutConnOld(Activity context, String[] str_some_choice, Integer[] myLeftImageID, String[] str_some_sub_choice, Integer[] myRightImageID) {

        super(context, R.layout.mylayout, str_some_choice);

        this.context = context;
        this.str_some_choice = str_some_choice;
        this.myLeftImageID = myLeftImageID;
        this.str_some_sub_choice = str_some_sub_choice;
        this.myRightImageID = myRightImageID;


    }
    public View getView( final int position,View view,final ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.mylayout, null, true);

        TextView txtChoice = (TextView)rowView.findViewById(R.id.textView);
        ImageView imageView =(ImageView)rowView.findViewById(R.id.imageButton);
        TextView txtSubChoice = (TextView)rowView.findViewById(R.id.textView2);
        ImageView imageView1 = (ImageView)rowView.findViewById(R.id.imageButton2);

        txtChoice.setText(str_some_choice[position]);
        imageView.setImageResource(myLeftImageID[position]);
        txtSubChoice.setText(str_some_sub_choice[position]);
        imageView1.setImageResource(myRightImageID[position]);

        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Toast.makeText(getContext(), "Image button was clicked for list item " + position, Toast.LENGTH_SHORT).show();
                if(position==3){
                    //final Context context = parent.getContext();
                    //FragmentManager fm = ((Activity) context).getFragmentManager();
                    //FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    //FotografijeOstecenja fotografijeOstecenja = new FotografijeOstecenja();
                    //fragmentTransaction.replace(android.R.id.content,fotografijeOstecenja);
                    //fragmentTransaction.addToBackStack(null);
                    //fragmentTransaction.commit();

                }
            }
        });

        return rowView;

    }

}
