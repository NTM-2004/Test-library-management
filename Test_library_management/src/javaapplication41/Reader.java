package javaapplication41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reader extends User{
    int fine;

    public Reader(String id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    public int getFine(String currentDate) {
        fine = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("Order.txt"))){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String line;
            while((line = reader.readLine()) != null){
                String a[] = line.split(",");
                if(a[4] == this.getId()){
                    try{
                        Date current = sdf.parse(currentDate);
                        Date reDate = sdf.parse(a[3]);

                        int distance = (int)(current.getTime() - reDate.getTime());
                        if(distance > 0){
                            fine += distance *10000;
                        }
                    }
                    catch(ParseException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return fine;
    }
    
    public void addOrder(Order order){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Order.txt", true))){
            writer.write(order.getId() + " " + order.getIsbn() + " " + order.getBorrowedDate() 
                    + " " + order.getReturnDate() + " " + order.getReaderId());
            writer.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void deleteOrder(Order order){
        String s = order.getId() + " " + order.getIsbn() + " " + order.getBorrowedDate() 
                    + " " + order.getReturnDate() + " " + order.getReaderId();
        
        try{
            // Tạo ArrayList để lưu những đơn mượn không muốn xóa
            ArrayList<String> l = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader("Order.txt"))){
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
                // Ghi lại những đơn mượn được lưu trong ArrayList vào file 
                for(String i : l){
                    writer.write(i);
                    writer.newLine();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void orderList(){
        // In ra toàn bộ danh sách đơn mượn
        try(BufferedReader read = new BufferedReader(new FileReader("Order.txt"))){
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
