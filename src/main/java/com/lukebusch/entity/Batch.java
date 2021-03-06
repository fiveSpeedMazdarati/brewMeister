package com.lukebusch.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Batch.
 */
@Entity(name="Batch")
@Table(name="batch")
public class Batch {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
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
    private double initialSpecificGravity;
    @Column(name="final_specific_gravity")
    private double finalSpecificGravity;
    private String notes;
    @ManyToOne
    private User user;
    @ManyToOne
    private Style style;

    /**
     * Instantiates a new Batch.
     */
    public Batch() {
    }

    /**
     * Instantiates a new Batch.
     *
     * @param title                  the title
     * @param recipe                 the recipe
     * @param brewDate               the brew date
     * @param bottleDate             the bottle date
     * @param readyDate              the ready date
     * @param expirationDate         the expiration date
     * @param initialSpecificGravity the initial specific gravity
     * @param finalSpecificGravity   the final specific gravity
     */
    public Batch(String title, String recipe, LocalDate brewDate, LocalDate bottleDate, LocalDate readyDate, LocalDate expirationDate, double initialSpecificGravity, double finalSpecificGravity) {

        this.title = title;
        this.recipe = recipe;
        this.brewDate = brewDate;
        this.bottleDate = bottleDate;
        this.readyDate = readyDate;
        this.expirationDate = expirationDate;
        this.initialSpecificGravity = initialSpecificGravity;
        this.finalSpecificGravity = finalSpecificGravity;
    }

    /**
     * Calculates the approximate alcohol by volume of a batch of beer
     *
     * @return the percent alcohol by volume of this batch expressed as a double e.g. 5.25 = 5.25%
     */
    public double getABV() {
        // make sure both specific gravity values are present, otherwise do not try to compute the value
        if (initialSpecificGravity != 0 && finalSpecificGravity != 0) {

            Double formattedDouble = 0.0;
            DecimalFormat formatter = new DecimalFormat("#.##");
            formattedDouble = Double.valueOf(formatter.format(((initialSpecificGravity - finalSpecificGravity) * 131.25)));
            return formattedDouble;
        }

        else return 0.0;
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
    public double getInitialSpecificGravity() {
        return initialSpecificGravity;
    }

    /**
     * Sets inital specific gravity.
     *
     * @param initialSpecificGravity the inital specific gravity
     */
    public void setInitialSpecificGravity(double initialSpecificGravity) {
        this.initialSpecificGravity = initialSpecificGravity;
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

    /**
     * Gets the notes for this batch
     *
     * @return the note made for this batch
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes for this batch. This method will not append notes to existing!
     *
     * @param notes the notes for this batch
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets style
     *
     * @return the style associated with this beer
     */
    public Style getStyle() {
        return this.style;
    }

    /**
     * Sets the style of this batch
     *
     * @param style the new beer style for this batch
     */
    public void setStyle(Style style) {
        this.style = style;
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
                ", initalSpecificGravity=" + initialSpecificGravity +
                ", finalSpecificGravity=" + finalSpecificGravity +
                ", notes=" + notes +
                ", user=" + user +
                ", style=" + style +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return id == batch.id &&
                Double.compare(batch.initialSpecificGravity, initialSpecificGravity) == 0 &&
                Double.compare(batch.finalSpecificGravity, finalSpecificGravity) == 0 &&
                Objects.equals(title, batch.title) &&
                Objects.equals(recipe, batch.recipe) &&
                Objects.equals(brewDate, batch.brewDate) &&
                Objects.equals(bottleDate, batch.bottleDate) &&
                Objects.equals(readyDate, batch.readyDate) &&
                Objects.equals(expirationDate, batch.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, recipe, brewDate, bottleDate, readyDate, expirationDate, initialSpecificGravity, finalSpecificGravity);
    }
}
