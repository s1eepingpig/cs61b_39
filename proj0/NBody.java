
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class NBody {


    public static double readRadius(String s) {
        StdDraw.enableDoubleBuffering();
        //initual the open file
        int line = 0;
        String scal = "";
        double scale = 0.0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(s));
            int body = 0;
            while (in.ready()) {
                scal = in.readLine();
                if (line == 0) {
                    body = Integer.parseInt(scal);
                }
                if (line == 1) {
                    scale = Double.parseDouble(scal);
                }
                if (line > body + 2) {
                    break;
                }
                line++;
            }
        } catch (Exception e) {

        }
        return scale;
    }

    public static Planet[] readPlanets(String FileName) {
        StdDraw.enableDoubleBuffering();
        Planet[] P;
        //Ps to save Planets
        ArrayList<Planet> Ps = new ArrayList<>();
        ArrayList<String> PPs = new ArrayList<>();
        //S to save String items
        HashSet<String> S = new HashSet<>();

        //catch valid items from file, and then save to S
        try {
            BufferedReader in = new BufferedReader(new FileReader(FileName));
            for (int i = 0; i < 7; i++) {
                String s = in.readLine();
                if (i > 1) {
                    S.add(s);
                    PPs.add(s);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Split S and construct Planets with these value
        for (String s : PPs) {
            String[] items = s.split("  *");
            Planet p = new Planet(
                    Double.parseDouble(items[1]),
                    Double.parseDouble(items[2]),
                    Double.parseDouble(items[3]),
                    Double.parseDouble(items[4]),
                    Double.parseDouble(items[5]),
                    items[6]);
            Ps.add(p);
        }

        P = new Planet[]{Ps.get(0), Ps.get(1), Ps.get(2), Ps.get(3), Ps.get(4)};


        return P;
    }


    public static void main(String[] args) {

//        String imageToDraw = "/images/starfield.jpg";
//        if (args.length == 0) {
//            System.out.println("Please supply two arguments, the First is T the second is dt.");
//        }
//        //Save two arguments and converse to double type
//        String strT = args[0];
//        String strdt = args[1];
//
//        double T = Double.parseDouble(strT);
//        double dt = Double.parseDouble(strdt);
//        //third argument is filename. And Using it to load the methods.
//        String filename = args[2];
//        Planet[] planets = readPlanets(filename);
//        double Radius = readRadius(filename);
//        double time = 0;
//        ArrayList<Double> tmpx = new ArrayList<>();
//        ArrayList<Double> tmpy = new ArrayList<>();
//        StdDraw.enableDoubleBuffering();
//
//        StdDraw.setScale(-Radius, Radius);
//        StdDraw.enableDoubleBuffering();
//        StdDraw.picture(0, 0, imageToDraw, Radius * 5, Radius * 5);
////        StdDraw.setCanvasSize(1024, 1024);
//        while (time < T) {
//            for (Planet p : planets) {
//                double x = p.calcNetForceExertedByX(planets);
//                double y = p.calcNetForceExertedByY(planets);
//                tmpx.add(x);
//                tmpy.add(y);
//            }
////            xForces = new xForces[]{tmpx.get(0),tmpx.get(1),tmpx.get(2),tmpx.get(3),tmpx.get(4)};
////            yForces = new yForces[]{tmpy.get(0),tmpy.get(1),tmpy.get(2),tmpy.get(3),tmpy.get(4)};
//            int f = 0;
//            StdDraw.enableDoubleBuffering();
//            for (Planet pp: planets) {
//
//                pp.update(time,tmpx.get(f),tmpy.get(f));
//                pp.draw();
//                f++;
//
//                StdDraw.show();
//            }
//            f=0;
//
//            time++;
//before these codes are something wrong, so I rewrite them below.

        //step one: accpet arguments from terminal and read Planets, Radius
        if (args.length == 0) {
            System.out.println("Plz input the arguments follow the java command");
        }
        //two arguments
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        //Step two: Drawing the background
        //Getting the scale
        StdDraw.setScale(-(radius), (radius));
        StdDraw.clear();
        String imageToDraw = "images/starfield.jpg";
        StdDraw.picture(0, 0, imageToDraw);
        StdDraw.show();

        //Step three:Drawing one planet(in Planet.java)

        //Step four: Drawing all of the planets static
        for (Planet p : planets) {
            p.draw();
        }

        //Step five: Moving the planets!
        StdDraw.enableDoubleBuffering();
        int time = 0;
        //double[] arr = new double[5];
//        ArrayList<Double> xForces = new ArrayList<>();
//        ArrayList<Double> yForces = new ArrayList<>();
        while (time<T){
            //init array for storing the planets netForces
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
               double xForce = planets[i].calcNetForceExertedByX(planets);
               double yForce = planets[i].calcNetForceExertedByY(planets);
                xForces[i]=xForce;
                yForces[i]=yForce;
            }
            //Updating the Force to each planet.
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(time,xForces[i],yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for (int i = 0; i < planets.length; i++) {
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }


    }


}
