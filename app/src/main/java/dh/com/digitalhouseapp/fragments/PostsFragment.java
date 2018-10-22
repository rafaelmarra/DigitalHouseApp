package dh.com.digitalhouseapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import dh.com.digitalhouseapp.R;
import dh.com.digitalhouseapp.adapter.RecyclerViewPostAdapter;
import dh.com.digitalhouseapp.interfaces.FragmentClick;
import dh.com.digitalhouseapp.model.Post;
import dh.com.digitalhouseapp.model.dao.PostDAO;

public class PostsFragment extends Fragment implements RecyclerViewPostAdapter.OnCardClickListener{

    private FragmentClick listener;

    public PostsFragment(){
    }

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

        PostDAO postDAO = new PostDAO();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_posts_id);
        recyclerView.setAdapter(new RecyclerViewPostAdapter(postDAO.getPosts(getContext()), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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


    @Override
    public void onShareClick(Post post) {
        listener.onItemClick(post);

    }
}
