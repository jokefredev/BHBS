package bs.hackathon.group.hackathonbs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ComplaintActivity extends AppCompatActivity {

    private Button submitComplaintButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        submitComplaintButton = findViewById(R.id.send_complaint_button);

        submitComplaintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Beschwerde gesendet", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
