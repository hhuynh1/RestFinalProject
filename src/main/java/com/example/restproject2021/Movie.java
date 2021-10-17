/**
 *  Name: Henry Huynh
 *  Section: ITEC 4860
 *  Assignment: REST Project
 *  Date: 10/15/2021
 *  Term: Fall 2021
 */

package com.example.restproject2021;
import org.aspectj.weaver.loadtime.Agent;
import org.hibernate.boot.model.source.spi.IdentifierSourceAggregatedComposite;
import javax.persistence.*;

@Entity
@Table(name= "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String genre;
    private Double rate;
    private String description;
    private int rateNum;
    public Movie() {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rate = rate;
        this.description = description;
        this.rateNum = rateNum;
    }

    public Movie(int id, String title, String genre, Double rate, String description, int rateNum) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rate = rate;
        this.description = description;
        this.rateNum = rateNum;
    }

    @Id
    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String content) {
        this.title = content;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "rate")
    public Double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rateNum")
    public int getRateNum() {
        return rateNum;
    }

    public void setRateNum(int rateNum) {
        this.rateNum = rateNum;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rate=" + rate +
                ", description='" + description + '\'' +
                ", rateNum=" + rateNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (rateNum != movie.rateNum) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        if (rate != null ? !rate.equals(movie.rate) : movie.rate != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + rateNum;
        return result;
    }
}
