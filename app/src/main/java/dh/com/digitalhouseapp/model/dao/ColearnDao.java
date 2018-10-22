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

import dh.com.digitalhouseapp.model.Colearn;

public class ColearnDao {

    public List<Colearn> getColearns(Context context) {

        List<Colearn> colearnList = new ArrayList<>();

        Gson gson = new Gson();

        try {
            AssetManager manager = context.getAssets();
            InputStream colearnJson = manager.open("colearn.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(colearnJson));

            Colearn[] colearnArray = gson.fromJson(bufferReaderIn, Colearn[].class);

            colearnList.addAll(Arrays.asList(colearnArray));

        } catch (IOException e) {
            Log.e("JSON", "ERRO AO LER ARQUIVO colearn.json");
        }

        return colearnList;
    }

}
