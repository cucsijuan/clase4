package juan.com.clase4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link relojFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link relojFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class relojFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int gmt = 0;
    private String cityName= "Greenwich";

    private OnFragmentInteractionListener mListener;

    public relojFragment() {
        // Required empty public constructor
    }


    public static relojFragment newInstance(String cityName, int gmt) {
        relojFragment fragment = new relojFragment();
        Bundle args = new Bundle();
        args.putString("CITY_NAME", cityName);
        args.putInt("GMT", gmt);
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
        Bundle params = getArguments();
        View view =  inflater.inflate(R.layout.fragment_reloj, container, false);


        TextView hora = (TextView) view.findViewById(R.id.hora);
        TextView lugar = (TextView) view.findViewById(R.id.lugar);

        lugar.setText(params.getString("CITY_NAME"));
        int gmt = params.getInt("GMT");

        Date ahora= new Date();
        long ahoraUnix = ahora.getTime() + (gmt * 1000 * 3600);
        Date ahoraCorregido = new Date(ahoraUnix);

        SimpleDateFormat df = new SimpleDateFormat("kk:mm");
        String ahoraLindo = df.format(ahoraCorregido);



        return view;
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
