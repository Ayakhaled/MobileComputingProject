package com.example.aya.mobilecomputingproject;

import java.io.Serializable;

/**
 * Created by aya on 14/03/17.
 */

public class Article implements Serializable {

    private String image_url;
    private String title;
    private String article_abstract;

    public Article(String title, String article_abstract) {
        this.title = title;
        this.article_abstract = article_abstract;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle_abstract() {
        return article_abstract;
    }

    public void setArticle_abstract(String article_abstract) {
        this.article_abstract = article_abstract;
    }
}
