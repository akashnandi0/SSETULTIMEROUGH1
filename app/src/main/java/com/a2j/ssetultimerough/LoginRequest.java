package com.a2j.ssetultimerough;

import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.Response;

/**
 * Created by HP on 23-03-2017.
 */


public class LoginRequest extends StringRequest {
    private static final String Register_Request_URL="https://a2j.000webhostapp.com/Login.php";
    private Map<String,String> params;


    public LoginRequest(String username,String password,Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        params.put("username",username);
        params.put("password",password);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
