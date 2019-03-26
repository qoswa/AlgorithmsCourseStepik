package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Point> segmentsList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
      System.out.print("Enter number of segments:");


        int n = in.nextInt();
        for(int i = 0 ; i < n ; i++){
            int start,end;
            start = in.nextInt();
            end = in.nextInt();
            segmentsList.add(new Point(start,end));
        }

        segmentsList.sort(new Comparator<Point>() {
            public int compare(Point x1, Point x2) {
                int result = Double.compare(x1.getX(), x2.getX());

                return result;
            }
        });



        ArrayList<Double> points = new ArrayList<>();
        int numberOfPoints = 0;
        double lastPoint = segmentsList.get(0).getY();
        for(int i = 0 ; i < n ; i ++){
            if(segmentsList.get(i).getX()<=lastPoint){
                if(segmentsList.get(i).getY()<=lastPoint){
                    lastPoint = segmentsList.get(i).getY();
                    if (i == n -1){
                        numberOfPoints++;
                        points.add(lastPoint);
                    }
                } else if(segmentsList.get(i).getY()>lastPoint){
                     if (i == n -1){
                        numberOfPoints++;
                        points.add(lastPoint);
                    }
                }

            } else {
                numberOfPoints++;
                points.add(lastPoint);
                if(i == n-1){
                    lastPoint = segmentsList.get(i).getY();
                    numberOfPoints++;
                    points.add(lastPoint);
                } else {
                    lastPoint = segmentsList.get(i).getY();
                }
            }

        }


        System.out.println(numberOfPoints);
        for(int i = 0 ; i < points.size();i++){
            System.out.print(points.get(i).intValue()+ " ");
        }
    }



}
