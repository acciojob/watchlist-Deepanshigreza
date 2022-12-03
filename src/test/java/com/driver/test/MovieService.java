package com.driver.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public static void addMovie(Movie movie){
    MovieRepository.SaveMovie(movie);
    }

    public static void addDirector(Director director){
        MovieRepository.SaveDirector(director);
    }

    public static void addMovieDirectorPair(String movie, String director){
MovieRepository.saveMovieDirectorPair(movie, director);
    }
    public static Movie getMovie(String movie){
        return MovieRepository.findMovie(movie);

    }

    public Director findDirector(String directorName){
        return movieRepository.findDirector(directorName);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }

}
