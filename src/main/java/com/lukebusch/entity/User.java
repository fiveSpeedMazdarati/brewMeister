package com.lukebusch.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type User.
 */
@Entity(name="User")
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="id")
    private int id;
    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;  // this may or may not contain a value. For now I need it to facilitate testing.
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="zip_code")
    private String zipCode;
    @Column(name="birthdate")
    private LocalDate birthDate;
    @Column(name="role")
    private int roleId;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Batch> batches = new HashSet<>();
    /**
     * Instantiates a new User.
     */
    public User() {
    }
    /**
     * Instantiates a new User
     *
     * @param userName  the user name
     * @param firstName the first name
     * @param lastName  the last name
     * @param zipCode   the zip code
     * @param birthDate the birth date
     */
    public User(String userName, String password, String firstName, String lastName, String zipCode, LocalDate birthDate) {

        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.birthDate = birthDate;
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
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * Gets batches.
     *
     * @return the batches
     */
    public Set<Batch> getBatches() {
        return batches;
    }

    /**
     * Add batch.
     *
     * @param batch the batch
     */
    public void addBatch(Batch batch) {
        batches.add(batch);
        batch.setUser(this);
    }

    /**
     * Remove batch.
     *
     * @param batch the batch
     */
    public void removeBatch(Batch batch) {
        batches.remove(batch);
        batch.setUser(null);
    }

    /**
     * Sets batches.
     *
     * @param batches the batches
     */
    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(zipCode, user.zipCode) &&
                Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, firstName, lastName, zipCode, birthDate);
    }
}
