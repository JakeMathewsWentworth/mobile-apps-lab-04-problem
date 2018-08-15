package myfragment.mobileapp.wit.edu.lab4_problem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        final String gender = getIntent().getStringExtra(getString(R.string.gender_key));
        final String height = getIntent().getStringExtra(getString(R.string.height_key));
        final String standardWeight = getIntent().getStringExtra(getString(R.string.weight_key));

        TextView genderTextView = (TextView) findViewById(R.id.genderValueTextView);
        TextView heightTextView = (TextView) findViewById(R.id.heightValueTextView);
        TextView weightTextView = (TextView) findViewById(R.id.weightValueTextView);

        genderTextView.setText(gender);
        heightTextView.setText(height);
        weightTextView.setText(standardWeight);
    }
}
