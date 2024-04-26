package com.example.utspeber.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.utspeber.R;
import com.example.utspeber.data.respon.SerachRespon;
import com.example.utspeber.data.retrofit.ApiService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Panggilan API harus ditempatkan di dalam metode onCreate
        Call<SerachRespon> client = ApiService.getListUsers("1");
        client.enqueue(new Callback<SerachRespon>() {
            @Override
            public void onResponse(@NotNull Call<SerachRespon> call, @NotNull retrofit2.Response<SerachRespon> response) {
                if (response.isSuccessful()) {
                    // Tangani respons API di sini
                    List<DataItem> listUser = response.body().getData();
                    Log.d(TAG, "onResponse: " + listUser.toString());
                } else {
                    // Tangani kesalahan jika respons tidak berhasil
                    Log.e(TAG, "onResponse: Request not successful");
                }
            }

            @Override
            public void onFailure(@NotNull Call<SerachRespon> call, @NotNull Throwable t) {
                // Tangani kesalahan jaringan atau lainnya di sini
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();

    Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl("https://restaurant-api.dicoding.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build();
}
