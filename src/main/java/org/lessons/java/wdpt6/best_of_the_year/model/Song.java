package org.lessons.java.wdpt6.best_of_the_year.model;

public class Song {
    private Integer id;
    private String title;

    public Song(String title, Integer id) {
        this.id = id;
        this.title = title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
