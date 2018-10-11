package dh.com.digitalhouseapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dh.com.digitalhouseapp.fragments.CommentsFragment;
import dh.com.digitalhouseapp.fragments.PostsFragment;
import dh.com.digitalhouseapp.interfaces.FragmentClick;
import dh.com.digitalhouseapp.model.Post;

public class HomeActivity extends AppCompatActivity implements FragmentClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(new PostsFragment(), R.id.content_one, "POSTS");
    }

    public void replaceFragment(Fragment fragment, int container, String stack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment);
        transaction.addToBackStack(stack);
        transaction.commit();
    }

    @Override
    public void onItemClick(Post post) {
        Fragment fragment = new CommentsFragment();

        Bundle bundle = new Bundle();
        bundle.putString("TEXT", post.getDescription());

        fragment.setArguments(bundle);
        replaceFragment(fragment, R.id.content_two, "COMMENTS");
    }
}
