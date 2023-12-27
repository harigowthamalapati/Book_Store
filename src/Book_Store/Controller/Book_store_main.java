package Book_Store.Controller;

import java.util.Scanner;

import Book_Store.dao.BookCrud;
import Book_Store.dao.UserCrud;
import Book_Store.dto.Book;
import Book_Store.dto.User;

public class Book_store_main {

	public static void main(String[] args) throws Throwable {
		BookCrud bc = new BookCrud();
		UserCrud u = new UserCrud();
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		while (check) {
			System.out.println("Choose any one :\n 1.Book \n 2.User \n 3.Exit");
			int value = sc.nextInt();
			switch (value) {
			case 1: {
				while (check) {

					System.out.println("Book");
					System.out.println(
							" Operations you can perform are : \n 1.Insert Book \n 2.Update Book \n 3.Delete Book \n 4.Exit ");
					int oper1 = sc.nextInt();
					switch (oper1) {
					case 1:
						System.out.println(" Inserting the book ");
						System.out.println("Enter id ");
						int id = sc.nextInt();
						System.out.println(" Enter name ");
						String name = sc.next();
						System.out.println(" Enter author name ");
						String author = sc.next();
						System.out.println("Enter the price ");
						double price = sc.nextDouble();
						System.out.println(" entr Language ");
						String lang = sc.next();
						Book book = new Book(id, name, author, price, lang);
						bc.insertBook(book);
						break;
					case 2:
						System.out.println(" Updating the book ");
						System.out.println(" Enter the New Name to update ");
						String name1 = sc.next();
						System.out.println(" enter id where to update");
						int id1 = sc.nextInt();
						bc.updateBook(name1, id1);
						break;
					case 3:
						System.out.println("Deleting the book ");
						System.out.println(" enter the id to delete : ");
						int id11 = sc.nextInt();
						bc.deleteBook(id11);
						break;
					case 4:
						System.out.println("Exit");
						check = false;
					}

				}
				break;
			}
			case 2: {
				while (check) {
					System.out.println("User");
					System.out.println(
							"Operatyions you can perform are : \n 1.Register \n 2.Display Book available \n 3. Buy a Book \n 4.Exit");
					int oper2 = sc.nextInt();
					switch (oper2) {
					case 1: {
						System.out.println(" Registering User");
						System.out.println(" Enter id ");
						int id = sc.nextInt();
						System.out.println(" enter name ");
						String name = sc.next();
						System.out.println(" Enter ammount to add to your Wallet ");
						double wallet = sc.nextDouble();
						User user = new User(id, name, wallet);
						u.insertUser(user);
						break;
					}
					case 2: {
						System.out.println("Dispaly");
						bc.display();
						break;
					}
					case 3: {
						System.out.println(" Buyying a Book ");
						bc.display();
						System.out.println(" Enter your User ID");
						int id = sc.nextInt();
						System.out.println(" Enter the the id of the Book you wants to Buy...");
						int book_Id = sc.nextInt();
						bc.buyingABook(id, book_Id);
						break;
					}
					case 4: {
						System.out.println("Exit");
						check = false;
					}
					}
				}
			}
				break;
			case 3:
				System.out.println(" Exit ");
				check = false;

			}

		}

	}

}
