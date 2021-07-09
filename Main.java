package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	//SERIALIZATION
        //это представление обьекта и/или типа в двоичном виде
        //для записи в файл
        //передачи по сети

        //DESERIALIZATION
        //преобразование обьекта или типа из двоичного типа в
        //тип или обькт програмирования

        File f = new File("1.bin");
        if (!f.exists()){
            f.createNewFile();
        }

        //Пример Сериализации
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeInt(123);
        oos.writeDouble(24.58);
        //не все обьекты java поддаются сериализации
        //а только те классы которых реализуют интерфейс Serializable
        User u = new User();
        u.setAge(13);
        u.setName("Vasya");
        u.job = new Job();
        u.job.name = "programmer";
        u.job.salary = 10000000;
        oos.writeObject(u);

        ArrayList<User> users = new ArrayList<>();
        for (int i =0; i < 20; i++){
            User user = new User();
            user.setAge(i);
            users.add(user);
        }
        oos.writeObject(users);

        oos.close();
        fos.close();
        //Десериализация
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        //ЧТЕНИЕ ДАННЫХ ИЗ БИНАРНОГО ПОТОКА В ЧАСТНОСТИ ФАЙЛА
        //ДОЛЖНО ПРОИСХОДИТЬ В ТОМ ЖЕ ПОРЯДКЕ ЧТО И ПРОИЗВЕДЕНА ЗАПИСЬ
        int x = ois.readInt();
        double d = ois.readDouble();
        User u2 = (User) ois.readObject();
        ArrayList<User> usersList = (ArrayList<User>)
                                    ois.readObject();

        System.out.println(x);
        System.out.println(d);
        System.out.println(u2.name);
        System.out.println(u2.age);
        //System.out.println(u2.job.name);
        //System.out.println(u2.job.salary);
        usersList.stream().forEach((user -> System.out.println(user.getAge())));

        ois.close();
        fis.close();
    }
}
