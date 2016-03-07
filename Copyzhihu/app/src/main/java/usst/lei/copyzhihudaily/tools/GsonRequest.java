package usst.lei.copyzhihudaily.tools;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lei on 2016/3/7.
 */
public class GsonRequest<T extends Serializable> extends Request<T> {
  private  Gson mGson;
 private TypeToken<T> mTypeToken;
    private Class<T> mClazz;
    private Response.Listener<T>mListenr;
    Map<String,String> mMap;



    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (mMap !=null) return mMap;
        return super.getHeaders();
    }
    public GsonRequest(int method,String url,Response.Listener<T> listener,Map<String,String> map,Class<T>clazz,Response.ErrorListener errlistener){
        this(method,url,errlistener);
        mListenr=listener;
        mMap=map;
        mClazz=clazz;
    }
    public GsonRequest(int method,String url,Response.Listener<T> listener,Class<T>clazz,Response.ErrorListener errlistener){
        this(method,url,listener,null,clazz,errlistener);
    }
    public GsonRequest(int method,String url,Response.Listener<T> listener,Map<String,String> map,TypeToken<T> typeToken,Response.ErrorListener errlistener){
        this(method,url,errlistener);
        mListenr=listener;
        mMap=map;
        mTypeToken=typeToken;
    }
    public GsonRequest(int method,String url,Response.Listener<T> listener,TypeToken<T> typeToken,Response.ErrorListener errlistener){
        this(method,url,listener,null,typeToken,errlistener);
    }
    public GsonRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
        mGson=new Gson();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
      try {
          String s=new String(response.data, HttpHeaderParser.parseCharset(response.headers));
          if (mClazz!=null){
              return Response.success(mGson.fromJson(s,mClazz),HttpHeaderParser.parseCacheHeaders(response));
          }
          else return (Response<T>) Response.success(mGson.fromJson(s,mTypeToken.getType()),HttpHeaderParser.parseCacheHeaders(response));
      } catch (UnsupportedEncodingException e) {
          return Response.error(new ParseError(e));
      }
    }

    @Override
    protected void deliverResponse(T response) {
        mListenr.onResponse(response);
    }
}
