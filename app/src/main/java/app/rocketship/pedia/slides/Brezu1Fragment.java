package app.rocketship.pedia.slides;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.rocketship.pedia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Brezu1Fragment extends Fragment {


    public Brezu1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_brezu1, container, false);

//        GifView gif1 = (GifView) v.findViewById(R.id.brezu_bar1);
//        gif1.setImageResource(R.drawable.bar1);

        return v;
    }

}
