package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private Button okButton, cancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var04_secondary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);

        ButtonClickListener listener = new ButtonClickListener();

        okButton.setOnClickListener(listener);
        cancelButton.setOnClickListener(listener);

        Intent intent = getIntent();

        if(intent != null)
        {
            String firstTextBox = intent.getStringExtra("nameBox");
            String secondTextBox = intent.getStringExtra("groupBox");

            EditText firstText = findViewById(R.id.numeBox);
            EditText secondText = findViewById(R.id.grupaBox);

            firstText.setText(firstTextBox);
            secondText.setText(secondTextBox);
        }
    }

    protected class ButtonClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            int id = v.getId();

            if(id == R.id.okButton)
            {
                setResult(RESULT_OK, null);
                finish();
            }
            else if(id == R.id.cancelButton)
            {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        }
    }
}