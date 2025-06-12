package org.lessons.java.wdpt6.best_of_the_year.model;

public class Movie {

    private String title;
    private Integer id;

    public Movie(String title, Integer id) {
        this.title = title;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
