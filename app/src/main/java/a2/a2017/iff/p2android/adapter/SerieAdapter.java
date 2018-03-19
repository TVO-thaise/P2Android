package a2.a2017.iff.p2android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import a2.a2017.iff.p2android.activity.Serie;
import a2.a2017.iff.p2android.R;

public class SerieAdapter  extends RecyclerView.Adapter{
    private List<Serie> series;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public SerieAdapter(List<Serie> series, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.series = series;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_serie, parent, false);
        LivroViewHolder livroViewHolder = new LivroViewHolder(view);
        return livroViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        LivroViewHolder holder = (LivroViewHolder) viewHolder;

        Serie livro  = series.get(position) ;

        holder.nomeLivro.setText(livro.getNome());
        holder.descricao.setText(livro.getDescricao());
        Log.i("------XXXXXXXXX--", livro.getDescricao());


    }

    @Override
    public int getItemCount() {

        return series.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class LivroViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeLivro;
        private final TextView descricao;


        public LivroViewHolder(View itemView) {
            super(itemView);
            nomeLivro = (TextView) itemView.findViewById(R.id.nomeSerie);
            descricao = (TextView) itemView.findViewById(R.id.descricao);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(series.get(getLayoutPosition()));

                }
            });


        }
    }
}
