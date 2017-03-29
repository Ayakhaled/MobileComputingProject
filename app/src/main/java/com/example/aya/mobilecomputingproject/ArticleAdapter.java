package com.example.aya.mobilecomputingproject;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aya on 14/03/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticlesViewHolder> {
    private Context context;
    private ArrayList<Article> articles;

    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);

        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {
        holder.article_title.setText(articles.get(position).getTitle());
        holder.article_abstract.setText(articles.get(position).getArticle_abstract());
    }

    @Override
    public int getItemCount() {
        return (articles == null) ? 0 : articles.size();
    } // get the list ize

    public static class ArticlesViewHolder extends RecyclerView.ViewHolder{
//        ImageView article_image;
        TextView article_title;
        TextView article_abstract;

        public ArticlesViewHolder(View itemView) {
            super(itemView);
//            article_image = (ImageView) itemView.findViewById(R.id.article_image);
            article_title = (TextView) itemView.findViewById(R.id.article_title);
            article_abstract = (TextView) itemView.findViewById(R.id.article_abstract);
        }
    }
}
