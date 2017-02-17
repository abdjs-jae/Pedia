package app.rocketship.pedia.pedia.slides;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.rocketship.pedia.pedia.R;
import app.rocketship.pedia.pedia.utils.GifView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Brezu3Fragment extends Fragment {


    public Brezu3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_brezu3, container, false);

        GifView gif1 = (GifView) v.findViewById(R.id.brezu_bar2);
        gif1.setImageResource(R.drawable.bar2);

        return v;
    }

}
