package com.stephensparker.sb_apcstudentlogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    private Button buttonLogin, buttonClear;
    TextView txtViewWelcomeText;
    EditText  editTextuName, editTextpwd;
    String uName = "bob", pwd = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        StrictMode.ThreadPolicy policy = new StrictMode.
//        ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        // find the ID of the TextView
        txtViewWelcomeText= (TextView) findViewById(R.id.txtViewWelcomeText);
        editTextuName = (EditText) findViewById(R.id.edituName);
        editTextpwd = (EditText) findViewById(R.id.editpwd);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        addListenerOnClickLogin();
        addListenerOnClickClear();
    }

    public void addListenerOnClickClear() {

        buttonClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // clear the output view
                txtViewWelcomeText.setText(null);
            }

        });

    }

    public void addListenerOnClickLogin() {

        //Select a specific button to bundle it with the action you want

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                try {
                    if (editTextuName.getText().toString().equals(uName)) {
                            if (editTextpwd.getText().toString().equals(pwd)) {
                                txtViewWelcomeText.setText("Welcome to the world " + uName);
                                //editTextuName.setText(null);
                            }
                    } else {
                        txtViewWelcomeText.setText("Sorry Dude we can't find you in the world");
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                    txtViewWelcomeText.setText(e.toString());

                }
            }


        });

    }
}
