package com.driver.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;

@Component
@Repository
public class MovieRepository {

    private static HashMap<String,Movie> movieMap;
    private static HashMap<String , Director> directorMap;
    private static HashMap<String, List<String>> directorMovieMap;

    public MovieRepository(){
        this.movieMap=new HashMap<>();
        this.directorMap=new HashMap<String , Director>();
        this.directorMovieMap=new HashMap<>();
    }

    public static void SaveMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }

    public static void SaveDirector(Director director){
        directorMap.put(director.getName(), director);
    }
    public static void saveMovieDirectorPair(String movie, String Director){

        if(directorMap.containsKey(Director) && movieMap.containsKey(movie)){
            List<String> currentMovies=new ArrayList<>();
            if(directorMovieMap.containsKey(Director)){
                currentMovies=directorMovieMap.get(Director);
                currentMovies.add(movie);
                directorMovieMap.put(Director,currentMovies);
            }

        }


    }
    public static Movie findMovie(String movie){
        return  movieMap.get(movie);
    }
    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieMap.containsKey(director)) moviesList = directorMovieMap.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(directorMovieMap.containsKey(director)){
            movies = directorMovieMap.get(director);
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            directorMovieMap.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector() {
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for (String director : directorMovieMap.keySet()) {
            for (String movie : directorMovieMap.get(director)) {
                moviesSet.add(movie);
            }
        }
//done
        for (String movie : moviesSet) {
            if (movieMap.containsKey(movie)) {
                movieMap.remove(movie);
            }
        }


    }
    }
