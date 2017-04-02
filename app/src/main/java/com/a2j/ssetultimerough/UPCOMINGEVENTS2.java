package com.a2j.ssetultimerough;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UPCOMINGEVENTS2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingevents2);
    }
    public void mM(View view) {
        Intent MEMBER_LOGIN = new Intent(UPCOMINGEVENTS2.this, MEMBER_LOGIN.class);
        startActivity(MEMBER_LOGIN);

    }
}
