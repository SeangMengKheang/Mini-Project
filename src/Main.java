import interfaces.Output;
import database.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static javax.swing.UIManager.get;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Output output = new Output();
        short TableRows = 2;
        short CurrentPage = 1;

        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product((short) 1, "Anchor", 2500d, (short) 20, LocalDate.now()));
        list.add(new Product((short) 2, "Tiger", 3000d, (short) 20, LocalDate.now()));
        list.add(new Product((short) 3, "Hanuman", 3000d, (short) 20, LocalDate.now()));
        list.add(new Product((short) 4, "Hoegarden", 5000d, (short) 20, LocalDate.now()));

        // CSTAD Logo
        output.cstadLogo();

        while (true) {
            output.menu();
            System.out.print("Command --> ");
            String str = sc.nextLine();

            switch(str) {
                case "*": {
                    int startIndex = (CurrentPage - 1) * TableRows;
                    int endIndex = Math.min(startIndex + TableRows, list.size());

                    output.displayHeader();
                    output.displayContent();
                    output.displayBody();

                    /*for (Product p : list) {
                        CurrentLoop++;
                        if (CurrentLoop > TableRows) break;
                        else output.displayData(p, TableRows, CurrentLoop);
                    }

                     */
                    for (int i = startIndex; i < endIndex; i++) {
                        Product p = list.get(i);
                        output.displayData(p, TableRows, (short) i);
                    }

                    output.displayFooter();
                    output.displayTable( TableRows, (short) list.size(), CurrentPage, (short) 109);
                    break;
                }
                case "w": {
                    System.out.println("Product ID : "+  (list.size() + 1));
                    String pd_Name = output.InputValue("Product Name : ");
                    String pd_Price = output.InputValue("Product Price : ");
                    String pd_Qty = output.InputValue("Product Qty : ");

                    //output.displayCRUD(p);
                    if (output.InputValue("Are you sure want to add this record? [Y/y] or [N/n] : ").toLowerCase().equals("y")) {
                        list.add(new Product(Short.parseShort(String.valueOf(list.size() + 1)), pd_Name, Double.parseDouble(pd_Price), Short.parseShort(pd_Qty), LocalDate.now()));
                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                "11", "was added", "successfully");
                    }
                    break;
                }
                case "r": {
                    boolean isFound = false;
                    String pd_ID = output.InputValue("Read by ID : ");
                    for (Product p : list) {
                        if (p.getID() == Short.parseShort(pd_ID)) {
                            output.displayCRUD(p);
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 18,
                                pd_ID, "is not", "found!");
                    }
                    else {
                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                pd_ID, "was added", "successfully");
                    }
                    break;
                }
                case "u": {
                    boolean isFound = false;
                    String pd_ID = output.InputValue("Please Input ID of Product: ");
                    for (Product p : list) {
                        if (p.getID() == Short.parseShort(pd_ID)) {
                            System.out.println("What do you want to update?");
                            output.updateMenu();
                            String option = output.InputValue("\nOption (1-5) : ");

                            switch (Short.parseShort(option)) {
                                case 1: {
                                    String pd_Name = output.InputValue("Product Name : ");
                                    String pd_Price = output.InputValue("Product Price : ");
                                    String pd_Qty = output.InputValue("Product Qty : ");

                                    if (output.InputValue("Are you sure want to add this record? [Y/y] or [N/n] : ").toLowerCase().equals("y")) {
                                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                                "Product", "was", "updated");
                                        p.setName(pd_Name);
                                        p.setUnitPrice(Short.parseShort(pd_Price));
                                        p.setQty(Short.parseShort(pd_Qty));
                                    }
                                }
                                case 2: {
                                    String pd_Name = output.InputValue("Product's Name : ");
                                    if (output.InputValue("Are you sure want to add this record? [Y/y] or [N/n] : ").toLowerCase().equals("y")) {
                                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                                "Product", "was", "updated");
                                        p.setName(pd_Name);
                                    }
                                }
                                case 3: {
                                    String pd_Qty = output.InputValue("Product's Qty : ");
                                    if (output.InputValue("Are you sure want to add this record? [Y/y] or [N/n] : ").toLowerCase().equals("y")) {
                                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                                "Product", "was", "updated");
                                        p.setQty(Short.parseShort(pd_Qty));
                                    }
                                }
                                case 4: {
                                    String pd_UnitPrice = output.InputValue("Product's UnitPrice : ");
                                    if (output.InputValue("Are you sure want to add this record? [Y/y] or [N/n] : ").toLowerCase().equals("y")) {
                                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                                "Product", "was", "updated");
                                        p.setUnitPrice(Short.parseShort(pd_UnitPrice));
                                    }
                                }
                                case 5: break;
                                default:
                                    System.out.println("INPUT IS INVALID");
                            }
                        }
                    }
                    if (!isFound) {
                        output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 18,
                                pd_ID, "is not", "found!");
                    }
                    break;
                }
                case "d": {
                    String pd_ID = output.InputValue("Please Input ID of Product: ");
                    Iterator<Product> iterator = list.iterator();
                    while (((Iterator<?>) iterator).hasNext()) {
                        Product p = iterator.next();
                        if (p.getID() == Short.parseShort(pd_ID)) {
                            output.displayCRUD(p);
                            if (output.InputValue("Are you sure want to add this record? [Y/y] or [N/n] : ").toLowerCase().equals("y")) {
                                output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                        "Product", "was successfully", "deleted");
                                iterator.remove();
                            }
                        }
                    }
                }
                case "f": {
                    if (CurrentPage == 1) break;
                    else CurrentPage = 1;
                    break;
                }
                case "p": {
                    if (CurrentPage == 1) break;
                    else CurrentPage -= 1;
                }
                case "n": {
                    if (CurrentPage > (short) Math.ceil(list.size() / TableRows)) break;
                    else CurrentPage += 1;
                }
                case "l": {
                    if (CurrentPage == (short) Math.ceil(list.size() / TableRows)) break;
                    else CurrentPage = (short) Math.ceil(list.size() / TableRows);
                    break;
                }
                case "s": {
                    String pd_Name = output.InputValue("Search by Name: ");
                    for (Product p : list) {
                        if (p.getName().equals(pd_Name)) {
                            output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 27,
                                    "Product", "found for [".trim(), pd_Name.concat("]"));
                            output.displayCRUD(p);
                        }
                    }
                }
                case "g": {
                    String Pages = output.InputValue("Go to page: ");
                    CurrentPage = Short.parseShort(Pages);
                }
                case "se": {
                    System.out.printf("Please enter Row for Display : ");
                    TableRows = Short.parseShort(sc.nextLine());
                    output.displayTable(TableRows, (short) list.size(), CurrentPage, (short) 25,
                            "Set row to ", String.valueOf(TableRows), " successfully");
                    break;
                }
                case "h": output.help();
                case "e": return;
                default:
                    System.out.println("INPUT IS INVALID");
            }
        }
    }
}
