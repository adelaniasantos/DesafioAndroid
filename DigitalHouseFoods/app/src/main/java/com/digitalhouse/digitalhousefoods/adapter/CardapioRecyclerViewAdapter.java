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
import com.digitalhouse.digitalhousefoods.interfaces.CardapioListener;
import com.digitalhouse.digitalhousefoods.model.Cardapio;
import java.util.List;

public class CardapioRecyclerViewAdapter extends RecyclerView.Adapter<CardapioRecyclerViewAdapter.ViewHolder>{

    private List<Cardapio> cardapios;
    private CardapioListener listener;

    public CardapioRecyclerViewAdapter(List<Cardapio> cardapios, CardapioListener listener) {
        this.cardapios = cardapios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.itens_cardapio_recycler_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Cardapio cardapio = cardapios.get(position);
        holder.onBind(cardapio);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.enviaCardapio(cardapio);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardapios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomePrato;
        private ImageView imagemPrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomePrato = itemView.findViewById(R.id.tv_nome_prato);
            imagemPrato = itemView.findViewById(R.id.image_view_prato);

        }

        public void onBind(Cardapio cardapio) {
            nomePrato.setText(cardapio.getNomePrato());

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = itemView.getResources().getDrawable(cardapio.getImagemPrato());
                imagemPrato.setImageDrawable(drawable);
            }
        }
    }
}
