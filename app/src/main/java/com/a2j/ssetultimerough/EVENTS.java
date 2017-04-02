package com.a2j.ssetultimerough;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EVENTS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
    }
    public void uEV(View view) {
        Intent UPCOMINGEVENTS = new Intent(EVENTS.this, UPCOMINGEVENTS.class);
        startActivity(UPCOMINGEVENTS);
    }
}
