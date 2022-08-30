package com.tr_reny.retrofitnestedjson;

import java.util.List;

public class IBM {
    public String isbn;
    public Author author;
    public mEditor editor;
    public String title;
    public List<String> category = null;

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public mEditor getEditor() {
        return editor;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCategory() {
        return category;
    }
}

