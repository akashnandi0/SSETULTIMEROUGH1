package com.a2j.ssetultimerough;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HP on 02-04-2017.
 */

public class EventRequest extends StringRequest {
    private static final String Register_Request_URL="https://a2j.000webhostapp.com/Registerevent.php";
    private Map<String,String> params;


    public EventRequest(String eid,String ename,String studname,String sid, Response.Listener<String> listener){

        super(Method.POST,Register_Request_URL,listener,null);
        params= new HashMap<>( );
        params.put("eventid",eid);
        params.put("eventname",ename);
        params.put("studentname",studname);
        params.put("studentid",sid);



    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
