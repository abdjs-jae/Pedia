package app.rocketship.pedia.pedia;


import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.rocketship.pedia.pedia.R;
import app.rocketship.pedia.pedia.users.DataHandler;
import app.rocketship.pedia.pedia.users.RegisterActivityAbstract;

public class RegisterActivity extends RegisterActivityAbstract {


    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected DataHandler.UserType getUserType() {
        return DataHandler.UserType.USER;
    }
}
