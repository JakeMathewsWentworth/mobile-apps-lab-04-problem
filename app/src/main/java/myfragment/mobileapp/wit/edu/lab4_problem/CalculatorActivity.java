package myfragment.mobileapp.wit.edu.lab4_problem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent resultsIntent = calculate();
                startActivity(resultsIntent);
            }
        });
    }

    private Intent calculate() {
        final Intent intent = new Intent(getBaseContext(), ResultsActivity.class);

        // Gender
        final RadioGroup genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        final RadioButton checkedButton = (RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId());
        final String gender = checkedButton.getText().toString();
        intent.putExtra(getString(R.string.gender_key), gender);

        // Height
        final Spinner unit1Spinner = findViewById(R.id.unit1Spinner);
        final Spinner unit2Spinner = findViewById(R.id.unit2Spinner);
        final String heightUnit1 = unit1Spinner.getSelectedItem().toString();
        final String heightUnit2 = unit2Spinner.getSelectedItem().toString();
        final String height = heightUnit1 + "'" + heightUnit2 + "\"";
        intent.putExtra(getString(R.string.height_key), height);

        // Standard weight
        final int heightInches = (Integer.parseInt(heightUnit1) * 12) + Integer.parseInt(heightUnit2);
        final double maleBaseWeight = 50;
        final double femaleBaseWeight = 45.5;
        double standardWeight = 2.3 * (heightInches - 60);
        if (gender.equals(getString(R.string.gender_male_radio_btn))) {
            standardWeight = maleBaseWeight + standardWeight;
        } else if (gender.equals(getString(R.string.gender_male_radio_btn))){
            standardWeight = femaleBaseWeight + standardWeight;
        } else {
            standardWeight = 0;
        }
        final String standardWeightString = new DecimalFormat("#.##").format(standardWeight) + " kg";
        intent.putExtra(getString(R.string.weight_key), standardWeightString);

        return intent;
    }
}
