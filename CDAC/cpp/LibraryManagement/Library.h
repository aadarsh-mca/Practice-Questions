#ifndef LIBRARY_H
#define LIBRARY_H

#include <iostream>
#include <vector>
#include "Book.h"
using namespace std;

class Library {
private:
	vector<Book> books;
	int bookCounter;
public:
	Library(): bookCounter(1) {}

	void addBook() {
		Book newBook;
		newBook.id = bookCounter++;
		cout << "Enter book title: ";
		cin.ignore();
		cin >> newBook.title;
		cout << "Enter author name: ";
		cin >> newBook.author;
		newBook.isIssuedByAnyone = false;
		books.push_back(newBook);
		cout << "Book added successfully!\n";
	}

	void removeBook() {
		int id;
		cout << "Enter book ID to remove: ";
		cin >> id;
		for(auto it = books.begin(); it != books.end(); ++it) {
			if(it->id == id) {
				books.erase(it);
				cout << "Book removed successfully!\n";
				return;
			}
		}
		cout << "Book ID not found.\n";
	}

	void viewBooks() {
		cout << "\nAvailable Books:\n";
		for(const auto &book : books) {
			cout << "ID: " << book.id << " | Title: " << book.title << " | Author: " << book.author;
			if(book.isIssuedByAnyone) cout << " (Issued)";
			cout << endl;
		}
	}

	void borrowBook() {
		int id;
		cout << "Enter book ID to borrow: ";
		cin >> id;
		for(auto &book : books) {
			if(book.id == id && !book.isIssuedByAnyone) {
				book.isIssuedByAnyone = true;
				cout << "Book borrowed successfully!\n";
				return;
			}
		}
		cout << "Book not available or already issued.\n";
	}

	void returnBook() {
		int id;
		cout << "Enter book ID to return: ";
		cin >> id;
		for(auto &book : books) {
			if(book.id == id && book.isIssuedByAnyone) {
				book.isIssuedByAnyone = false;
				cout << "Book returned successfully!\n";
				return;
			}
		}
		cout << "Invalid book ID or book was not borrowed.\n";
	}
};

#endif // !LIBRARY_H