package christmas.dto;

import static christmas.utils.Constants.SEPARATOR;

public class MenuInputDto {

    private boolean isValid;
    private String[] menus;

    public MenuInputDto() {
        this.isValid = false;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setMenus(String givenMenu) {
        this.menus = givenMenu.split(SEPARATOR);
    }

    public boolean isValid() {
        return isValid;
    }

    public String[] getMenus() {
        return this.menus;
    }
}
