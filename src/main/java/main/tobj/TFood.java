package main.tobj;

public class TFood {
    private Long id;
    private String name;

    public TFood (String name) {
        this.name = name;
    }

    public TFood () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
