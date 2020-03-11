package com.digitalhouse.digitalhousefoods.views.fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.digitalhouse.digitalhousefoods.R;
import com.digitalhouse.digitalhousefoods.model.Cardapio;
import static com.digitalhouse.digitalhousefoods.views.fragment.RestauranteFragment.CHAVE_RESTAURANTE;

/**
 * A simple {@link Fragment} subclass.
 */
public class PratosFragment extends Fragment {
    private TextView textViewNomePrato;
    private ImageView imageViewImagemPrato;


    public PratosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pratos, container, false);

        if (getArguments() != null){

            textViewNomePrato = view.findViewById(R.id.tview_desc_prato);
            imageViewImagemPrato = view.findViewById(R.id.image_prato);

            Bundle bundle = getArguments();
            Cardapio cardapio = bundle.getParcelable(CHAVE_RESTAURANTE);

            textViewNomePrato.setText(cardapio.getNomePrato());
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = getResources().getDrawable(cardapio.getImagemPrato());
                imageViewImagemPrato.setImageDrawable(drawable);
            }
        }

        return view;
    }

}
