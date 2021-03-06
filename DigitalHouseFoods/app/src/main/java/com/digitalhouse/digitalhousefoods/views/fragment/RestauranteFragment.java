package com.digitalhouse.digitalhousefoods.views.fragment;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.digitalhouse.digitalhousefoods.R;
import com.digitalhouse.digitalhousefoods.adapter.RestauranteRecyclerViewAdapter;
import com.digitalhouse.digitalhousefoods.interfaces.RestauranteListener;
import com.digitalhouse.digitalhousefoods.model.Restaurante;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestauranteFragment extends Fragment implements RestauranteListener {
    private RecyclerView recyclerView;
    private RestauranteRecyclerViewAdapter adapter;
    public static final String CHAVE_RESTAURANTE = "restaurante";

    public RestauranteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante, container, false);

        recyclerView = view.findViewById(R.id.rv_list_restaurante);
        adapter = new RestauranteRecyclerViewAdapter(getListaRestaurantes(), this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        return view;
    }

    @Override
    public void enviaRestaurante(Restaurante restaurante) {
        Fragment fragment = new CardapioFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE_RESTAURANTE, restaurante);
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

    private List<Restaurante> getListaRestaurantes() {
       List<Restaurante> restaurantes = new ArrayList<>();

        restaurantes.add(new Restaurante("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo","Fecha às 22:00",R.drawable.img_tony));
        restaurantes.add(new Restaurante("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00",R.drawable.img_ayoama));
        restaurantes.add(new Restaurante("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo","Fecha às 00:00",R.drawable.img_outback));
        restaurantes.add(new Restaurante("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00",R.drawable.img_sisenor));

        return restaurantes;
    }
}
