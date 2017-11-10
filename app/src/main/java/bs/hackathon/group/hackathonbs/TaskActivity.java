package bs.hackathon.group.hackathonbs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import bs.hackathon.group.hackathonbs.model.Task;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();

        int position = intent.getIntExtra("number", 0);

        Task task = DefaultView.getRequestTask(position);

        ((TextView) findViewById(R.id.textView8)).setText(task.title);
        ((TextView) findViewById(R.id.textView9)).setText(String.format("%s | %s", task.date, task.time));
        ((TextView) findViewById(R.id.textView10)).setText(task.location);
        ((TextView) findViewById(R.id.textView11)).setText(task.content);
    }
}
