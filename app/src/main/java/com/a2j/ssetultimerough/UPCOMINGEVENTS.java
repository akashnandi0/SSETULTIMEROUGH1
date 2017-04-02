package com.a2j.ssetultimerough;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

public class UPCOMINGEVENTS extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingevents);

        final EditText eventid = (EditText) findViewById(R.id.eventid);
        final EditText eventname = (EditText) findViewById(R.id.eventname);
        final EditText studname = (EditText) findViewById(R.id.studname);
        final EditText studid = (EditText) findViewById(R.id.studid);
        final Button button3 = (Button) findViewById(R.id.buttonregister);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(studid.length()>20){studid.setError("Invalid studentid");}
                else {
                    final String eid = eventid.getText().toString();
                    final String ename = eventname.getText().toString();
                    final String sname = studname.getText().toString();
                    final String sid = studid.getText().toString();
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success) {
                                    Intent intent = new Intent(UPCOMINGEVENTS.this, UPCOMINGEVENTS2.class);
                                    UPCOMINGEVENTS.this.startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(UPCOMINGEVENTS.this);
                                    builder.setMessage("Register failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    };


                    EventRequest registerRequest = new EventRequest(eid, ename, sname, sid, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(UPCOMINGEVENTS.this);
                    queue.add(registerRequest);

                }
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
}


