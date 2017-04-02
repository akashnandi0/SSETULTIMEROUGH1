package com.a2j.ssetultimerough;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LOGIN_ACTIVITY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login__activity );


        final EditText etusername = (EditText) findViewById( R.id.uname );
        final EditText etpassword = (EditText) findViewById( R.id.pswd );
        final Button blogin = (Button) findViewById( R.id.blogin );

        blogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String username = etusername.getText().toString();
                final String password = etpassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject( response );
                            boolean success = jsonResponse.getBoolean( "success" );


                            if (success) {
                                Toast.makeText( getApplicationContext(),"Login ", Toast.LENGTH_SHORT ).show();

                                Intent MEMBER_LOGIN = new Intent(LOGIN_ACTIVITY.this, MEMBER_LOGIN.class);
                                startActivity(MEMBER_LOGIN);
                                Toast.makeText( getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT ).show();




                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder( LOGIN_ACTIVITY.this );
                                builder.setMessage( "Login failed" )
                                        .setNegativeButton( "Retry", null )
                                        .create()
                                        .show();


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest = new LoginRequest( username, password, responseListener );
                RequestQueue queue = Volley.newRequestQueue( LOGIN_ACTIVITY.this );
                queue.add( loginRequest );
            }
        } );

    }
    public void fP(View view)
    {
        Intent Forgotpassword = new Intent(LOGIN_ACTIVITY.this, Forgotpassword.class);
        startActivity(Forgotpassword);
    }
    public void sGUP(View view)
    {
        Intent create_account = new Intent(LOGIN_ACTIVITY.this, create_account.class);
        startActivity(create_account);
    }
}