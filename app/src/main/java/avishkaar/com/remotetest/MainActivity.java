package avishkaar.com.remotetest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements dialog.send_to_activity {
    Button button1;
    Button button2;
    public String motor_main;
    public  String config;
    EditText editText;
    int flag;
    TextView textView ;
    TextView textView2;
    Button button3;
    Button button4;
    @Override
    public void stringforactivity(String motor, String configuration) {
        motor_main = motor;
        config = configuration;
        editText.setText(motor+config);
        prefupdater();
        textView.setText(motor_main);
        textView2.setText(config);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = findViewById(R.id.button2);
        button1 = findViewById(R.id.button);
        editText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog dialog_call = new dialog();
               dialog_call.show(getSupportFragmentManager(),"THIS FRAGMENT");
               flag=1;

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog dialog_call = new dialog();
                dialog_call.show(getSupportFragmentManager(),"THIS FRAGMENT");
                flag=2;


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog dialog_call = new dialog();
                dialog_call.show(getSupportFragmentManager(),"THIS FRAGMENT");
                flag=3;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog dialog_call = new dialog();
                dialog_call.show(getSupportFragmentManager(),"THIS FRAGMENT");
                flag=4;
            }
        });

    }
        void prefupdater()
        {   SharedPreferences sharedPreferences = getSharedPreferences("Share", Context.MODE_PRIVATE);
            final SharedPreferences.Editor edit = sharedPreferences.edit();
            switch (flag){
                case 1:
                    edit.putString("button1",motor_main+config);
                    edit.apply();
                    break;

                case 2:
                    edit.putString("button2",motor_main+config);
                    edit.apply();
                    break;
                case 3:
                    edit.putString("button3",motor_main+config);
                    edit.apply();

                case 4:
                    edit.putString("button4",motor_main+config);
                    edit.apply();
            }

        }



}
