package fr.cnes.sonar.report.exporters;

import fr.cnes.sonar.report.exceptions.BadExportationDataTypeException;
import fr.cnes.sonar.report.exceptions.UnknownParameterException;
import fr.cnes.sonar.report.input.Params;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Exports the report in .xml format
 * @author lequal
 */
public class XmlExporter implements IExporter {
    /**
     * Overridden export for xml
     * @param data Data to export as String
     * @param params Program's parameters
     * @param path Path where to export the file
     * @param filename Name of the file to export
     * @throws BadExportationDataTypeException resources format is incorrect
     * @throws UnknownParameterException report.path is not set
     * @throws IOException ...
     */
    @Override
    public void export(Object data, Params params, String path, String filename)
            throws BadExportationDataTypeException, UnknownParameterException, IOException {

        // check if the resources format is correct
        if(!(data instanceof String)) {
            throw new BadExportationDataTypeException();
        }
        // resources casting
        String string = (String) data;

        // set relevant variables
        String filePath = String.format("%s/%s.xml", path, filename);

        // file to write
        File xmlFile = new File(filePath);

        // prevent file's allocation leaks
        try(FileWriter fileWriter = new FileWriter(xmlFile, false)) {
            // false to overwrite.
            fileWriter.write(string);
        }

    }
}
