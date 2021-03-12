package com.nada.mondiaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.nada.mondiaassignment.adapters.SearchAdapter;
import com.nada.mondiaassignment.api.RetrofitBulider;
import com.nada.mondiaassignment.interfaces.SearchInterface;
import com.nada.mondiaassignment.model.AccessToken;
import com.nada.mondiaassignment.model.MainModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements SearchAdapter.OnItemClickListener {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_ARTIST = "artist";
    public static final String EXTRA_TYPE = "type";

    private EditText inputText;

    private RecyclerView searchRecyclerView;
    private SearchAdapter searchAdapter;
    private List<MainModel> modelList;

    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        inputText = (EditText) findViewById(R.id.search_bar);

        searchRecyclerView = (RecyclerView) findViewById(R.id.list_item);
        searchRecyclerView.setHasFixedSize(true);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList = new ArrayList();

        SearchInterface loginInterface = RetrofitBulider.getAccessTokenClient().create(SearchInterface.class);
        loginInterface.getToken().enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                token = response.body().getAccessToken();
//                getSongList();
            }
            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
            }
        });

        ///////////////////

        inputText.setOnEditorActionListener(editorListener);

    }

    private void getSongList(String value) {
        SearchInterface searchInterface = RetrofitBulider.getClient().create(SearchInterface.class);
        Call<List<MainModel>> call = searchInterface.getList("Bearer " + token, value);
        call.enqueue(new Callback<List<MainModel>>() {

            @Override
            public void onResponse(Call<List<MainModel>> call, Response<List<MainModel>> response) {
                modelList = response.body();
                searchAdapter = new SearchAdapter(modelList, getApplicationContext());
                searchRecyclerView.setAdapter(searchAdapter);

                searchAdapter.setOnItemClickListener(SearchActivity.this);

            }

            @Override
            public void onFailure(Call<List<MainModel>> call, Throwable throwable) {
                Log.d("MainActivity", throwable.toString());
            }

        });
    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_NEXT: {
                    getSongList(inputText.getText().toString());
                    break;
                }
                case EditorInfo.IME_ACTION_SEND: {
                    break;
                }
            }
            return false;
        }
    };

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailsActivity.class);

        MainModel clickedItem = modelList.get(position);

        intent.putExtra(EXTRA_TITLE, clickedItem.getTitle());
        intent.putExtra(EXTRA_ARTIST, clickedItem.getMainArtist().getName());
        intent.putExtra(EXTRA_TYPE, clickedItem.getType());

        startActivity(intent);
    }

}