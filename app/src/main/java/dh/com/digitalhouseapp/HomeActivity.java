package dh.com.digitalhouseapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dh.com.digitalhouseapp.fragments.CommentsFragment;
import dh.com.digitalhouseapp.fragments.PostsFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void changeFragmentOne(View view) {
        replaceFragment(new PostsFragment(), R.id.content_one, "POSTS");
    }

    public void changeFragmentTwo(View view) {
        replaceFragment(new CommentsFragment(), R.id.content_two, "COMMENTS");

    }

    public void replaceFragment(Fragment fragment, int container, String stack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment);
        transaction.addToBackStack(stack);
        transaction.commit();
    }
}
