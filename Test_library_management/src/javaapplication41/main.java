package javaapplication41;

public class main {

    public static void main(String[] args) {
        Reader b1 = new Reader("01", "Nguyen Tuan Minh", "0367305736", "minhlathan@gmail.com");
        Reader b2 = new Reader("02", "Vu Ngoc Lan", "0367663443", "olala@gmail.com");
        Reader b3 = new Reader("03", "O Mai Chi", "7267405736", "mlsmuhn@gmail.com");
        
        Book book1 = new Book("0001", "Yeu a di e", "Minh may man", "Kim Dong", "ready");
        Book book2 = new Book("0002", "Ai hieu thau long toi", "Minh may man", "Kim Dong", "ready");
        Book book3 = new Book("0003", "Con cho chay ngoai hanh tinh", "Minh may man", "Kim Dong", "ready");
        
        Manager a = new Manager("M01", "OlalaO", "0948750454", ">????@gmail.com");
        
        a.bookList();
        
    }
    
}
