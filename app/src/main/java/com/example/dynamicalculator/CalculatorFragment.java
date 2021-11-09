package com.example.dynamicalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalculatorFragment extends Fragment {

RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_calculator, container, false);
        recyclerView=v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapter adapter=new RecyclerAdapter();


        //retrofit library
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        GitHubClient client=retrofit.create(GitHubClient.class);
        Call<List<GitRepos>> call=client.reposForUser("posts");
//        System.out.println("aftercall");
        call.enqueue(new Callback<List<GitRepos>>() {
            @Override
            public void onResponse(Call<List<GitRepos>> call, Response<List<GitRepos>> response) {
           List<GitRepos> list =response.body();

           adapter.setItems(list);
           recyclerView.setAdapter(adapter);
           System.out.println(adapter.getItems().get(90).getTitle());
           System.out.println(list.get(1).getBody());
           System.out.println("OPUtput");
            }

            @Override
            public void onFailure(Call<List<GitRepos>> call, Throwable t) {
                Toast.makeText(getContext(),"failure has occured",Toast.LENGTH_SHORT).show();
//            System.out.println("Onfaliure");
            }
        });

        return v;
    }
}