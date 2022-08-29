package com.tr_reny.retrofitnestedjson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
     public Integer total;
     public List<Movie__1> movies = null;

     public Integer getTotal() {
          return total;
     }

     public List<Movie__1> getMovies() {
          return movies;
     }
}
