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

public class PostsFragment extends Fragment implements RecyclerViewPostAdapter.OnCardClickListener{

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

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_posts_id);
        recyclerView.setAdapter(new RecyclerViewPostAdapter(createPostList(), this));
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

    private List<Post> createPostList(){
        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("Nova turma iniciada!");
        post1.setDescription("Em setembro iniciamos uma nova turma de Marketing Digital");
        postList.add(post1);

        Post post2 = new Post();
        post2.setTitle("Nova turma iniciada!");
        post2.setDescription("Em outubro iniciamos a nova turma de Full Stack");
        postList.add(post2);

        Post post3 = new Post();
        post3.setTitle("Alteração no preço do café!");
        post3.setDescription("O preço do café foi reajustado!");
        postList.add(post3);

        return postList;
    }

    @Override
    public void onShareClick(Post post) {
        listener.onItemClick(post);

    }
}
