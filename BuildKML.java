/*
Class updated by Redmal on 3/6/2019.

This class will take a formatted list of
coordinates and build a KML file that
a user may load in a mapping application
(e.g. Google Earth) to see a visual
representation of a flight path.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BuildKML extends FormatCoordinates {
    private String[] coordArray; // will split coords into an Array to handle
                                 // each set of coords to build the KML
    String kml_filePath = "C:\\Users\\HarryPooper\\Desktop\\KMLs\\";

    public BuildKML(String coordList){
        // constructor splits coord list into an array
        // and initializes necessary variables

        coordArray = coordList.split(",");

        try {
            buildFile();
            openFileLocation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buildFile() throws IOException {
        // create the KML file
        File file = new File(kml_filePath + "myKML.kml");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write("<?xml version='1.0' encoding='UTF-8'?>");
        writer.write("<kml xmlns='http://www.opengis.net/kml/2.2' xmlns:gx='http://www.google.com/kml/ext/2.2' xmlns:kml='http://www.opengis.net/kml/2.2' xmlns:atom='http://www.w3.org/2005/Atom'>");
        writer.write("<Document>");
        writer.write("<name>Redmal Flight.kml</name>");
        writer.write("    <Style id='orange-5px'>");
        writer.write("        <LineStyle>");
        writer.write("            <color>ff00aaff</color>");
        writer.write("            <width>5</width>");
        writer.write("        </LineStyle>");
        writer.write("    </Style>");
        writer.write("    <Placemark>");
        writer.write("        <name>Redmal Flight</name>");
        writer.write("        <styleUrl>#orange-5px</styleUrl>");
        writer.write("        <LineString>");

        // Coords are in order of Long/Lat,... not Lat/Long for Google Earth KMLs

        writer.write("            <tessellate>1</tessellate>");
        writer.write("            <coordinates>");

        writer.write(toDecimalFormat(coordArray[1]) + "," + toDecimalFormat(coordArray[0]) + ",0"); // initiating first line of coords, first set

        for (int i = 2; i < coordArray.length; i++){
            writer.write(toDecimalFormat(coordArray[i]) + "," + toDecimalFormat(coordArray[i+1]) + ",0");
            i += 1;
        }

        writer.write("        </coordinates>");

        writer.write("    </LineString>");
        writer.write("</Placemark>");
        writer.write("</Document>");
        writer.write("</kml>");

        writer.close();
    }

    public void openFileLocation() throws IOException{
        // open the file location of the KML
        // once it's built, so that the user may
        // easily access it
        Runtime.getRuntime().exec("explorer.exe /open," + kml_filePath);
    }

}
