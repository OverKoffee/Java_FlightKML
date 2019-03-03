/*
Class updated by Redmal on 3/2/2019.

This class will format coordinates from DMS to decimal
or decimal to DMS.

Will be testing conversion with coords of Dragon Gate in San Francisco:
    37°47'27.1"N 122°24'20.2"W
    37.790865, -122.405608
 */

public class FormatCoordinates {

    private double Haversine(double longitude1, double longitude2, double latitude1, double latitude2){
        double dbl_dLat, dbl_dLon, dbl_a, dbl_Distance_KM;

        dbl_dLat = Math.toRadians (latitude2 - latitude1);   //convert to radians
        dbl_dLon = Math.toRadians (longitude2 - longitude1); //convert to radians

        dbl_a = Math.sin(dbl_dLat / 2) * Math.sin(dbl_dLat / 2) +
                    Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) *
                            Math.sin(dbl_dLon / 2) * Math.sin(dbl_dLon / 2);

        dbl_Distance_KM = 6371 * (2 * Math.atan2(Math.sqrt(1 - dbl_a), Math.sqrt(dbl_a)));

        return dbl_Distance_KM;
    }

    private double getFlightTime(double fltDistance, double acSpeed){
        return (fltDistance / acSpeed) * 3600;  //distance multiplied by km/s
    }

    private double toDecimalFormat(String degreeCoords){
        double degrees, minutes, seconds;
        String coordSplit[];

        //degreeCoords is passed in a format similar to 37°47'27.1"N

        degreeCoords = degreeCoords.replace('°', ' ');
        degreeCoords = degreeCoords.replace('\'', ' ');
        degreeCoords = degreeCoords.replace('\"', ' ');

        coordSplit = degreeCoords.split("\\s+"); //splits whitespace &/or consecutive whitespace

        degrees = Double.parseDouble(coordSplit[0]);
        minutes = Double.parseDouble(coordSplit[1]);
        seconds = Double.parseDouble(coordSplit[2]);

        return degrees+minutes+seconds;
    }
}