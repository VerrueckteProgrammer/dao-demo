package application;

import dao.DaoFactory;
import dao.ISellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        ISellerDao iSellerDao = DaoFactory.creatISellerDao();

        System.out.println("***Test #1 - findById***");
        Seller seller = iSellerDao.findById(3);
        System.out.println(seller);

        System.out.println("***Test #2 - findByDepartment***");
        Department department = new Department(2, null);
        List<Seller> list = iSellerDao.findByDepartment(department);
        for (Seller s:list) {
            System.out.println(s);

        }

        System.out.println("***Test #3 - findAll***");
        list = iSellerDao.findAll();
        for (Seller s:list) {
            System.out.println(s);
        }

        /*
        System.out.println("***Test #4 - insert***");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 5500.0, department);
        iSellerDao.insert(seller1);
        System.out.println("Inserted! ID = " + seller1.getId());
         */

        System.out.println("***Test #5 - update***");
        System.out.println("Seller to be updated: " + iSellerDao.findById(8));
        seller = iSellerDao.findById(8);
        seller.setName("Ruy");
        iSellerDao.update(seller);
        System.out.println("Updated seller: " + iSellerDao.findById(8));

        System.out.println("***Test #6 - delete***");
        list = iSellerDao.findAll();
        for (Seller s:list) {
            System.out.println(s);
        }
        iSellerDao.deleteById(10);
        list = iSellerDao.findAll();
        System.out.println("Seller has been deleted:");
        for (Seller s:list) {
            System.out.println(s);
        }
    }
}
