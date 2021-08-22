package com.example.clubnba.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.clubnba.Adapters.NewsAdapter;
import com.example.clubnba.Models.MySingleton;
import com.example.clubnba.Models.News;
import com.example.clubnba.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsFragment extends Fragment {
    private RequestQueue requestQueue;
    private ArrayList<News> arrayList;
    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        arrayList = new ArrayList<>();
        requestQueue = MySingleton.getInstance(getContext()).getRequestQueue();
        fetchData();
        return view;
    }
    private void fetchData() {
        //String url = "https://newsapi.org/v2/everything?q=tesla&from=2021-07-16&sortBy=publishedAt&apiKey=4907359357e14e059ac942fab5a2c04b1";
        String url = "https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=f9399b976b2446019374c0f7290fd25b";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject articles = jsonArray.getJSONObject(i);
                        String title = articles.getString("title");
                        String poster = articles.getString("image");

                        News news = new News(title, poster);
                        arrayList.add(news);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                NewsAdapter adapter = new NewsAdapter(getContext(), arrayList);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
