/*
Class updated by Redmal on 2/23/2019.

This class will take a formatted list of
coordinates and build a KML file that
a user may load in a mapping application
(e.g. Google Earth) to see a visual
representation of a flight path.
 */


public class BuildKML {
    private String[] coordArray;; // will split coords into an ArrayList to handle
                                                             // each set of coords to build the KML

    public BuildKML(String coordList){
        // constructor splits coord list into an array
        // and initializes necessary variables
        coordArray = coordList.split(",", -1);




    }

    public void buildFile(){
        // create the KML file
    }

    public void openFileLocation(){
        // open the file location of the KML
        // once it's built, so that the user may
        // easily access it
    }

}
