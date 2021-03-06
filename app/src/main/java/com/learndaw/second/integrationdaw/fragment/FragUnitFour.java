package com.learndaw.second.integrationdaw.fragment;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.learndaw.second.integrationdaw.R;
import com.learndaw.second.integrationdaw.quiz.QuizFourActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragUnitFour.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragUnitFour#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragUnitFour extends Fragment {
    private Button btEvaluationIV;
    private VideoView vView;
    private ImageView ivPlay;
    private Uri vUri;
    private ProgressBar pBar,pbLoad;
    private Boolean isPlaying;
    private int current=0;
    private int duration=0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragUnitFour() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragUnitFour.
     */
    // TODO: Rename and change types and number of parameters
    public static FragUnitFour newInstance(String param1, String param2) {
        FragUnitFour fragment = new FragUnitFour();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_frag_unit_four, container, false);
        btEvaluationIV =(Button)vista.findViewById(R.id.bt_quiz_IV);
        isPlaying=false;

        vView = (VideoView)vista.findViewById(R.id.v_video);
        ivPlay =(ImageView) vista.findViewById(R.id.bt_play) ;
        btEvaluationIV =(Button)vista.findViewById(R.id.bt_quiz_IV);
        pbLoad=(ProgressBar)vista.findViewById(R.id.pb_Load);
        pBar=(ProgressBar)vista.findViewById(R.id.pb_Duration);
        pBar.setMax(1000);
        vUri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/integrationdaw.appspot.com/o/unidad%204.mp4?alt=media&token=ffddfe12-21fc-4352-bfda-86fad2ea91d3");
        vView.setVideoURI(vUri);
        vView.requestFocus();

        vView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {

                if(what ==mp.MEDIA_INFO_BUFFERING_START){
                    pbLoad.setVisibility(View.VISIBLE);
                }
                else if(what==mp.MEDIA_INFO_BUFFERING_END){

                    pbLoad.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });

        vView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                duration=mp.getDuration()/1000;
                // String durationString = String.format("%02d:%02d", duration/60, duration/60);
            }
        });

        vView.start();
        isPlaying=true;
        ivPlay.setImageResource(R.drawable.ic_pause_black_24dp);

        // new videoProgress().execute();

        ivPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(isPlaying){
                    vView.pause();
                    isPlaying=false;
                    ivPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);


                }else{
                    vView.start();
                    isPlaying=true;
                    ivPlay.setImageResource(R.drawable.ic_pause_black_24dp);

                }
            }
        });

        btEvaluationIV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent quiz = new Intent(getActivity(), QuizFourActivity.class);
                startActivity(quiz);

            }
        });
        return vista;
    }
    @Override
    public void onStop() {
        super.onStop();
        isPlaying=false;
    }

    public class videoProgress extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            do{
                if(isPlaying) {
                    current = vView.getCurrentPosition() / 1000;
                    publishProgress(current);
                }

            }
            while (pBar.getProgress() <= 100);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            try{
                int currentPercent= values[0]*100/duration;
                pBar.setProgress(values[0]);
            }
            catch (Exception e){

            }

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
