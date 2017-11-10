package bs.hackathon.group.hackathonbs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class NewEventActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        ImageButton kat00 = findViewById(R.id.katEdu);
        ImageButton kat01 = findViewById(R.id.katFood);
        ImageButton kat02 = findViewById(R.id.katMobil);
        ImageButton kat03 = findViewById(R.id.katBetreu);

        kat00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeToNextStep();

            }
        });
        kat01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeToNextStep();

            }
        });
        kat02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeToNextStep();

            }
        });
        kat03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeToNextStep();

            }
        });


    }

    public void changeToNextStep() {
        startActivity(new Intent(NewEventActivity.this, NewEvent01Activity.class));

    }

}
