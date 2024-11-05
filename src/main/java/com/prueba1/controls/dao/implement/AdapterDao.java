package com.prueba1.controls.dao.implement;

import com.prueba1.list.LinkedList;
import com.google.gson.Gson;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AdapterDao<T> implements InterfazDao<T> {
    private Class<T> clazz;
    private Gson g;
    public static String URL = "media/";

    public AdapterDao(Class<T> clazz) {
        this.clazz = clazz;
        this.g = new Gson();
    }

    public T get(Integer id) throws Exception {
        LinkedList<T> list = listAll(); // Implementar según sea necesario
        if(!list.isEmpty()){
            T[] matriz = list.toArray();
            return matriz[id - 1];
        }
        return null;
    }


//to_list
    public LinkedList<T> listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile();
            T[] matrix = g.fromJson(data, com.google.gson.reflect.TypeToken.getArray(clazz).getType());
            list.toList(matrix);
        } catch (Exception e) {
            System.out.println("Error al leer la lista: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public void merge(T object, Integer index) throws Exception {
        LinkedList<T> list = listAll();
        list.update(object, index);
        String info = g.toJson(list.toArray());
        saveFile(info);
    }

    public void persist(T object) throws Exception {
        System.out.println("Persisting object: " + object);
        LinkedList<T> list = listAll();
        if (list == null) {
            System.out.println("La lista es null.");
            return;
        }
        list.add(object);
        String info = g.toJson(list.toArray());
        System.out.println("Escribiendo datos al archivo: " + info);
        saveFile(info);
    }

    private String readFile() throws Exception {
        Scanner in = new Scanner(new FileReader(URL + clazz.getSimpleName() + ".json"));
        StringBuilder sb = new StringBuilder();

        while (in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }

    private void saveFile(String data) throws Exception {
        File directory = new File(URL);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        FileWriter file = new FileWriter(URL + clazz.getSimpleName() + ".json");
        file.write(data);
        file.flush();
        file.close();
    }
    
}
