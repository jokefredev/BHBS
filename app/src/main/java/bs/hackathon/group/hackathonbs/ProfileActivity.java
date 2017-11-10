package bs.hackathon.group.hackathonbs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import bs.hackathon.group.hackathonbs.Adapter.CustomAdapter;

public class ProfileActivity extends AppCompatActivity {

    private ListView categoryListView;
    private String[] categories = {"Ernährung", "Mobilität", "Betreuung", "Bildung"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        categoryListView = findViewById(R.id.listview_category);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), categories);
        categoryListView.setAdapter(customAdapter);
    }
}
