package interfaces;

import database.Product;

import java.time.LocalDate;
import java.util.Scanner;

public class Output {

    // Done - cstadLogo
    public void cstadLogo() {
        System.out.println(
                " ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     \n" +
                        "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    \n" +
                        "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    \n" +
                        "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    \n" +
                        "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    \n" +
                        " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝ "
                          );
        System.out.println("STOCK MANAGEMENT SYSTEM");
    }

    // 1 - (Menu)
    // 1. Header
    public void header(short length) {
        System.out.print("╔");
        System.out.print("═".repeat(length));
        System.out.print("╗\n");
    }

    // 2. Body
    public void body() {
        // Row #1
        System.out.format("%s%15s%11s%12s%14s%12s%11s%15s%8s%8s%6s",
                "║", "*) Display", "| W)rite", "| R)ead", "| U)pdate", "| D)elete",
                "| F)irst", "| P)revious", "| N)ext", "| L)ast", "║");

        // Row #2
        System.out.format("\n%s%12s%13s%16s%9s%12s%50s\n",
                "║", "S)earch", "| G)oto", "| Se)t row",
                "| H)elp", "| E)xit", "║");
    }

    // 3. Footer
    public void footer(short length) {
        System.out.print("╚");
        System.out.print("═".repeat(length));
        System.out.print("╝\n");
    }

    // 4. Display Menu
    public void menu() {
        header((short) 111);
        body();
        footer((short) 111);
    }

    // 2 - (Help)
    public void help() {
        System.out.print("+");
        System.out.print("-".repeat(78));
        System.out.print("+\n");

        System.out.format("%s%3s%8s%s%30s", "!","1.", "Press",
                "     * : Display all record of products", "!\n");
        System.out.format("%s%3s%8s%s%45s", "!","2.", "Press",
                "     w : Add new product", "!\n");
        System.out.format("%s%11s%s%7s", "!", "Press",
                "     w ->#proname-unitprice-qty : shortcut for add new product", "!\n");
        System.out.format("%s%3s%8s%s%36s", "!","3.", "Press",
                "     r : read Content any content", "!\n");
        System.out.format("%s%11s%s%23s", "!", "Press",
                "     r#proID : shortcut for read product by ID", "!\n");
        System.out.format("%s%3s%8s%s%49s", "!","4.", "Press",
                "     u : Update Data", "!\n");
        System.out.format("%s%3s%8s%s%49s", "!","5.", "Press",
                "     d : Delete Data", "!\n");
        System.out.format("%s%11s%s%21s", "!", "Press",
                "     d#proID : shortcut for delete product by ID", "!\n");
        System.out.format("%s%3s%8s%s%42s", "!","6.", "Press",
                "     f : Display First Page", "!\n");
        System.out.format("%s%3s%8s%s%39s", "!","7.", "Press",
                "     p : Display Previous Page", "!\n");
        System.out.format("%s%3s%8s%s%43s", "!","8.", "Press",
                "     n : Display Next Page", "!\n");
        System.out.format("%s%3s%8s%s%43s", "!","9.", "Press",
                "     l : Display Last Page", "!\n");
        System.out.format("%s%4s%7s%s%38s", "!","10.", "Press",
                "     s : Search product by name", "!\n");
        System.out.format("%s%4s%7s%s%56s", "!","11.", "Press",
                "     h : Help", "!\n");

        System.out.print("+");
        System.out.print("-".repeat(78));
        System.out.print("+\n");
    }
    // 3 - (Display Data)
    // 3.1. Draw Header
    public void displayHeader() {
        System.out.print("\n╔");
        System.out.print("═".repeat(19));
        System.out.print("╦");
        System.out.print("═".repeat(21));
        System.out.print("╦");
        System.out.print("═".repeat(22));
        System.out.print("╦");
        System.out.print("═".repeat(19));
        System.out.print("╦");
        System.out.print("═".repeat(25));
        System.out.print("╗");
    }

    public void displayContent() {
        System.out.format("\n%s%10s%10s%12s%10s%15s%8s%10s%10s%18s%8s", "║", "ID", "|", "Name", "|",
                "UnitPrice", "|", "Qty", "|", "ImportDate", "║");
    }
    // 3.2 Body
    public void displayBody() {
        System.out.print("\n╠");
        System.out.print("═".repeat(19));
        System.out.print("╬");
        System.out.print("═".repeat(21));
        System.out.print("╬");
        System.out.print("═".repeat(22));
        System.out.print("╬");
        System.out.print("═".repeat(19));
        System.out.print("╬");
        System.out.print("═".repeat(25));
        System.out.print("╣");
    }
    public void displayFooter() {
        System.out.print("\n╚");
        System.out.print("═".repeat(19));
        System.out.print("╩");
        System.out.print("═".repeat(21));
        System.out.print("╩");
        System.out.print("═".repeat(22));
        System.out.print("╩");
        System.out.print("═".repeat(19));
        System.out.print("╩");
        System.out.print("═".repeat(25));
        System.out.print("╝\n");
    }

    public void displayTable(short Rows, short TotalRecord, short CurrentPage, short Width) {
        System.out.print("\n០");
        System.out.print("~".repeat(Width));
        System.out.print("០");
        System.out.format("\n%10s%2d%3s%2.0f%87s%2d\n", "Page :", CurrentPage, "of", Math.ceil(TotalRecord / Rows), "Total record :", TotalRecord);
        System.out.print("០");
        System.out.print("~".repeat(Width));
        System.out.print("០\n");
    }
    public void displayTable(short Rows, short TotalRecord, short TablePage, short Width, String ... prompt) {
        System.out.print("\n០");
        System.out.print("~".repeat(Width));
        System.out.print("០\n");

        for (String str : prompt)
            System.out.print(str.concat(" "));
        System.out.println();

        System.out.print("០");
        System.out.print("~".repeat(Width));
        System.out.print("០\n");
    }
    public void displayData(Product p, short ListSize, short currentLoop) {
        System.out.format("\n%s%10s%10s%12s%10s%15s%8s%10s%10s%18s%8s", "║", p.ID, "|", p.Name, "|",
                p.UnitPrice, "|", p.Qty, "|", p.ImportDate, "║");
        if (currentLoop != ListSize) displayBody();
    }

    // # 4 Display for write
    public void displayCRUD(Product p) {
        System.out.print("\n╔");
        System.out.print("═".repeat(43));
        System.out.print("╗\n");
        System.out.format("%s%5s%20s%6s%13s\n", "║", "ID", ":", p.ID, "║");
        System.out.format("%s%7s%18s%10s%9s\n", "║", "Name", ":", p.Name, "║");
        System.out.format("%s%13s%12s%10s%9s\n", "║", "Unit Price", ":", p.UnitPrice, "║");
        System.out.format("%s%6s%19s%5s%14s\n", "║", "Qty", ":", p.Qty, "║");
        System.out.format("%s%16s%9s%14s%5s\n", "║", "Imported Date", ":", p.ImportDate, "║");
        System.out.print("╚");
        System.out.print("═".repeat(43));
        System.out.print("╝\n");
    }
    public void updateMenu() {
        System.out.print("\n╔");
        System.out.print("═".repeat(95));
        System.out.print("╗");
        System.out.format("\n%s%10s%20s%20s%20s%20s%6s", "║", "1. All", "2. Name", "3. Quantity", "4. UnitPrice", "5. Back to Menu", "║");
        System.out.print("\n╚");
        System.out.print("═".repeat(95));
        System.out.print("╝");
    }
    public String InputValue(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine();
    }
}
