package com.artise.natrapharmutil;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import app.rocketship.pedia.pedia.R;

/**
 * Created by Candice on 14/02/2017.
 */

public abstract class RegisterActivityAbstract extends AppCompatActivity {

    private EditText emailField;
    private EditText nameField;
    private EditText contactField;
    private EditText departmentField;

    private Button submitButton;



    protected abstract int getContentView();
    protected abstract DataHandler.UserType getUserType();


    protected void initializeActivity(){
        DataHandler.setCurrentContext(this);

        emailField = (EditText) findViewById(R.id.emailField);
        nameField = (EditText) findViewById(R.id.nameField);
        contactField = (EditText) findViewById(R.id.emailField);
        departmentField = (EditText) findViewById(R.id.departmentField);

        submitButton = (Button) findViewById(R.id.submitButton);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getContentView());


        initializeActivity();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Map<String, String> requestParams = new HashMap<>();

                requestParams.put("action", "create_user");
                requestParams.put(DataHandler.UserFields.EMAIL.getKey(), emailField.getText().toString());
                requestParams.put(DataHandler.UserFields.NAME.getKey(), nameField.getText().toString());
                requestParams.put(DataHandler.UserFields.CONTACT.getKey(), contactField.getText().toString());
                requestParams.put(DataHandler.UserFields.DEPARTMENT.getKey(), departmentField.getText().toString());
                requestParams.put(DataHandler.UserFields.USER_TYPE.getKey(), getUserType().toString());


                requestParams.put(
                        DataHandler.UserFields.DEVICE_FINGERPRINT.getKey(),
                        ((WifiManager) getSystemService(Context.WIFI_SERVICE))
                                .getConnectionInfo()
                                .getMacAddress()
                );


                DataHandler.registerUser(requestParams);
            }
        });
    }


}
