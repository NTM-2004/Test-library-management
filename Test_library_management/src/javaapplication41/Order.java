package javaapplication41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {
    private String id, readerId, borrowedDate, returnDate, isbn;

    public Order(String id, String readerId, String borrowedDate, String returnDate, String isbn) {
        this.id = id;
        this.readerId = readerId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.isbn = isbn;
        try{
            ArrayList<String> l = new ArrayList<>();
            // Giả sử thư viện chỉ có 1 cuốn sách mỗi loại
            // Khi làm đơn mượn thì ghi đè cả file
            try(BufferedReader reader = new BufferedReader(new FileReader("Book.txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    String a[] = line.split(",");
                    // tìm sách bằng isbn và chuyển status thành "not ready"
                    if(a[0] == isbn){
                        a[4] = "not ready";
                    }
                    l.add(line);
                }
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reader.txt"))){
                for(String i : l){
                    writer.write(i);
                    writer.newLine();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getIsbn() {
        return isbn;
    }
        
}
