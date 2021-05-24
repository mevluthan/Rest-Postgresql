package com.example.product;

import java.util.ArrayList;
import java.util.List;

public class KullaniciCRUD {
    private static KullaniciCRUD instance;
    private static List<Kullanici> data = new ArrayList<>();

    static {
        data.add(new Kullanici(1,"asd", "zxc",123,"evet"));
        data.add(new Kullanici(2,"zxc", "asd",321,"hayir"));
    }

    private KullaniciCRUD() {

    }

    public static KullaniciCRUD getInstance() {
        if (instance == null) {
            instance = new KullaniciCRUD();
        }

        return instance;
    }

    public List<Kullanici> listAll() {
        return new ArrayList<Kullanici>(data);
    }

    public int add(Kullanici product) {
        int newId = data.size() + 1;
        product.setId(newId);
        data.add(product);

        return newId;
    }

    public Kullanici get(int id) {
        Kullanici productToFind = new Kullanici(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }



    public boolean delete(int id) {
        Kullanici productToFind = new Kullanici(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);

            return true;
        }

        return false;
    }

    public boolean update(Kullanici product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }
}
