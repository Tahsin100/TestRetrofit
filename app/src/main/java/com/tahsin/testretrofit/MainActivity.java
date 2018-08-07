package com.tahsin.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tahsin.testretrofit.adapters.NoticeAdapter;
import com.tahsin.testretrofit.interfaces.GetNoticeDataResponse;
import com.tahsin.testretrofit.models.Notice;
import com.tahsin.testretrofit.network.RetrofitClient;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements NoticeAdapter.AdapterCallback {

    private GetNoticeDataResponse service;

    private RecyclerView recyclerViewNotice;
    private Button buttonSubmit;
    private Boolean isOkay = false;
    private int[] values = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotice = findViewById(R.id.recyclerViewNotice);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i =0 ; i < 10; i++){
                    if(values[i] == 0) {
                        isOkay = false;
                        Log.d("Array" + i + "->", String.valueOf(values[i]));
                        break;
                    }
                    isOkay = true;
                }

               if (isOkay)
                   Toast.makeText(MainActivity.this, "Submitted successfully!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Some fields are empty!", Toast.LENGTH_SHORT).show();
            }
        });

        service = RetrofitClient.getRetrofitInstance().create(GetNoticeDataResponse.class);
        Call<Notice.NoticeList> call =  service.getNoticeData();

        call.enqueue(new Callback<Notice.NoticeList>() {
            @Override
            public void onResponse(Call<Notice.NoticeList> call, Response<Notice.NoticeList> response) {
                if(response.body() != null)
                {
                    setRecyclerView(response.body().getNotice_List());
                }
            }

            @Override
            public void onFailure(Call<Notice.NoticeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView(ArrayList<Notice> notice_list) {
        NoticeAdapter adapter = new NoticeAdapter(this, notice_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewNotice.setLayoutManager(layoutManager);
        recyclerViewNotice.setAdapter(adapter);
    }


    @Override
    public void onMethodCallback(int position, int value) {
        values[position] = value;
    }
}
