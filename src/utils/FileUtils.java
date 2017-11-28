package utils;

import constant.Constant;
import entity.BodyData;
import entity.SerializableObject;
import entity.base.AbstractCustomBody;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    public static void writeToFile(List<AbstractCustomBody> components) {
        writeObjectToFile(converse(components));
    }

    public static List<SerializableObject> readFromFile() {
        return (List<SerializableObject>) readObjectFromFile();
    }

    private static List<SerializableObject> converse(List<AbstractCustomBody> abstractCustomBodyList){
        List<SerializableObject> result = new ArrayList<>();
        for (AbstractCustomBody abstractCustomBody: abstractCustomBodyList) {
            SerializableObject serializableObject = new SerializableObject();
            BodyData bodyData = ((BodyData)abstractCustomBody.getBody().getUserData());
            int type = bodyData.getType();
            float x = (abstractCustomBody.getBody().getPosition().y - abstractCustomBody.getSize()) * Constant.RATE;
            float y = (abstractCustomBody.getBody().getPosition().x - abstractCustomBody.getSize()) * Constant.RATE;
            float size = abstractCustomBody.getSize() * Constant.RATE * 2;
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
        //弹出文件选择框
        JFileChooser chooser = new JFileChooser();

        //后缀名过滤器
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Gizmo布局文件(*.gizmo)", "gizmo");
        chooser.setFileFilter(filter);

        int option = chooser.showSaveDialog(null);
        if(option==JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            String fname = chooser.getName(file);
            FileOutputStream out;
            if(!fname.contains(".gizmo")){
                file=new File(chooser.getCurrentDirectory(),fname+".gizmo");
            }
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

    }

    private static Object readObjectFromFile() {
        JFileChooser jfc=new JFileChooser();
        //后缀名过滤器
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Gizmo布局文件(*.gizmo)", "gizmo");
        jfc.setFileFilter(filter);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        Object temp=null;
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            JOptionPane.showMessageDialog(null,"文件读取失败，请检查文件格式！");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
