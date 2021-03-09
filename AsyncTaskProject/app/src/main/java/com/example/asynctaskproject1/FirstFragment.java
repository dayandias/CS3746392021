package com.example.asynctaskproject1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    Button btn1;
    Button btn2;
    ImageView iv;
    TextView tv;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn1 = view.findViewById(R.id.button_first);
        btn2 = view.findViewById(R.id.button_second);
         iv = view.findViewById(R.id.imageView);
         tv = view.findViewById(R.id.textView);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getString(R.string.img_url);

                ImageDownloader id = new ImageDownloader(getActivity());
                id.execute(url);
                tv.setText("Colombo, Sri Lanka");

            }
        });

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImageBitmap(null);
                tv.setText(null);
            }
        });
    }
}