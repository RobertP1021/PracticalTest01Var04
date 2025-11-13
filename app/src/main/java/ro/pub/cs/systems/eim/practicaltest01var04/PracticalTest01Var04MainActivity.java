package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    final public static String TAG                  = "pracTest04";
    private Button displayButton, navigateButton;

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
        navigateButton = findViewById(R.id.navigateButton);

        ButtonClickListener listener = new ButtonClickListener();

        displayButton.setOnClickListener(listener);
        navigateButton.setOnClickListener(listener);
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

                    if(firstTextWrite.isEmpty() && secondTextWrite.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Both text box are empty!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(firstTextWrite.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "First text box is empty!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(secondTextWrite.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Second text box is empty!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    resultTextBox.setText(firstTextWrite + " " + secondTextWrite);
                }
                else if(firstCheckbox.isChecked() && !(secondCheckbox.isChecked()))
                {
                    String firstTextWrite;
                    firstTextWrite = firstText.getText().toString();

                    if(firstTextWrite.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "First text box is empty!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    resultTextBox.setText(firstTextWrite);
                }
                else if(!(firstCheckbox.isChecked()) && secondCheckbox.isChecked())
                {
                    String secondTextWrite;
                    secondTextWrite = secondText.getText().toString();

                    if(secondTextWrite.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Second text box is empty!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    resultTextBox.setText(secondTextWrite);
                }
            }
            else if(id == R.id.navigateButton)
            {
                Intent intent = new Intent(PracticalTest01Var04MainActivity.this, PracticalTest01Var04SecondaryActivity.class);
                intent.putExtra("nameBox", firstText.getText().toString());
                intent.putExtra("groupBox", secondText.getText().toString());

                startActivityForResult(intent, 2024);
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2024)
        {
            if(resultCode == RESULT_OK)
            {
                Toast.makeText(this, "User Pressed OK Button",Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "User Pressed Cancel Button",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(TAG, "onRestart() method was invoked");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart() method was invoked");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume() method was invoked");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause() method was invoked");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop() method was invoked");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy() method was invoked");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        Log.d(TAG, "onSaveInstanceState was invoked");
        super.onSaveInstanceState(savedInstanceState);

        String firstTextWrite;
        firstTextWrite = firstText.getText().toString();

        String secondTextWrite;
        secondTextWrite = secondText.getText().toString();

        savedInstanceState.putString("firstTextBox", firstTextWrite);
        savedInstanceState.putString("secondTextBox", secondTextWrite);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        Log.d(TAG, "onRestoreInstanceState() method was invoked");
        super.onRestoreInstanceState(savedInstanceState);

        String firstTextWrite;
        String secondTextWrite;

        firstTextWrite = savedInstanceState.getString("firstTextBox");
        secondTextWrite = savedInstanceState.getString("secondTextBox");

        firstText.setText(firstTextWrite);
        secondText.setText(secondTextWrite);
    }
}