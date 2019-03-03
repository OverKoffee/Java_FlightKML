/*
Class updated by Redmal on 3/2/2019.

This class will format coordinates from DMS to decimal
or decimal to DMS.
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
}


/*

Function Convert_Decimal(Degree_Deg As String) As Double

    Dim degrees As Double
    Dim minutes As Double
    Dim seconds As Double

    ' Set degree to value before degree symbol of Argument Passed.
    degrees = Val(Left(Degree_Deg, InStr(1, Degree_Deg, ChrW(&HB0)) - 1))

    ' Set minutes to the value between the degree symbol and the apostrophe
    ' then is divided by 60. The Val function converts the text string to a number.
    minutes = Val(Mid(Degree_Deg, InStr(1, Degree_Deg, ChrW(&HB0)) + 1, InStr(1, Degree_Deg, "'") - InStr(1, Degree_Deg, ChrW(&HB0)) - 1)) / 60

    ' Set seconds to the number to the right of the apostrophe that is
    ' converted to a value and then divided by 3600.
    seconds = Val(Mid(Degree_Deg, InStr(1, Degree_Deg, "'") + 1, Len(Degree_Deg) - InStr(1, Degree_Deg, "'") - 2)) / 3600

    'adds the 3 values together to get the total for the decimal coordinate
    Convert_Decimal = degrees + minutes + seconds

End Function

 */