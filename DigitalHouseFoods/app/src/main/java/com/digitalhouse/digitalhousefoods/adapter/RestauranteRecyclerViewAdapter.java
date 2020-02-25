package com.digitalhouse.digitalhousefoods.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalhouse.digitalhousefoods.R;
import com.digitalhouse.digitalhousefoods.interfaces.RestauranteListener;
import com.digitalhouse.digitalhousefoods.model.Restaurante;
import java.util.List;

public class RestauranteRecyclerViewAdapter extends RecyclerView.Adapter<RestauranteRecyclerViewAdapter.ViewHolder>{

    private List<Restaurante> restaurantes;
    private RestauranteListener listener;

    public RestauranteRecyclerViewAdapter(List<Restaurante> restaurantes, RestauranteListener listener) {
        this.restaurantes = restaurantes;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.itens_restaurantes_recycler_view, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Restaurante restaurante = restaurantes.get(position);
        holder.onBind(restaurante);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // listener.enviaRestaurante(restaurante);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeRestaurante;
        private TextView enderecoRestaurante;
        private TextView horarioRestauranet;
        private ImageView imagemRestaurante;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeRestaurante = itemView.findViewById(R.id.text_view_nome);
            enderecoRestaurante = itemView.findViewById(R.id.textEndereco);
            horarioRestauranet = itemView.findViewById(R.id.textHorario);
            imagemRestaurante = itemView.findViewById(R.id.image_view_restaurante);

        }

        public void onBind(Restaurante restaurante) {
            nomeRestaurante.setText(restaurante.getNomeRestaurante());
            enderecoRestaurante.setText(restaurante.getEnderecoRestaurante());
            horarioRestauranet.setText(restaurante.getHorarioRestaurante());

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = itemView.getResources().getDrawable(restaurante.getImagemRestaurente());
                imagemRestaurante.setImageDrawable(drawable);
            }


        }
    }
}

