package com.example.Clicker;




import jakarta.persistence.*;



@Entity

public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="TITLE")
    private String title;

    @Column(name="COUNT")
    private Integer count;

    @Column(name="NOTES")
    private String notes;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String  notes) {
        this.notes = notes;
    }
}