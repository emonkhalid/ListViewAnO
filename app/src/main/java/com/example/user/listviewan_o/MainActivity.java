package com.example.user.listviewan_o;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AdapterItems> listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here we added 3 demo news with id, title and details inside listnewsData
        listnewsData.add(new AdapterItems(1,"Cricket"," Bangladesh cant Stand in first test against Zimbabuya"));
        listnewsData.add(new AdapterItems(2,"Football","Champion League Bercelona vs Inter Milan (1 VS 1)"));
        listnewsData.add(new AdapterItems(3,"Pixel 3","Google latest Pixel 3 just released at USA."));

        myadapter=new MyCustomAdapter(listnewsData);
        ListView lsNews=(ListView)findViewById(R.id.listview1);

        //Here listview is set with listnewsData
        lsNews.setAdapter(myadapter);//intisal with data

    }

    //This is a private class to
    private class MyCustomAdapter extends BaseAdapter {

        public ArrayList<AdapterItems> listnewsDataAdpater ;


        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater = listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.list_item_layout, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView tvNewID=(TextView)myView.findViewById(R.id.textView1);
            tvNewID.setText("ID="+s.newID);

            final TextView tvNewTitle=(TextView)myView.findViewById(R.id.textView2);
            tvNewTitle.setText(s.newTitle);
            
            TextView tvNewDetails=(TextView)myView.findViewById(R.id.textView3);
            tvNewDetails.setText(s.newDetails);

            return myView;
        }

    }

}
