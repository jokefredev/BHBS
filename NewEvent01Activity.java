package bs.hackathon.group.hackathonbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

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

        gesuchSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                changeToEventList();
            }
        });

        locationBtn.setOnClickListener(new View.OnClickListener(){
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
        targetView.getParent().requestChildFocus(targetView,targetView);

    }

    public void changeToEventList() {

        // HIER WECHSEL ZUR LISTEN BZW KARTEN ANSICHT



    }

}
