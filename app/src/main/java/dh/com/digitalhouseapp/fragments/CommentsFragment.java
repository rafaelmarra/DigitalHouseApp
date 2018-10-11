package dh.com.digitalhouseapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dh.com.digitalhouseapp.R;

public class CommentsFragment extends Fragment {

    public CommentsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        TextView textViewTitle = view.findViewById(R.id.txtTitle);

        String message = getArguments().getString("TEXT");
        textViewTitle.setText(message);

        return view;
    }

}
