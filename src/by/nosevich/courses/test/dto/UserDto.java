package by.nosevich.courses.test.dto;

public class UserDto {
    private Long id;
    private String firstName;
    private String surname;
    private Boolean isActive;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String surname, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
