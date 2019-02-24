/*
Class updated by Redmal on 2/23/2019.

This class will format coordinates from DMS to decimal
or decimal to DMS.
 */

public class FormatCoordinates {
    private final double PI = 3.14159265358979;
    private final double PI_half = 1.5707963267949;



    private double Haversine(double longitude1, double longitude2, double latitude1, double latitude2){
        double dbl_dLat, dbl_dLon, dbl_a, dbl_P;

        dbl_P = PI/180;
        dbl_dLat = dbl_P * (latitude2 - latitude1);   //convert to radians
        dbl_dLon = dbl_P * (longitude2 - longitude1); //convert to radians

        dbl_a = Math.sin(dbl_dLat / 2) * Math.sin(dbl_dLat / 2) +
                    Math.cos(latitude1 * dbl_P) * Math.cos(latitude2 * dbl_P) *
                            Math.sin(dbl_dLon / 2) * Math.sin(dbl_dLon / 2);
        return 0;
    }
}
/*
Function Haversine(dbl_Longitude1 As Double, dbl_Longitude2 As Double, dbl_Latitude1 As Double, dbl_Latitude2 As Double)

    'coords are in decimal unit format when they this function is called

    Dim dbl_dLat As Double
    Dim dbl_dLon As Double
    Dim dbl_a As Double
    Dim dbl_P As Double



    dbl_P = PI / 180
    dbl_dLat = dbl_P * (dbl_Latitude2 - dbl_Latitude1)      'to radians
    dbl_dLon = dbl_P * (dbl_Longitude2 - dbl_Longitude1)    'to radians

    dbl_a = Sin(dbl_dLat / 2) * Sin(dbl_dLat / 2) + _
            Cos(dbl_Latitude1 * dbl_P) * Cos(dbl_Latitude2 * dbl_P) * Sin(dbl_dLon / 2) * Sin(dbl_dLon / 2)

    Dim c As Double
    Dim dbl_Distance_KM As Double
    c = 2 * ArcTan2(Sqr(1 - dbl_a), Sqr(dbl_a))

    dbl_Distance_KM = 6371 * c

    'calcs in KM for now
    Haversine = dbl_Distance_KM

    'will convert to knots later

End Function

Function ArcTan2(X As Double, Y As Double) As Double

    Select Case X
        Case Is > 0
            ArcTan2 = Atn(Y / X)
        Case Is < 0
            ArcTan2 = Atn(Y / X) + PI * Sgn(Y)
            If Y = 0 Then ArcTan2 = ArcTan2 + PI
        Case Is = 0
            ArcTan2 = PI_2 * Sgn(Y)
    End Select

End Function

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

Function getFlightTime(fltDistance As Double, acSpeed As Double) As Double
    getFlightTime = ((fltDistance) / (acSpeed)) * 3600 ' distance times km/s

End Function
 */