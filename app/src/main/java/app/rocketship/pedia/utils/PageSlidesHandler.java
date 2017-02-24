package app.rocketship.pedia.utils;



import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.StringTokenizer;

import app.rocketship.pedia.R;
import app.rocketship.pedia.slides.Brezu1Fragment;
import app.rocketship.pedia.slides.Brezu2Fragment;
import app.rocketship.pedia.slides.Brezu3Fragment;
import app.rocketship.pedia.slides.Brezu4Fragment;
import app.rocketship.pedia.slides.Clarithro1Fragment;
import app.rocketship.pedia.slides.Clarithro2Fragment;
import app.rocketship.pedia.slides.Clarithro3Fragment;
import app.rocketship.pedia.slides.Clarithro4Fragment;
import app.rocketship.pedia.slides.Clarithro5Fragment;
import app.rocketship.pedia.slides.Clarithro6Fragment;
import app.rocketship.pedia.slides.Clarithro7Fragment;
import app.rocketship.pedia.slides.Hera1Fragment;
import app.rocketship.pedia.slides.Hera2Fragment;
import app.rocketship.pedia.slides.Hera3Fragment;
import app.rocketship.pedia.slides.Hera4Fragment;
import app.rocketship.pedia.slides.Hera5Fragment;
import app.rocketship.pedia.slides.Hera6Fragment;
import app.rocketship.pedia.slides.Hera7Fragment;
import app.rocketship.pedia.slides.HeraOne1Fragment;
import app.rocketship.pedia.slides.HeraOne2Fragment;
import app.rocketship.pedia.slides.HeraOne3Fragment;
import app.rocketship.pedia.slides.HeraOne4Fragment;
import app.rocketship.pedia.slides.KidzKit1Fragment;
import app.rocketship.pedia.slides.KidzKit2Fragment;
import app.rocketship.pedia.slides.Montemax1Fragment;
import app.rocketship.pedia.slides.Montemax2Fragment;
import app.rocketship.pedia.slides.Montemax3Fragment;
import app.rocketship.pedia.slides.Montemax4Fragment;
import app.rocketship.pedia.slides.Natravox1Fragment;
import app.rocketship.pedia.slides.Natravox2Fragment;
import app.rocketship.pedia.slides.Natravox3Fragment;
import app.rocketship.pedia.slides.Natravox4Fragment;
import app.rocketship.pedia.slides.Natravox5Fragment;
import app.rocketship.pedia.slides.Natravox6Fragment;
import app.rocketship.pedia.slides.Natravox7Fragment;
import app.rocketship.pedia.slides.Natravox8Fragment;
import app.rocketship.pedia.slides.Natravox9Fragment;

/**
 * Created by Candice on 12/02/2017.
 */

public class PageSlidesHandler {
    public enum Page{
        BREZU("brezu", R.string.brezu),
        BREZU_VIDEO("brezu_video", R.string.brezu_video),
        CLARITHROMYCIN("clarithromycin", R.string.clarithromycin),
        DIBENCOZIDE_HERACLENE("dibencozide_heraclene", R.string.dibher),
        DIBENCOZIDE_HERACLENE_1MG("dibencozide_heraclene_1mg", R.string.dibher1mg),
        KIDZ_KIT("kidz_kit", R.string.kidzkit),
        MONTEMAX("montemax", R.string.montemax),
        NATRAVOX("natravox", R.string.natravox),
        CORPORATE_VIDEO("video_pedia", R.string.corpvideo);

        private String key;
        private int labelId;
        Page(String key, int labelId){
            this.key = key;
            this.labelId = labelId;
        }

        public String getKey(){
            return key;
        }
        public int getLabelId() {
            return labelId;
        }
    }

    public static ArrayList<Fragment> getPageSlidesFragment(Page page){

        ArrayList<Fragment> fragments = new ArrayList<>();

        switch (page){
            case BREZU:



                fragments.add(new Brezu1Fragment());
                fragments.add(new Brezu2Fragment());
                fragments.add(new Brezu3Fragment());
                fragments.add(new Brezu4Fragment());

                break;
            case CLARITHROMYCIN:
//
                fragments.add(new Clarithro1Fragment());
                fragments.add(new Clarithro2Fragment());
                fragments.add(new Clarithro3Fragment());
                fragments.add(new Clarithro4Fragment());
                fragments.add(new Clarithro5Fragment());
                fragments.add(new Clarithro6Fragment());
                fragments.add(new Clarithro7Fragment());

                break;
            case DIBENCOZIDE_HERACLENE:

                fragments.add(new Hera1Fragment());
                fragments.add(new Hera2Fragment());
                fragments.add(new Hera3Fragment());
                fragments.add(new Hera4Fragment());
                fragments.add(new Hera5Fragment());
                fragments.add(new Hera6Fragment());
                fragments.add(new Hera7Fragment());

                break;

            case DIBENCOZIDE_HERACLENE_1MG:

                fragments.add(new HeraOne1Fragment());
                fragments.add(new HeraOne2Fragment());
                fragments.add(new HeraOne3Fragment());
                fragments.add(new HeraOne4Fragment());

                break;
            case KIDZ_KIT:

                fragments.add(new KidzKit1Fragment());
                fragments.add(new KidzKit2Fragment());

                break;
            case MONTEMAX:

                fragments.add(new Montemax1Fragment());
                fragments.add(new Montemax2Fragment());
                fragments.add(new Montemax3Fragment());
                fragments.add(new Montemax4Fragment());

                break;
            case NATRAVOX:

                fragments.add(new Natravox1Fragment());
                fragments.add(new Natravox2Fragment());
                fragments.add(new Natravox3Fragment());
                fragments.add(new Natravox4Fragment());
                fragments.add(new Natravox5Fragment());
                fragments.add(new Natravox6Fragment());
                fragments.add(new Natravox7Fragment());
                fragments.add(new Natravox8Fragment());
                fragments.add(new Natravox9Fragment());

                break;
        }

        return fragments;
    }
}
