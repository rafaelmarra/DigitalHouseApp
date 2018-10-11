package dh.com.digitalhouseapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import dh.com.digitalhouseapp.R;
import dh.com.digitalhouseapp.interfaces.FragmentClick;
import dh.com.digitalhouseapp.model.Post;

public class PostsFragment extends Fragment{

    private FragmentClick listener;

    public PostsFragment(){ }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (FragmentClick) context;
        } catch (ClassCastException e){
            Log.i("LOG", "Não pode converter class: " + e.getMessage());
            throw new ClassCastException("Não pode converter class: ");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        Button btnSend = view.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post();
                post.setDescription("Descrição do post enviado");
                listener.onItemClick(post);
            }
        });

        return view;
    }
}
