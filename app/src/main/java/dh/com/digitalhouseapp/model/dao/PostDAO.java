package dh.com.digitalhouseapp.model.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dh.com.digitalhouseapp.model.Post;

public class PostDAO {

    public List<Post> getPosts(Context context) {

        List<Post> postList = new ArrayList<>();

        Gson gson = new Gson();

        try {
            AssetManager manager = context.getAssets();
            InputStream newsJson = manager.open("posts.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(newsJson));

            Post[] postArray = gson.fromJson(bufferReaderIn, Post[].class);

            postList.addAll(Arrays.asList(postArray));

        } catch (IOException e) {
            Log.e("JSON", "ERRO AO LER ARQUIVO posts.json");
        }

        return postList;
    }

}