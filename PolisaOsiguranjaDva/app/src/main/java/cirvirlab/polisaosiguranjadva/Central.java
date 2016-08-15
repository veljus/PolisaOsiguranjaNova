package cirvirlab.polisaosiguranjadva;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Central extends Fragment {
    ListView listView;
    String[] str_title = {"Detalji nezgode","Polisa osiguranja","Osigurano vozilo","Oštećenja","Vlasnik vozila","Foto dokumentacija"};
    String[] str_sub_title = {"unesite detalje štete","unesite podatke o osiguranju","unesite podatke osiguranog vozila","unesite podatke o vlasniku vozila","unesite podatke o oštećenjima","unesite podatke o vlasniku vozila","slikajte saobraćajnu, platnu karticu..."};
    Integer[] int_image_left = {R.drawable.detalji,R.drawable.polisa,R.drawable.osigurano,R.drawable.ostecenja,R.drawable.vlasnik,R.drawable.foto};
    Integer[] int_image_right = {R.drawable.striklirano,R.drawable.striklirano,R.drawable.striklirano,R.drawable.striklirano,R.drawable.striklirano,R.drawable.striklirano};

    public Central() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_central, container, false);
         // MyLayoutConn adapter = new MyLayoutConn(this, str_title,int_image_left,str_sub_title,int_image_right);
        MyLayoutConn adapter = new MyLayoutConn(this.getActivity(),str_title,int_image_left,str_sub_title,int_image_right);
       //  MyLayoutConn adapter = new MyLayoutConn(MainActivity.this,str_title,int_image_left,str_sub_title,int_image_right);
       listView = (ListView)view.findViewById(R.id.listView);
       listView.setAdapter(adapter);


        return view;
    }

   private final class MyLayoutConn extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] str_some_choice;
        private final Integer[] myLeftImageID;
        private final String[] str_some_sub_choice;
        private final Integer[] myRightImageID;



        public MyLayoutConn(Activity context, String[] str_some_choice, Integer[] myLeftImageID, String[] str_some_sub_choice, Integer[] myRightImageID) {

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

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        FotografijeOstecenja fotografijeOstecenja = new FotografijeOstecenja();
                        fragmentTransaction.replace(android.R.id.content,fotografijeOstecenja);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();



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


}
