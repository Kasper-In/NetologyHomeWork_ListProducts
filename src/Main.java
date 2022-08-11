import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void mainMenu(){
        System.out.println("Выберите номер пункта меню или введите end:");
        System.out.println("1. Добавить продкут в список");
        System.out.println("2. Показать список продуктов");
        System.out.println("3. Удалить продукт из списка");
        //System.out.println("4. Поиск по наименованию");
    }

    public static void showListProduct(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
    }

    public static void main(String[] args) {

        List<String> listProducts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            mainMenu();
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                int numberMenu;
                try {
                    numberMenu = Integer.parseInt(input);
                } catch (NumberFormatException exception){
                    System.out.println("Вы ввели не число. Попробуйте еще раз");
                    System.out.println();
                    continue;
                }
                switch (numberMenu) {
                    case 1:
                        System.out.println("Введите названия продукта, который хотите добавить: ");
                        String newProduct = sc.nextLine();
                        listProducts.add(newProduct);
                        System.out.println("Продукт добавлен с список. Итого продуктов в с списке: " + listProducts.size());
                        System.out.println();
                        break;
                    case 2:
                        if (listProducts.isEmpty()){
                            System.out.println("Список продуктов пока пуст");
                        } else {
                            System.out.println("Список продуктов:");
                            showListProduct(listProducts);
                        }
                        System.out.println();
                        break;
                    case 3:
                        if (listProducts.isEmpty()){
                            System.out.println("Список продуктов пока пуст");
                        } else {
                            System.out.println("Какой продукт хотите удалить? Введите номер продукта или его название: ");
                            showListProduct(listProducts);
                            String inputDelete = sc.nextLine();
                            int numberDeleteProduct;
                            try {
                                numberDeleteProduct = Integer.parseInt(inputDelete);
                                if (numberDeleteProduct > 0 && numberDeleteProduct <= listProducts.size()) {
                                    System.out.println("Продукт " + listProducts.get(numberDeleteProduct-1) + " удален. Список продуктов: ");
                                    listProducts.remove(numberDeleteProduct-1);
                                    showListProduct(listProducts);
                                } else {
                                    System.out.println("Продукта с таким номером нет в списке. Попробуйте еще раз");
                                }
                            } catch (NumberFormatException exception) {
                                if (listProducts.remove(inputDelete)) {
                                    System.out.println("Продукт " + inputDelete + " удален. Список продуктов: ");
                                    showListProduct(listProducts);
                                } else {
                                    System.out.println("Продукт не найдет. Попробуйте еще раз");
                                }
                            }
                        }
                        System.out.println();
                        break;
                    default:
                        System.out.println("Я не знаю такой команды. Попробуй еще раз");
                        System.out.println();

                }

            }
        }

    }
}
