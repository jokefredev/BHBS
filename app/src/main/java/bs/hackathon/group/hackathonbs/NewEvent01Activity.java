package bs.hackathon.group.hackathonbs;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;

import bs.hackathon.group.hackathonbs.model.Task;

public class NewEvent01Activity extends AppCompatActivity {

    TextView locationSetting;
    EditText locationView;
    //CalendarView calView;
    TimePicker timeView;
    boolean timeVisible = false;
    //boolean calVisible = false;
    boolean loc01 = false;
    boolean loc02 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event01);
        // Button dateBtn = findViewById(R.id.buttonDate);
        Button gesuchSubmit = findViewById(R.id.button3);
        Button timeBtn = findViewById(R.id.buttonTime);
        Button locationBtn = findViewById(R.id.buttonLocation);
        locationView = findViewById(R.id.editText4);
        locationSetting = findViewById(R.id.textView15);
        // calView = (CalendarView) findViewById(R.id.calendarView);
        timeView = findViewById(R.id.timePicker2);

        gesuchSubmit.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                changeToEventList();
            }
        });

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLocation();
            }
        });

        //dateBtn.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //   public void onClick(View view) {
        //        toggleDatePicker();
        //    }
        //});

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleTimePicker();
            }
        });

    }

    public void changeLocation() {
        locationView.setVisibility(loc01 ? View.GONE : View.VISIBLE);
        loc01 = !loc01;
        locationSetting.setVisibility(loc02 ? View.VISIBLE : View.GONE);
        loc02 = !loc02;
    }

    //public void toggleDatePicker() {

    //    calView.setVisibility(calVisible ? View.GONE : View.VISIBLE);
    //    calVisible = !calVisible;

    //}

    public void toggleTimePicker() {

        timeView.setVisibility(timeVisible ? View.GONE : View.VISIBLE);
        timeVisible = !timeVisible;
        View targetView = timeView;
        targetView.getParent().requestChildFocus(targetView, targetView);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void changeToEventList() {

        // HIER WECHSEL ZUR LISTEN BZW KARTEN ANSICHT
        // TODO ENDE

        String title = ((EditText) findViewById(R.id.eventTitle)).getText().toString();
        String date = new SimpleDateFormat("yyyy.MM.dd").format(((CalendarView) findViewById(R.id.calendarView)).getDate());
        String time = String.format("%d : %d", ((TimePicker) findViewById(R.id.timePicker2)).getHour(), ((TimePicker) findViewById(R.id.timePicker2)).getMinute());
        String content = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String location = ((EditText) findViewById(R.id.editText4)).getText().toString();

        DefaultView.insertRequest(new Task(title, content, date, time, location));

        Intent intent = new Intent(this, DefaultView.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
