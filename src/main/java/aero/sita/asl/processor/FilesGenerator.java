package aero.sita.asl.processor;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

/**
 * Custom Generator class used to update the name of the file.
 * @author praveen.khare
 *
 */
public class FilesGenerator implements FileNameGenerator {

    /**
     * created file extension(ERROR, OUTPUT and PROCESSED).
     */
    private String fileExtension;
    
    /**
     * Getter for fileExtension.
     * @return fileExtension, never null.
     */
    public String getFileExtension() {
        return fileExtension;
    }
    
    /**
     * Getter for fileExtension.
     * @param fileExtension , not null.
    */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
    
    /**
     * Method to update the filename by FileWritingMessageHandler.
     * @param message , not null
     * @return the updated file name , never null
     */
    public String generateFileName(Message<?> message) {
        String fileName = message.getHeaders().get("file_name").toString();
        fileName = fileName.substring(0, fileName.indexOf("."));
        return fileName + "." + fileExtension;
    }
}
