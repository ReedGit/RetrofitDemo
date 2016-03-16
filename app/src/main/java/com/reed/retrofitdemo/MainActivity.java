package com.reed.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.text)
    public TextView text;

    @Bind(R.id.text2)
    public TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        GitHubService service = RetrofitUtil.getService();
        Call<String> repos = service.listRepos();
        repos.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                String str = response.body();
                text.setText(str);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("info",t.getMessage());
            }
        });
        Call<String> call = service.repos(1);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                text2.setText(result);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("info",t.getMessage());
            }
        });
    }
}
