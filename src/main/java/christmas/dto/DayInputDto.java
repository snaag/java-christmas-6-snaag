package christmas.dto;

public class DayInputDto {
    private boolean isValid;
    private String day;

    public DayInputDto() {
        this.isValid = false;
        this.day = "";
    }

    public boolean isValid() {
        return isValid;
    }

    public String getDay() {
        return day;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
