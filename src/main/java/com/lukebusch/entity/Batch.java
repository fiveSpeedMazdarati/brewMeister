package com.lukebusch.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Batch.
 */
@Entity(name="Batch")
@Table(name="batch")
public class Batch {
    @Id @GeneratedValue
    @Column(name="id")
    private int id;
    private String title;
    private String recipe;
    @Column(name="brew_date")
    private LocalDate brewDate;
    @Column(name="bottle_date")
    private LocalDate bottleDate;
    @Column(name="ready_date")
    private LocalDate readyDate;
    @Column(name="expiration_date")
    private LocalDate expirationDate;
    @Column(name="initial_specific_gravity")
    private double initalSpecificGravity;
    @Column(name="final_specific_gravity")
    private double finalSpecificGravity;
    @ManyToOne
    private User user;



    /**
     * Instantiates a new Batch.
     */
    public Batch() {
    }

    /**
     * Instantiates a new Batch.
     *
     * @param id                    the id
     * @param title                 the title
     * @param recipe                the recipe
     * @param brewDate              the brew date
     * @param bottleDate            the bottle date
     * @param readyDate             the ready date
     * @param expirationDate        the expiration date
     * @param initalSpecificGravity the inital specific gravity
     * @param finalSpecificGravity  the final specific gravity
     * @param user                  the user who owns this batch
     */
    public Batch(int id, String title, String recipe, LocalDate brewDate, LocalDate bottleDate, LocalDate readyDate, LocalDate expirationDate, double initalSpecificGravity, double finalSpecificGravity, User user) {
        this.id = id;
        this.title = title;
        this.recipe = recipe;
        this.brewDate = brewDate;
        this.bottleDate = bottleDate;
        this.readyDate = readyDate;
        this.expirationDate = expirationDate;
        this.initalSpecificGravity = initalSpecificGravity;
        this.finalSpecificGravity = finalSpecificGravity;
        this.user = user;
    }

    /**
     * Calculates the approximate alcohol by volume of a batch of beer
     *
     * @return the percent alcohol by volume of this batch expressed as a double e.g. 5.25 = 5.25%
     */
    public double getABV() {


        return ((initalSpecificGravity - finalSpecificGravity) * 131.25) ;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets recipe.
     *
     * @return the recipe
     */
    public String getRecipe() {
        return recipe;
    }

    /**
     * Sets recipe.
     *
     * @param recipe the recipe
     */
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets brew date.
     *
     * @return the brew date
     */
    public LocalDate getBrewDate() {
        return brewDate;
    }

    /**
     * Sets brew date.
     *
     * @param brewDate the brew date
     */
    public void setBrewDate(LocalDate brewDate) {
        this.brewDate = brewDate;
    }

    /**
     * Gets bottle date.
     *
     * @return the bottle date
     */
    public LocalDate getBottleDate() {
        return bottleDate;
    }

    /**
     * Sets bottle date.
     *
     * @param bottleDate the bottle date
     */
    public void setBottleDate(LocalDate bottleDate) {
        this.bottleDate = bottleDate;
    }

    /**
     * Gets ready date.
     *
     * @return the ready date
     */
    public LocalDate getReadyDate() {
        return readyDate;
    }

    /**
     * Sets ready date.
     *
     * @param readyDate the ready date
     */
    public void setReadyDate(LocalDate readyDate) {
        this.readyDate = readyDate;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets expiration date.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets inital specific gravity.
     *
     * @return the inital specific gravity
     */
    public double getInitalSpecificGravity() {
        return initalSpecificGravity;
    }

    /**
     * Sets inital specific gravity.
     *
     * @param initalSpecificGravity the inital specific gravity
     */
    public void setInitalSpecificGravity(double initalSpecificGravity) {
        this.initalSpecificGravity = initalSpecificGravity;
    }

    /**
     * Gets final specific gravity.
     *
     * @return the final specific gravity
     */
    public double getFinalSpecificGravity() {
        return finalSpecificGravity;
    }

    /**
     * Sets final specific gravity.
     *
     * @param finalSpecificGravity the final specific gravity
     */
    public void setFinalSpecificGravity(double finalSpecificGravity) {
        this.finalSpecificGravity = finalSpecificGravity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", recipe='" + recipe + '\'' +
                ", brewDate=" + brewDate +
                ", bottleDate=" + bottleDate +
                ", readyDate=" + readyDate +
                ", expirationDate=" + expirationDate +
                ", initalSpecificGravity=" + initalSpecificGravity +
                ", finalSpecificGravity=" + finalSpecificGravity +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return id == batch.id &&
                Double.compare(batch.initalSpecificGravity, initalSpecificGravity) == 0 &&
                Double.compare(batch.finalSpecificGravity, finalSpecificGravity) == 0 &&
                title.equals(batch.title) &&
                Objects.equals(recipe, batch.recipe) &&
                Objects.equals(brewDate, batch.brewDate) &&
                Objects.equals(bottleDate, batch.bottleDate) &&
                Objects.equals(readyDate, batch.readyDate) &&
                Objects.equals(expirationDate, batch.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, recipe, brewDate, bottleDate, readyDate, expirationDate, initalSpecificGravity, finalSpecificGravity);
    }
}
