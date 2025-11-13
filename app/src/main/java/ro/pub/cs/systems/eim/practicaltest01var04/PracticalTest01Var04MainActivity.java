package ro.pub.cs.systems.eim.practicaltest01var04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private Button displayButton;

    private EditText firstText, secondText;

    private CheckBox firstCheckbox, secondCheckbox;

    private TextView resultTextBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var04_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstText = findViewById(R.id.firstTextBox);
        secondText = findViewById(R.id.secondTextBox);

        resultTextBox = findViewById(R.id.nonEditBox);

        firstCheckbox = findViewById(R.id.firstCheckbox);
        secondCheckbox = findViewById(R.id.secondCheckbox);


        displayButton = findViewById(R.id.displayButton);

        ButtonClickListener listener = new ButtonClickListener();

        displayButton.setOnClickListener(listener);
    }

    protected class ButtonClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            int id = v.getId();

            if(id == R.id.displayButton)
            {
                if(firstCheckbox.isChecked() && secondCheckbox.isChecked())
                {
                    String firstTextWrite;
                    String secondTextWrite;
                    firstTextWrite = firstText.getText().toString();
                    secondTextWrite = secondText.getText().toString();

                    resultTextBox.setText(firstTextWrite + " " + secondTextWrite);
                }
                else if(firstCheckbox.isChecked() && !(secondCheckbox.isChecked()))
                {
                    String firstTextWrite;
                    firstTextWrite = firstText.getText().toString();
                    resultTextBox.setText(firstTextWrite);
                }
                else if(!(firstCheckbox.isChecked()) && secondCheckbox.isChecked())
                {
                    String secondTextWrite;
                    secondTextWrite = secondText.getText().toString();
                    resultTextBox.setText(secondTextWrite);
                }
            }
        }
    }
}