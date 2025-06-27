
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author binh_2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Double> listFinalPosition = new ArrayList<>();
        for(int i = 0; i < 100000; i++){
            listFinalPosition.add(finalContact().x);
        }
        double total = 0;
        for(Double b:listFinalPosition){
            total += b;
        }
        System.out.println("E(R): "+total/listFinalPosition.size());
        
    }
    static Point finalContact(){
        Random r = new Random();
        double randomAngle = r.nextDouble(Math.PI);

        if (randomAngle < (Math.PI / 2)) {
            randomAngle += ((3 * Math.PI) / 4);
        }
        double randomX = r.nextDouble(0.5);
        Point p = new Point(randomX, 0, randomAngle);
        do {
            p = firstContact(p);
        } while (p.y != 0);
        return p;
    }
    static Point firstContact(Point a) {
        if ((a.angle >= 0 && a.angle <= Math.PI / 4) || (a.angle >= (2 * Math.PI - Math.PI / 4) && a.angle <= 2 * Math.PI)) {
            a.y = 1;
        } else if (a.angle >= Math.PI / 4 && a.angle <= Math.PI / 4 + Math.PI / 2) {
            a.x = 1;
        } else if (a.angle >= (3 * Math.PI) / 4 && a.angle <= Math.PI + Math.PI / 4) {
            a.y = 0;
        } else if (a.angle >= Math.PI + Math.PI / 4 && a.angle <= Math.PI + (3 * Math.PI) / 4) {
            a.x = 0;
        }
        a.angle = (a.angle + Math.PI) % (2 * Math.PI);
        return a;
    }
}
