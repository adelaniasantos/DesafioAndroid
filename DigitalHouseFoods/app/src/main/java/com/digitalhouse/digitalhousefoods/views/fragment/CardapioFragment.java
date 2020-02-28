package com.digitalhouse.digitalhousefoods.views.fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.digitalhouse.digitalhousefoods.R;
import com.digitalhouse.digitalhousefoods.adapter.CardapioRecyclerViewAdapter;
import com.digitalhouse.digitalhousefoods.interfaces.CardapioListener;
import com.digitalhouse.digitalhousefoods.model.Cardapio;
import com.digitalhouse.digitalhousefoods.model.Restaurante;
import static com.digitalhouse.digitalhousefoods.views.fragment.RestauranteFragment.CHAVE_RESTAURANTE;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardapioFragment extends Fragment implements CardapioListener {
    private RecyclerView recyclerView;
    private CardapioRecyclerViewAdapter adapter;
    private TextView textViewNomeRestaurante;
    private ImageView imageViewImagemRestaurante;

    public CardapioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_cardapio, container, false);

        if (getArguments() != null){

            textViewNomeRestaurante = view.findViewById(R.id.text_view_nome_rest);
            imageViewImagemRestaurante = view.findViewById(R.id.img_restaurante);

            Bundle bundle = getArguments();
            Restaurante restaurante = bundle.getParcelable(CHAVE_RESTAURANTE);

            textViewNomeRestaurante.setText(restaurante.getNomeRestaurante());
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = getResources().getDrawable(restaurante.getImagemRestaurente());
                imageViewImagemRestaurante.setImageDrawable(drawable);
            }
        }

        recyclerView = view.findViewById(R.id.rv_list_cardapio);
        adapter = new CardapioRecyclerViewAdapter(getListaCardapio(), this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;
    }

    @Override
    public void enviaCardapio(Cardapio cardapio) {
        Fragment fragment = new PratosFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE_RESTAURANTE, cardapio);
        fragment.setArguments(bundle);

        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit();
    }

    private List<Cardapio> getListaCardapio() {
        List<Cardapio> cardapios = new ArrayList<>();

        cardapios.add(new Cardapio("Salada com Molho Gengibre",R.drawable.img_pratos));
        cardapios.add(new Cardapio("Frango Grelhado",R.drawable.img_frango));
        cardapios.add(new Cardapio("Omelete com Cogumelos",R.drawable.img_omelete));
        cardapios.add(new Cardapio("Peixe Grelhado",R.drawable.img_peixe));
        cardapios.add(new Cardapio("Salada com Molho Gengibre",R.drawable.img_pratos));
        cardapios.add(new Cardapio("Frango Grelhado",R.drawable.img_frango));
        cardapios.add(new Cardapio("Omelete com Cogumelos",R.drawable.img_omelete));
        cardapios.add(new Cardapio("Peixe Grelhado",R.drawable.img_peixe));

        return cardapios;
    }

}
