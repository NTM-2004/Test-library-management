package javaapplication41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manager extends User{

    public Manager(String id, String name, String phone, String email) {
        super(id, name, phone, email);
    }
    
    public void addBook(Book book){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Book.txt", true))){
            // Thêm sách vào file Book.txt
            writer.write(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor()  
                    + "," + book.getPublisher() + "," + book.getStatus());
            writer.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void deleteBook(Book book){
        String s = book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor()  
                    + "," + book.getPublisher() + "," + book.getStatus();
        
        try{
            // Tạo ArrayList để lưu những sách không muốn xóa
            ArrayList<String> l = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader("Book.txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    // Chỉ thêm những sách không muốn xóa
                    if(!line.trim().equals(s)){
                        l.add(line);
                    }
                }
            }
            // BufferedWriter khi không có tham số true sẽ xóa toàn bộ file cũ rồi ghi lại
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Book.txt"))){
                // Ghi lại những sách được lưu trong ArrayList vào file 
                for(String i : l){
                    writer.write(i);
                    writer.newLine();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void addReader(Reader reader, String currentDate){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Reader.txt", true))){
            // Thêm sách vào file Reader.txt
            // Thêm tham số currentDate để tính tiền phạt theo ngày hiện tại
            writer.write(reader.getId() + "," + reader.getName() + "," + reader.getPhone() + ","
                    + reader.getEmail() + reader.getFine(currentDate));
            writer.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void deleteReader(Reader read, String currentDate){
        String s = read.getId() + "," + read.getName() + "," + read.getPhone() + ","
                    + read.getEmail() + read.getFine(currentDate);
        
        try{
            // Tạo ArrayList để lưu những Người đọc không muốn xóa
            ArrayList<String> l = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader("Reader.txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    if(!line.trim().equals(s)){
                        l.add(line);
                    }
                }
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reader.txt"))){
                // Ghi lại những Người đọc được lưu trong ArrayList vào file
                for(String i : l){
                    writer.write(i);
                    writer.newLine();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // Thêm tham số currentDate để hiển thị tiền phạt hiện tại
    public void readerList(String currentDate){
        // In ra toàn bộ danh sách Người đọc
        try(BufferedReader read = new BufferedReader(new FileReader("Reader.txt"))){
            String line;
            while((line = read.readLine()) != null){
                String a[] = line.split(",");
                Reader reader = new Reader(a[0], a[1], a[2], a[3]);
                System.out.println(line + " " + reader.getFine(currentDate));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void bookList(){
        // In ra toàn bộ danh sách cuốn sách
        try(BufferedReader read = new BufferedReader(new FileReader("Book.txt"))){
            String line;
            while((line = read.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
