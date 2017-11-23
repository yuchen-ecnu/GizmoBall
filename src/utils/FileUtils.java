package utils;

import constant.Constant;
import entity.SerializableObject;
import entity.base.AbstractCustomBody;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 文件 IO 工具类
 * @author Jack Chen
 * @date 2017/11/21
 */
public class FileUtils {
    public static void main(String[] args) {
        readFromFile();
    }
    public static void writeToFile(List<AbstractCustomBody> components) {
        writeObjectToFile(converse(components));
    }

    public static void readFromFile() {
        List<AbstractCustomBody> components = (List<AbstractCustomBody>) readObjectFromFile();
        System.out.println(components);
    }

    private static List<SerializableObject> converse(List<AbstractCustomBody> abstractCustomBodyList){
        List<SerializableObject> result = new ArrayList<>();
        for (AbstractCustomBody abstractCustomBody: abstractCustomBodyList) {
            SerializableObject serializableObject = new SerializableObject();
            int type = Integer.parseInt(abstractCustomBody.getBody().getUserData().toString());
            float x = (abstractCustomBody.getBody().getPosition().x - abstractCustomBody.getSize()) * Constant.RATE;
            float y = (abstractCustomBody.getBody().getPosition().y - abstractCustomBody.getSize()) * Constant.RATE;
            float size = abstractCustomBody.getSize();
            float direction = abstractCustomBody.getBody().getAngle();
            Color color = abstractCustomBody.getColor();
            serializableObject.setType(type);
            serializableObject.setX(x);
            serializableObject.setY(y);
            serializableObject.setSize(size);
            serializableObject.setColor(color);
            serializableObject.setDirection(direction);
            result.add(serializableObject);
        }
        return result;
    }


    private static void writeObjectToFile(Object object) {
        File file =new File("test.gizmo");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(object);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
        }
    }

    private static Object readObjectFromFile() {
        Object temp=null;
        File file =new File("test.gizmo");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
