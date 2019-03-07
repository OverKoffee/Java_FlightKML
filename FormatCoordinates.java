/*
Class updated by Redmal on 3/6/2019.

This class will format coordinates from DMS to decimal
or decimal to DMS.

Will be testing conversion with coords of Dragon Gate in San Francisco:
    37°47'27.1"N 122°24'20.2"W
    37.790865, -122.405608
 */

public class FormatCoordinates {

    public double Haversine(double longitude1, double longitude2, double latitude1, double latitude2){
        double dbl_dLat, dbl_dLon, dbl_a, dbl_Distance_KM;

        dbl_dLat = Math.toRadians (latitude2 - latitude1);   //convert to radians
        dbl_dLon = Math.toRadians (longitude2 - longitude1); //convert to radians

        dbl_a = Math.sin(dbl_dLat / 2) * Math.sin(dbl_dLat / 2) +
                    Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) *
                            Math.sin(dbl_dLon / 2) * Math.sin(dbl_dLon / 2);

        dbl_Distance_KM = 6371 * (2 * Math.atan2(Math.sqrt(dbl_a), Math.sqrt(1 - dbl_a)));

        return dbl_Distance_KM;
    }

    public double getFlightTime(double fltDistance, double acSpeed){
        return (fltDistance / acSpeed) * 3600;  //distance multiplied by km/s
    }

    public String toDecimalFormat(String degreeCoords){
        double degrees, minutes, seconds;
        double degrees2, minutes2, seconds2;
        double decimalTotal;
        double decimalTotal2;

        String coordSplit[];

        //degreeCoords is passed in a format similar to 37° 47' 27.1" N
        //                                              [0] [1] [2]  [3]

        degreeCoords = degreeCoords.replace('°', ' ');
        degreeCoords = degreeCoords.replace('\'', ' ');
        degreeCoords = degreeCoords.replace('\"', ' ');

        coordSplit = degreeCoords.split("\\s+"); //splits whitespace &/or consecutive whitespace

        // set values from DMS format to add up for decimal format
        // North/South coord
        degrees = Double.valueOf(coordSplit[0]);
        minutes = Double.valueOf(coordSplit[1]);
        seconds = Double.valueOf(coordSplit[2]);

        // East/West coord
        degrees2 = Double.parseDouble(coordSplit[4]);
        minutes2 = Double.parseDouble(coordSplit[5]);
        seconds2 = Double.parseDouble(coordSplit[6]);

        if (coordSplit[3].equals("S")){
            decimalTotal = -1 * (degrees + minutes + seconds);
        } else {
            decimalTotal = degrees + minutes + seconds;
        }

        if (coordSplit[7].equals("W")){
            decimalTotal2 = -1 * (degrees2 + minutes2 + seconds2);
        } else {
            decimalTotal2 = degrees2 + minutes2 + seconds2;
        }

        return decimalTotal2 + "," + decimalTotal;
    }
}