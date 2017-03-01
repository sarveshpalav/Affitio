package app.affito.com.affito;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sarveshpalav on 28/02/17.
 */
public class LivingRoomFragment extends Fragment {

    private ProgressBar pgbar;
    String url = "http://192.168.43.24/lol.json";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView;


        View v = inflater.inflate(R.layout.fragment_livingroom, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        pgbar = (ProgressBar) v.findViewById(R.id.pgbar);


        loaddata();

        return v;
    }


    public void loaddata() {
        class Loaddata extends AsyncTask<String, String, String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                pgbar.setVisibility(View.VISIBLE);


            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();
                JSONArray array = null;
                try {
                     array = new JSONArray(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for(int i=0;i<array.length();i++){
                    try {
                        JSONObject e = array.getJSONObject(i);
                        Log.d("Living",e.getString("name"));     e.get("name");

                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }

                }


                pgbar.setVisibility(View.INVISIBLE);

            }

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(String... strings) {



                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(url)
                        .build();

String a;

                try (Response response = client.newCall(request).execute()) {
                    a = response.body().string();
                    return a;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        new Loaddata().execute();
    }
}
