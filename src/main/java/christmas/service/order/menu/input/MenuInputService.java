package christmas.service.order.menu.input;

import christmas.dto.MenuInputDto;
import christmas.utils.menu.MenuValidations;
import christmas.view.InputView;

import static christmas.utils.Constants.SEPARATOR;

public class MenuInputService {

    private final MenuInputDto menuInputDto;

    public MenuInputService() {
        this.menuInputDto = new MenuInputDto();
    }

    public String[] getInputMenus() {
        while(!menuInputDto.isValid()) {
            this.checkValidOrError();
        }

        return menuInputDto.getMenus();
    }

    public void checkValidOrError() {
        try {
            String menu = InputView.readMenus();
            this.validateMenu(menu);
            menuInputDto.setValid(true);
            menuInputDto.setMenus(menu);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validateMenu(String givenMenu) {
        int MENU_UNDER_COUNT = 0;

        MenuValidations.checkMenuSyntax(givenMenu);

        String[] menus = givenMenu.split(SEPARATOR);
        MenuValidations.checkMenuDuplicate(menus);

        for(String menu: menus) {
            MenuValidations.checkExistMenu(menu);
            MenuValidations.checkMenuMoreThan(menu, MENU_UNDER_COUNT);
        }
    }

}
